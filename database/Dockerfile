FROM postgres:17.2-alpine

# Les variables d'environnement sont maintenant définies dans le fichier environment.properties
# et passées via docker-compose ou -e lors de l'exécution

# Copier les scripts d'init dans le dossier attendu par l'entrée officielle
COPY docker-entrypoint-initdb.d/ /docker-entrypoint-initdb.d/
