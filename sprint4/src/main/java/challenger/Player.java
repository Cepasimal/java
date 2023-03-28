package challenger;

import app.UI;

import java.util.List;

public class Player extends Challenger {

    public Player(String name, double powerPoints, double defensePoints, int speedPoints) {
        super(name, powerPoints, defensePoints, speedPoints);
    }

    public Player(Player player) {
        super(player);
    }

    /**
     * Processus d'un joueur pour battre son ennemi
     * @param enemy - ennemi du joueur
     */
    @Override
    public void doAction(IChallenger enemy) {
        boolean finishAction = false;

        while (!finishAction) {
            String response = UI.getInstance().chooseAction();

            if (!List.of("analyse", "attack", "heal", "escape").contains(response.toLowerCase())) {
                UI.getInstance().wrongInput();
            }
            else if (response.equalsIgnoreCase("analyse")) {
                UI.getInstance().analyse(enemy);
            }
            else if (response.equalsIgnoreCase("heal")) {
                int currentHeal = this.heal();
                if (currentHeal > 0) {
                    finishAction = true;
                }
            }
            if (response.equalsIgnoreCase("attack")) {
                this.chooseAttack(enemy);
                finishAction = true;
            }
            if (response.equalsIgnoreCase("escape")) {
                UI.getInstance().escape(this);
                this.setEscaping(true);
                finishAction = true;
            }
        }
    }


    /**
     * Permet au joueur de choisir une attaque
     * @param enemy - ennemi qui va se faire attaquer
     */
    private void chooseAttack(IChallenger enemy) {
        boolean goodInput = false;

        while (!goodInput) {
            String response = UI.getInstance().chooseAttacks(this);
            Attack attack = this.findAttack(response);

            if (attack != null) {
                this.attacks(enemy, attack);
                goodInput = true;
            }
            else {
                UI.getInstance().wrongInput();
            }
        }
    }

    /**
     * Récupère l'attaque saisie par l'utilisateur parmi la liste d'attaque
     * @param attackName - Nom de l'attaque saisie par le joueur
     */
    public Attack findAttack(String attackName) {
        for (Attack a : this.getAttacks()) {
            if (a.getName().trim().toLowerCase().equals(attackName.toLowerCase().trim())) {
                return a;
            }
        }
        return null;
    }

    /**
     * Augmente la vie du joueur en fonction des points de vie donnés par la potion
     * @return la santé récupérée
     */
    @Override
    public int heal() {
        int currentHeal = super.heal();
        if (this.getPotions().size() == 0) {
            UI.getInstance().failToHeal(this);
        }
        else if (this.getHealthPoints() == Challenger.getMaxHealthPoints()) {
            UI.getInstance().noNeedToHeal(this);
        }
        else {
            UI.getInstance().heal(this, currentHeal);
        }
        return currentHeal;
    }

}
