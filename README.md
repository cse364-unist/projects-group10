# How to run this program

docker build -t test .  //Build image

docker run --name app -it test  //Run container

mongod  //Run MongoDB

docker exec -it app /bin/bash  //Access bash

sh run.sh  //Execute run.sh

docker exec -it app /bin/bash  //Access bash

