#!/bin/bash
sudo docker --version

if [ $1 = "file" ]
then
	echo "delete intermediate files"
	for i in `seq 3`
	do
	{
		sudo docker exec -i worker$i /bin/bash -c "cd tmp && rm -r SLAVE.jar Sx$i.txt SM SS"
	}&
	done
	wait
elif [ $1 = "worker" ]
then
	echo "stop containers"
	for i in `seq 3`
	do
	{
		sudo docker stop worker$i
	}&
	done
	wait
fi