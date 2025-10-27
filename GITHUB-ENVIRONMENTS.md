# Configuration des environnements GitHub

## 🔧 **Environnements à créer**

### **1. Environment: development**
- **Protection rules** : Aucune (déploiement automatique)
- **Secrets** : Tous les secrets disponibles
- **Usage** : Branche `develop`

### **2. Environment: production**
- **Protection rules** : 
  - ✅ Required reviewers (1 minimum)
  - ✅ Wait timer (5 minutes)
  - ✅ Restrict to branches: `main` only
- **Secrets** : Secrets de production uniquement
- **Usage** : Branche `main`

## 📋 **Secrets requis par environnement**

### **Development :**
```
SSH_PRIVATE_KEY
ANSIBLE_VAULT_PASSWORD
DOCKERHUB_USERNAME
DOCKERHUB_TOKEN
```

### **Production :**
```
SSH_PRIVATE_KEY_PROD
ANSIBLE_VAULT_PASSWORD_PROD
DOCKERHUB_USERNAME
DOCKERHUB_TOKEN
SONAR_TOKEN
```

## 🛡️ **Règles de protection recommandées**

### **Production :**
1. **Required reviewers** : Au moins 1 personne
2. **Wait timer** : 5 minutes minimum
3. **Branch protection** : Seulement `main`
4. **Deployment branches** : Seulement `main`

### **Development :**
1. **Required reviewers** : Aucun
2. **Wait timer** : Aucun
3. **Branch protection** : Aucune
4. **Deployment branches** : `develop` et `feature/*`

## 🔍 **Comment configurer les environnements**

1. Aller dans GitHub → Settings → Environments
2. Cliquer sur "New environment"
3. Nommer l'environnement (ex: "production")
4. Configurer les protection rules
5. Ajouter les secrets spécifiques à l'environnement
6. Sauvegarder la configuration
