### Documentation Utilisateur du Projet

#### Introduction

Ce projet est une application Android permettant aux utilisateurs de rechercher et afficher des informations sur différents pays. Les utilisateurs peuvent consulter les détails des pays et utiliser une fonction de recherche pour trouver des pays spécifiques.

#### Fonctionnalités Principales

Affichage de la Liste des Pays: La page d'accueil affiche une liste de pays récupérés depuis une API. Chaque élément de la liste montre le nom du pays et son drapeau.

Recherche de Pays: Les utilisateurs peuvent rechercher des pays en entrant le nom du pays ou de sa capitale dans la barre de recherche.

Affichage des Détails du Pays: En cliquant sur un pays dans la liste, l'utilisateur est redirigé vers une page de détails montrant des informations supplémentaires sur le pays, comme la capitale, la population, la superficie, et les langues parlées.


#### Utilisation

1. Page d'Accueil:
    - Lorsque vous ouvrez l'application, la page d'accueil affiche une liste de pays.
    - Chaque pays est représenté par son nom et son drapeau.

2. Recherche de Pays:
    - Utilisez la barre de recherche en haut de la page d'accueil pour trouver un pays spécifique.
    - Entrez le nom du pays ou de sa capitale dans le champ de recherche.
    - Cliquez sur l'icône de recherche pour afficher les résultats.

3. Affichage des Détails du Pays:
    - Cliquez sur un pays dans la liste pour voir ses détails.
    - La page des détails du pays affiche les informations suivantes :
        - Nom
        - Drapeau
        - Capitale
        - Population
        - Superficie
        - Langues Parlées

#### Navigation

- Retour à la Page d'Accueil : Depuis la page de détails d'un pays, utilisez le bouton de retour pour revenir à la liste des pays.
- Recherche de Nouveaux Pays : À tout moment, utilisez la barre de recherche sur la page d'accueil pour effectuer une nouvelle recherche.

#### Notes et Remarques

- Il est nécéssaire d'avoir une connexion Internet active pour charger les données des pays depuis l'API.
- L'API en fonctionne pas tout le temps, et fail souvent.
- Les fonctionnalités de favoris et de gestion de base de données locale ne sont pas implémentées dans cette version de l'application, dû au manque de connaissances, mais aussi au fait que l'API prennait longtemps avant de fonctionner.
- Nous avons essayé d'implémenter une base de donnée via Room, avec les Dao etc, mais elle n'est pas disponible sur ce rendu, qui lui est fonctionnel.
