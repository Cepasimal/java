# CEPASIMAL

## PROJET - SPRINT 4
### SUJET
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### NOTIONS
+ Manipuler la notion d’héritage et de superclasse
+ Manipuler la notion de polymorphisme
+ Manipuler la notion d’implémentation d’interfaces

### DEROULÉ
Le Sprint 4 doit permettre de combattre des bots (pas très intelligents)

Les bots ont des niveaux de difficulté différents :
- EasyBot : cet ennemi ne fait absolument rien de son tour de jeu
- NormalBot : cet ennemi attaque à tous ses tours de jeu avec une attaque aléatoire
- HardBot : cet ennemi attaque lui aussi aléatoirement. S’il lui reste peu de vie (25% restant), il peut se soigner.

Le but est d’éviter au maximum la redondance de code entre les différentes entités du jeu, les bots et le joueur.

Il faut essayer de créer une architecture viable sur le long terme qui permette simplement de modifier, ajouter ou supprimer des fonctionnalités plus tard.

Par exemple, on doit pouvoir ajouter un bot GigaHardBot sans que cela ait un impact sur les autres classes du programme.

### CONTRAINTES

Les valeurs de vos variables ne sont pas importantes. Ce qui compte vraiment, c'est la solidité de votre code et de votre architecture.

Bon courage ! 🌟
