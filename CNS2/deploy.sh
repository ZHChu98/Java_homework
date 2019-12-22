#!/bin/bash
sudo docker --version

for i in `seq 3`
do
	sudo docker start worker$i
	sudo docker cp Sx/Sx$i.txt worker$i:/tmp
	sudo docker exec -it worker$i /bin/bash -c "cd tmp && mkdir -p SM SS"
	sudo docker cp SLAVE.jar worker$i:/tmp
	sudo docker exec -it worker$i /bin/bash -c "source ~/.bashrc && cd tmp && java -jar SLAVE.jar $i 1 Sx$i.txt"
done

for i in `seq 3`
do
	sudo docker exec -it worker$i /bin/bash -c "source ~/.bashrc && cd tmp && java -jar SLAVE.jar $i 2"
done
