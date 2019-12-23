#!/bin/bash
sudo docker --version

for i in `seq 3`
do
{
	sudo docker start worker$i
	sudo docker cp Sx/Sx$i.txt worker$i:/tmp
	sudo docker exec -i worker$i /bin/bash -c "cd tmp && mkdir -p SM SS"
	sudo docker cp SLAVE.jar worker$i:/tmp
}&
done
wait

for i in `seq 3`
do
{
	sudo docker exec -i worker$i /bin/bash -c "source ~/.bashrc && cd tmp && java -jar SLAVE.jar $i 1"
}&
done
wait

mkdir -p RM

for i in `seq 3`
do
{
	sudo docker exec -i worker$i /bin/bash -c "source ~/.bashrc && cd tmp && java -jar SLAVE.jar $i 2"
	sudo docker cp worker$i:/tmp/SS/RM$i.txt ~/java/Java_homework/CNS2/RM
}&
done
wait

java -jar MASTER.jar