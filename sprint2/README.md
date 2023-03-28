# Cepasimal - Java
## Projet - Sprint 2
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### Notions
+ Boucles de contrôles
+ Manipulations de listes avec ArrayList
+ Entrée console avec Scanner
+ Manipulation de message avec StringBuilder

### Sujet
Le Sprint 2 doit permettre à l'utilisateur **d'intéragir** avec le programme de jeu via une **interface de commandes**.

Le programme de jeu doit permettre de jouer **plusieurs tours** jusqu'à la fin de la partie.
**La partie se termine soit si l'un des deux joueurs fuit ou bien si les points de vie d'un des deux joueurs tombent à 0**.

Les actions des joueurs à chaque tour sont désormais déterminées par un choix de l'utilisateur via la console.
La méthode utilisée pour choisir est libre mais nous vous recommandons de demander que l'utilisateur écrive **le nom de l'action** dans la console.

Les joueurs possèdent maintenant une liste d'attaques, la seule contrainte étant que la liste **ne peut pas être vide**. Les caractéristiques d'une attaque restent les mêmes.

Un tour de jeu commence toujours par le rappel de la valeur des points de vie actuelle de chacun des joueurs, comme dans le Sprint 1. 
Les joueurs agissent ensuite l'un après l'autre. Les joueurs agissent toujours dans le même ordre à chaque tour. 
Une fois que les deux joueurs ont agit, le tour suivant commence, et ce, jusqu'à la fin de la partie. 

Les actions possibles des joueurs durant un tour sont les suivantes :
+ **Analyser** : la console affiche les informations relatives à l'adversaire du joueur. Cette action **ne mets pas fin au tour du joueur**.
+ **Attaquer** : L'utilisateur doit choisir une attaque à effectuer sur l'adversaire via la console **parmis la liste d'attaque du joueur**. La console doit afficher les informations relatives à l'attaque choisie. Cette action **mets fin au tour du joueur**.
+ **Fuir** : Le joueur abandonne le combat. Cette action **mets fin au tour du joueur ainsi qu'à la partie**.

### Contraintes
Les valeurs de vos variables ne sont pas importantes. Ce qui compte vraiment, c'est la solidité de votre code et de votre architecture.

Bon courage ! 🌟
