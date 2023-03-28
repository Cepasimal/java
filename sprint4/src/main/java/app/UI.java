package app;

import challenger.Attack;
import challenger.IChallenger;
import challenger.Player;

import java.util.Scanner;

public class UI {

    private final Scanner sc = new Scanner(System.in);

    // Un singleton permet d'avoir une seule instance du menu sans utiliser que des instances statiques
    //#region Singleton
    private static UI instance;

    private UI() {};

    public static UI getInstance() {
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }
    //#endregion

    /**
     * Permet à l'utilisateur de choisir un nom pour son joueur
     * @return le nom du joueur
     */
    public String getPlayerName() {
        String name = "";
        boolean isNameCorrect = false;

        while (!isNameCorrect) {
            System.out.println("\nEnter your name :");
            System.out.print("> ");

            name = this.sc.next();

            String yesOrNo = yesOrNoQuestion("\nIs the name \"" + name + "\" correct ? [Yes, No]");
            if (yesOrNo.equalsIgnoreCase("yes")) {
                isNameCorrect = true;
            }
        }
        return name;
    }

    /**
     * Permet à l'utilisateur de choisir son niveau de difficultés pour le jeu
     * @return le niveau de difficulté choisi
     */
    public String chooseDifficulties() {
        System.out.println("\nEnter the difficulties [Easy, Normal, Hard] :");
        System.out.print("> ");

        return this.sc.next();
    }

    /**
     * Demande à l'utilisateur s'il veut changer de difficulté
     * @return la réponse de l'utilisateur : oui ou non
     */
    public boolean wantToUpdateDifficulties(String currentDifficulty) {
        System.out.println("\nThe current difficulty is " + currentDifficulty + ".");
        return this.yesOrNoQuestion("Do you want to change it ? [No, Yes]").equalsIgnoreCase("yes");
    }

    /**
     * Demande au joueur s'il veut quitter le jeu
     * @return La réponse du joueur : oui ou non
     */
    public boolean wantToEndGame() {
        return yesOrNoQuestion("\nDo you want to stop playing [No, Yes] :").equalsIgnoreCase("yes");
    }

    /**
     * Procédure lorsqu'une question à comme réponse oui ou non
     * @param question : la question à poser à l'utilisateur
     * @return la réponse du joueur : oui ou non
     */
    private String yesOrNoQuestion(String question) {
        String yesOrNo = "";
        boolean correctInput = false;
        while (!correctInput) {
            System.out.println(question);
            System.out.print("> ");
            yesOrNo = this.sc.next();

            if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) {
                correctInput = true;
            }
            else {
                this.wrongInput();
            }
        }
        return yesOrNo;
    }

    /**
     * Affiche un message pour commencer le combat
     * @param challenger1 : challenger 1
     * @param challenger2 : challenger 2
     */
    public void beginFight(IChallenger challenger1, IChallenger challenger2) {
        System.out.println("\nThe fight between " + challenger1.getName() + " and " + challenger2.getName() + "!");
    }

    /**
     * Affiche un message pour commencer un tour
     * @param challenger1 : challenger 1
     * @param challenger2 : challenger 2
     */
    public void beginTurn(IChallenger challenger1, IChallenger challenger2) {
        System.out.println(challenger1.getName() + " have " + challenger1.getHealthPoints() + " HP");
        System.out.println(challenger2.getName() + " have " + challenger2.getHealthPoints() + " HP\n");

        System.out.println(challenger1.getName() + " it's your turn !");
    }

    /**
     * Affiche le challenger qui a gagné
     * @param winner : le gagnant
     */
    public void win(IChallenger winner) {
        System.out.println(winner.getName() + " win !");
    }

    /**
     * Permet au joueur de choisir une action
     * @return l'action choisie
     */
    public String chooseAction() {
        System.out.println("\nAnalyse, attack, heal or escape ?");
        System.out.print("> ");

        return this.sc.next();
    }

    /**
     * Affiche les informations de l'ennemi
     * @param enemy - ennemi
     */
    public void analyse(IChallenger enemy) {
        System.out.println("\n" + enemy);
    }

    /**
     * Affiche les informations de soin
     * @param challenger - le challenger soigné
     * @param healthRecover - les points de vie récupérés
     */
    public void heal(IChallenger challenger, int healthRecover) {
        System.out.println("\n" + challenger.getName() + " took a potion !" );
        System.out.println("He recover " + healthRecover + " HP !\n");
    }

    /**
     * Affiche que le soin a échoué
     * @param challenger - le challenger qui a voulu se soigner
     */
    public void failToHeal(IChallenger challenger) {
        System.out.println("\n" + challenger.getName() + " don't have potion !" );
    }

    /**
     * Affiche que le challenger n'a pas besoin de se soigner
     * @param challenger - le challenger qui a voulu se soigner
     */
    public void noNeedToHeal(IChallenger challenger) {
        System.out.println(challenger.getName() + " is already full life !" );
    }

    /**
     * Affiche un message sur la fuite du challenger
     * @param challenger - le challenger qui a fui
     */
    public void escape(IChallenger challenger) {
        System.out.println(challenger.getName() + " escaped...\n");
    }

    /**
     * Affiche un message d'erreur
     */
    public void wrongInput() {
        System.out.println("You didn't write correctly...");
    }

    /**
     * Permet à l'utilisateur de choisir une attaque pour son joueur
     * @param player - le joueur qui attaque
     * @return la saisie de l'utilisateur
     */
    public String chooseAttacks(Player player) {
        System.out.println("\n" + player.getAttacks());
        System.out.print("> ");

        return sc.next();
    }

    /**
     * Affiche les informations de l'attaque
     * @param challenger - le challenger qui attaque
     * @param enemy - l'ennemi qui s'est fait attaquer
     * @param chosenAttack - l'attaque choisie pour attaquer
     * @param damage - les dommages infligés à l'ennemi
     */
    public void attack(IChallenger challenger, IChallenger enemy, Attack chosenAttack, int damage) {
        System.out.println("\n" + challenger.getName() + " attacks " + enemy.getName() + " with " + chosenAttack.getName());
        System.out.println("It deals " + damage + " damage !\n");
    }

    /**
     * Affiche un coup critique
     */
    public void criticalHit() {
        System.out.println("\nCritical hit !!!");
    }

    /**
     * Affiche une attaque ratée
     */
    public void failHit() {
        System.out.println("\nYour attack failed...\n");
    }

    /**
     * Affiche que le challenger ne fait rien
     * @param challenger - le challenger
     */
    public void doNothing(IChallenger challenger) {
        System.out.println("\n" + challenger.getName() + " did nothing ¯\\_(ツ)_/¯\n");
    }

}
