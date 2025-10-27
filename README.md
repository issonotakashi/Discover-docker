# Discover Docker Project

## Configuration des variables d'environnement

### Variables disponibles

Les variables d'environnement suivantes peuvent être configurées :

#### Base de données
- `DB_HOST` : Hôte de la base de données (défaut: my-database)
- `DB_PORT` : Port de la base de données (défaut: 5432)
- `DB_NAME` : Nom de la base de données (défaut: db)
- `DB_USERNAME` : Nom d'utilisateur de la base de données (défaut: usr)
- `DB_PASSWORD` : Mot de passe de la base de données (défaut: pwd)

#### Application
- `SERVER_PORT` : Port du serveur (défaut: 8080)
- `SPRING_APPLICATION_NAME` : Nom de l'application (défaut: simpleapi)

#### PostgreSQL (pour Docker)
- `POSTGRES_DB` : Nom de la base de données PostgreSQL (défaut: db)
- `POSTGRES_USER` : Utilisateur PostgreSQL (défaut: usr)
- `POSTGRES_PASSWORD` : Mot de passe PostgreSQL (défaut: pwd)

### Utilisation

#### Avec Docker Compose
```bash
# Utiliser les valeurs par défaut
docker-compose up

# Ou définir des variables personnalisées
export DB_PASSWORD=mon_mot_de_passe_secret
export POSTGRES_PASSWORD=mon_mot_de_passe_secret
docker-compose up
```

#### Avec des fichiers .env
Créez un fichier `.env` à la racine du projet avec vos valeurs :
```bash
DB_PASSWORD=mon_mot_de_passe_secret
POSTGRES_PASSWORD=mon_mot_de_passe_secret
SERVER_PORT=9090
```

#### Exemple de fichier .env
```env
# Database Configuration
DB_HOST=my-database
DB_PORT=5432
DB_NAME=db
DB_USERNAME=usr
DB_PASSWORD=pwd

# Application Configuration
SERVER_PORT=8080
SPRING_APPLICATION_NAME=simpleapi

# PostgreSQL Environment Variables (for Docker)
POSTGRES_DB=db
POSTGRES_USER=usr
POSTGRES_PASSWORD=pwd
```

### Sécurité

⚠️ **Important** : Ne jamais commiter les fichiers `.env` ou `environment.properties` contenant des mots de passe réels. Ces fichiers sont exclus du contrôle de version via `.gitignore`.
