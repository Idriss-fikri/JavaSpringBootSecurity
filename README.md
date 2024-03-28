# Application of user who can review - Back

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants :

1. **Docker Desktop** : Vous devez avoir Docker installé sur votre poste. Si ce n'est pas déjà le cas, vous pouvez suivre les instructions d'installation disponibles sur le site officiel de Docker.
Site disponible ici : https://www.docker.com/products/docker-desktop/

## Installation de la base de données en local

Pour installer la base de données  localement, suivez ces étapes :

1. Assurez-vous que Docker est installé sur votre système.

2. Utilisez la commande suivante dans le répertoire *reviews-docker/* : pour démarrer la base de données en utilisant docker-compose :
   
   ```bash
   docker compose up -d
   ```

Cette commande va télécharger les images Docker nécessaires et démarrer les conteneurs associés à la base de données. Le conteneur contiendra une instance de la base de données PostgreSQL prête à être utilisée.

1. Après avoir exécuté la commande, vous pouvez vérifier que les conteneurs sont en cours d'exécution en utilisant la commande ```docker ps```. 
2. Pour vous connecter à la base de données, vous pouvez utiliser un outil tel que pgAdmin ou DBeaver. Utilisez les informations suivantes pour configurer la connexion :
    - Host: localhost
    - Port: 5433
    - Database: louetavoiture
    - Username: postgres
    - Password: postgres

Assurez-vous d'utiliser les identifiants de connexion appropriés pour accéder à la base de données. Une fois connecté, vous pourrez gérer la base de données et effectuer les opérations nécessaires pour le bon fonctionnement de l'application LoueTaVoiture.




## Modification du script SQL de la base de données

Si vous avez besoin de modifier le script SQL *init-db.sql*  suivez ces étapes :

1. Modifiez le script SQL selon vos besoins. Assurez-vous de sauvegarder les modifications.

2. Après avoir modifié le script, vous devez redémarrer le conteneur Docker pour que les modifications prennent effet. Utilisez la commande suivante pour arrêter et supprimer les conteneurs ainsi que les volumes associés :
   
   ```bash
   docker compose down -v
   ````
    Cette commande arrêtera les conteneurs et supprimera les volumes Docker, ce qui permettra de réinitialiser la base de données à son état initial.

3. Ensuite, utilisez à nouveau la commande pour démarrer la base de données en utilisant docker-compose :

    ```bash
    docker compose up -d
    ```
    Assurez-vous que le conteneur se lance correctement en utilisant la commande ```docker ps```. Vous devriez voir le conteneur "louetavoiture-docker-postgres" dans la liste des conteneurs actifs.




