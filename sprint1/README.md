# Cepasimal - Java
## Projet - Sprint 1
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### Notions
+ Classes
+ Attributs
+ Constructeurs
+ Getters / Setters
+ Manipulation de types simples et complexes
+ Création de message avec toString()
+ Programme principal main() et sortie console avec System.out()

### Sujet
Le Sprint 1 doit permettre de poser les bases de l'affrontement. Un joueur doit pouvoir attaquer un autre joueur.

Les joueurs sont caractérisés par un **nom** ainsi que d'une statistique pour leur **nombre de points de vie**. Chaque joueur possède également une **attaque**.

Les attaques sont caractérisées par un **nom** et un **score de dégats**.

Le programme doit pouvoir simuler un tour d'un affrontement entre deux joueurs. Durant un tour, la console doit d'abord afficher les informations relatives **aux deux joueurs** grâce à un **toString()**. Les informations à afficher pour chaque joueur sont son nom, son nombre de points de vie et le nom de son attaque.

Dans la suite d'un tour, un des deux joueurs doit attaquer son adversaire avec son attaque. Cette action fait baisser le nombre de point de vie de l'adversaire en fonction du score de dégats de l'attaque.

La console doit afficher un message décrivant cette action.

A la fin du tour, la console doit afficher le nombre de points de vie restant à l'adversaire **après l'attaque**.

Le programme se termine à ce moment. Il n'y a **aucune** intervention humaine durant ce programme.

### Remarques
Il est possible d'arriver à ce résultat de différentes manières.
Il faut garder toutefois en tête que votre but est de trouver **la solution qui couvre le plus grand nombre de cas possibles** 👆

Par exemple on pourrait tout simplement afficher tout le contenu d'un tour via un unique System.out, sans aucune logique de programmation derrière, tel un "Hello World" boosté aux hormones 💀.
Cependant cette façon de faire ne couvre qu'un seul cas unique et ne nous intéresse pas ici.

Vous pouvez donner les valeurs que vous voulez pour le nom des joueurs et des attaques, ainsi que pour les points de vie des joueurs.

Bon courage ! 🌟
