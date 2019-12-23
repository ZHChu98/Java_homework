# command references

单纯地怕忘了...

## docker image

sudo docker pull yiping999/ub-jdk8:1.1

## jar

jar -cvfm SLAVE.jar META-INF\MANIFEST.MF SLAVE.class
jar -cvfm MASTER.jar META-INF\MANIFEST.MF MASTER.class MASTER\$1.class MASTER\$Word.class MASTER\$Record.class
jar -cvfm BASIC.jar META-INF\MANIFEST.MF BASIC.class BASIC\$1.class BASIC\$Word.class BASIC\$Record.class

## disable SSH check

ssh -o "StrictHostKeyChecking=no" user@host
but it seems this command not work as expected

## create worker

sudo docker run -dit --name worker{$Num} --network charbridge yiping999/ub-jdk8:1.1 bash

## demo

java -jar BASIC.jar corpus
java -jar MASTER.jar corpus