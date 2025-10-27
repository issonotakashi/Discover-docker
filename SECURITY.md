# Configuration sécurisée pour Discover-Docker

## Variables d'environnement nécessaires

### Base de données PostgreSQL
- POSTGRES_DB: Nom de la base de données
- POSTGRES_USER: Utilisateur de la base de données  
- POSTGRES_PASSWORD: Mot de passe de la base de données

### Application Spring Boot
- SPRING_DATASOURCE_URL: URL de connexion JDBC
- SPRING_DATASOURCE_USERNAME: Nom d'utilisateur pour la datasource
- SPRING_DATASOURCE_PASSWORD: Mot de passe pour la datasource

### Serveur
- SERVER_PORT: Port du serveur (défaut: 8080)
- SPRING_APPLICATION_NAME: Nom de l'application

## Sécurité Ansible

### Variables chiffrées
Les variables sensibles sont stockées dans `ansible/group_vars/vault.yml` et chiffrées avec Ansible Vault.

### Commandes utiles
```bash
# Chiffrer le fichier de variables sensibles
ansible-vault encrypt ansible/group_vars/vault.yml

# Déchiffrer le fichier
ansible-vault decrypt ansible/group_vars/vault.yml

# Éditer le fichier chiffré
ansible-vault edit ansible/group_vars/vault.yml

# Exécuter le playbook avec le vault
ansible-playbook -i inventories/setup.yml playbook.yml --ask-vault-pass
```

### Bonnes pratiques
- Ne jamais commiter les fichiers .env avec de vraies valeurs
- Utiliser des mots de passe forts et uniques
- Chiffrer les variables sensibles avec Ansible Vault
- Utiliser des variables d'environnement pour les secrets
