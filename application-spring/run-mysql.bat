docker run --detach --name mysql1 -p 33060:3306 -v mysql-db-data:/opt/mysql/data mysql-db:latest

::docker exec -it mysql1 /bin/bash
::mysql -u myuser -p