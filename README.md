# gestion-absences

Application de gestion des absences des apprenants

## Description

Ce projet est un exercice de réalisation d'un CRUD en Java pour l'évaluation individuelle du bloc 4 de la formation Développeur informatique du CESI Bordeaux.

## Etapes de réalisation
 
1. Création du projet Git et du dépot distant sur Github
2. Création du projet dans Eclipse et intégration des fichiers dans le dépot
3. Début de rédaction du fichier README.md pour documenter le projet
4. Création d'une branche hello-world pour tester le projet
5. Test basique (Hello, world!) du fonctionnement du projet
6. Merge de la branche hello-world sur la branche main
7. Création d'une branche dev et suppression des fichiers relatifs à hello world
8. Création d'une branche learner-class
9. Création d'un package di21.bloc4.dao
10. Création de la classe Learner
11. Création de ses attributs
12. Création des getters/setters
13. Création du constructeur
14. Création d'une méthode toString pour afficher les informations d'une instance
15. Création d'un package di21.bloc4.app
16. Création d'une classe Main avec le point d'entrée du programme
17. Création d'un objet Learner et affichage de ses informations pour test
18. Merge de la branche learner-class sur la branche dev
19. Découverte d'un bug qui affiche l'attribut isDelegate sous forme de booléen anglais
20. Création d'une branche fix-learner-tostring-method-delegateattribute pour corriger le bug
21. Correction du bug
22. Merge de la branche sur dev
23. Création de la table learner dans postgresql

```
CREATE TABLE learner(
    id SERIAL PRIMARY KEY,
    group_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email_address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    absence_quantity INTEGER,
    is_delegate BOOLEAN
)
```

24. Configuration du projet pour utiliser le JDBC connector de Postgresql

- Faire un clic droit sur le projet dans Eclise
- Sélectionner la section JavaBuild Path
- Cliquer sur la zone Classpath
- Cliquer sur le bouton Add External JARS...
- Sélectionner le JDBC connector postgresql
- Cliquer sur le bouton Apply and Close
- Le projet doit désormais contenir une entrée Referenced Libraries avec le JDBC connector postgresql
