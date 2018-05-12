cd postgres
docker build -t ricardojob/banco .
cd ..
mvn clean package 
docker build -t ricardojob/app .
docker run -p 5433:5432 --name banco -d ricardojob/banco 
docker run -p 8081:8080 --link banco:host-banco --name app -d ricardojob/app
