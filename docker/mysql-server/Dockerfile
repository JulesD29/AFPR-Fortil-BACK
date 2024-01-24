# Utilisez une image MySQL officielle en tant qu'image de base
FROM mysql:latest

# Définir les variables d'environnement pour la configuration MySQL
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=mydatabase
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=mypassword

# Copier le fichier SQL à importer dans le conteneur
COPY mydatabase.sql /docker-entrypoint-initdb.d/

# Exposer le port MySQL (par défaut, le port est 3306)
EXPOSE 3306
