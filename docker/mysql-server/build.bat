:: docker build -t mysql-importer .
:: docker run -d --name mysql-import-container -p 3306:3306 mysql-importer


docker volume create --name mysql-db-data
docker build -t mysql-db:latest .