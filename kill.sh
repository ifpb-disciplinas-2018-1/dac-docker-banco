docker rmi -f $(docker image ls ricardojob/* -q)
docker kill $(docker container ls -a -q)
docker rm banco
docker rm app
