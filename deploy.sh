#!/bin/bash

# Script de déploiement sécurisé pour Discover-Docker
# Usage: ./deploy.sh [vault_password]

set -e

# Couleurs pour les messages
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Fonction pour afficher les messages
log_info() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

log_warn() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Vérifier que nous sommes dans le bon répertoire
if [ ! -f "ansible/playbook.yml" ]; then
    log_error "Ce script doit être exécuté depuis la racine du projet Discover-Docker"
    exit 1
fi

# Vérifier que le fichier vault existe
if [ ! -f "ansible/group_vars/vault.yml" ]; then
    log_error "Le fichier vault.yml n'existe pas. Créez-le d'abord avec vos variables sensibles."
    exit 1
fi

# Demander le mot de passe du vault si non fourni
if [ -z "$1" ]; then
    log_warn "Mot de passe du vault requis pour déchiffrer les variables sensibles"
    read -s -p "Entrez le mot de passe du vault: " VAULT_PASSWORD
    echo
else
    VAULT_PASSWORD="$1"
fi

# Créer un fichier temporaire pour le mot de passe
TEMP_VAULT_FILE=$(mktemp)
echo "$VAULT_PASSWORD" > "$TEMP_VAULT_FILE"

# Fonction de nettoyage
cleanup() {
    rm -f "$TEMP_VAULT_FILE"
}

# S'assurer que le nettoyage se fait même en cas d'erreur
trap cleanup EXIT

log_info "Démarrage du déploiement sécurisé..."

# Exécuter le playbook Ansible avec le vault
cd ansible
if ansible-playbook -i inventories/setup.yml playbook.yml --vault-password-file "$TEMP_VAULT_FILE"; then
    log_info "Déploiement réussi !"
    log_info "L'API est accessible sur : http://sami.semlali.takima.cloud:8080/students"
else
    log_error "Échec du déploiement"
    exit 1
fi

log_info "Nettoyage des fichiers temporaires..."
cleanup

log_info "Déploiement terminé avec succès !"
