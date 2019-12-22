# command references

单纯地怕忘了...

## 

sudo docker pull yiping999/ub-jdk8:1.1

## jar

jar -cvfm SLAVE.jar META-INF\MANIFEST.MF SLAVE.class

## disable SSH check

ssh -o "StrictHostKeyChecking=no" user@host

## create worker

sudo docker run -dit --name worker{$Num} --network charbridge yiping999/ub-jdk8:1.1 bash

## .sh for

for i in `seq 10`
do
 echo $i
done

jdk1.8.0_231
