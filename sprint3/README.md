# Cepasimal - Java
## Projet - Sprint 3
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### Notions
+ Manipulation de liste avancée
+ Manipulation de valeurs randomisées (Random ou Math.rand)
+ Manipulation d’algorithmie plus complexe

### Sujet
Le Sprint 3 doit permettre d'étoffer les options de combats.

Les joueurs possèdent maintenant des statistiques :
  - Une statistique d'offense comprise entre 1 et 2 (décimale) : Elle permet de faire plus de dégâts
  - Une statistique de défense comprise entre 0 et 1 (décimale) : Elle permet de prendre moins de dégâts
  - Une statistique de vitesse (entière) : Elle permet de définir qui agit **en premier** lors d'un tour

L'offense et la défense influent sur le calcul des dégâts d’une attaque. Dorénavant les dégâts sont calculés de cette façon :

(**Dégâts de base de l’attaque** multiplié par **offense de l’attaquant**) multiplié par **défense de la cible**

Chaque attaque possède dorénavant une **probabilité d'échouer** lorsqu'un joueur l'utilise. 

Les joueurs ont également 5% de chance d'effectuer un coup critique ce qui multipliera par *2* **les dégâts finaux infligés par leur attaque**.

Une attaque qui échoue ou qui provoque un coup critique provoque un message particulier dans la console.

Enfin, le joueur possède désormais **une potion** et il peut la consommer lors de son tour.
Une potion soigne un nombre de points de vie du joueur.

Une potion peut être consommée en choisissant la nouvelle option **"Soin"** via l'interface de jeu.
Tout comme l'action **"Analyse"**, cette action **ne mets pas fin au tour du joueur**.

L'action "Soin" n'est pas possible si le joueur ne possède plus de potion.

### Contraintes
Les valeurs de vos variables ne sont pas importantes. Ce qui compte vraiment, c'est la solidité de votre code et de votre architecture.

Bon courage ! 🌟
