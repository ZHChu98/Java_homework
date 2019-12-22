#!/bin/bash

sudo docker --version

for i in `seq 3`
do
	sudo docker exec -it worker$i /bin/bash -c "cd tmp && rm -r SM SS"
done