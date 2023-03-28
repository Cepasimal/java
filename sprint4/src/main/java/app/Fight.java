package app;

import challenger.IChallenger;

public class Fight {

    private IChallenger challenger1;
    private IChallenger challenger2;

    public Fight(IChallenger challenger1, IChallenger challenger2) {
        this.challenger1 = challenger1;
        this.challenger2 = challenger2;
    }

    /**
     * Commence un combat entre 2 joueurs jusqu'à ce que l'un perde.
     * Montre le gagnant à la fin du combat
     */
    public void play() {
        UI.getInstance().beginFight(this.challenger1, this.challenger2);
        this.updateChallengerOrder();

        while (this.canContinue()) {
            UI.getInstance().beginTurn(this.challenger1, this.challenger2);
            challenger1.doAction(challenger2);

            if (this.canContinue()) {
                UI.getInstance().beginTurn(this.challenger2, this.challenger1);
                challenger2.doAction(challenger1);
            }

        }
        UI.getInstance().win(this.getWinner());
    }

    /**
     * Mets à jour l'ordre des joueurs dans le combat
     */
    public void updateChallengerOrder() {
        if (this.challenger2.getSpeedPoints() > this.challenger1.getSpeedPoints()) {
            IChallenger temp = this.challenger1;
            this.challenger1 = this.challenger2;
            this.challenger2 = temp;
        }
    }

    /**
     * Récupère le gagnant du jeu
     * @return le gagnant
     */
    private IChallenger getWinner() {
        if (this.challenger1.getHealthPoints() == 0 || this.challenger1.isEscaping()) {
            return this.challenger2;
        }
        return this.challenger1;
    }

    /**
     * Retourne vrai si le combat peut continuer donc si personne ne s'est enfui et
     * qu'aucun des joueurs n'est KO
     * @return si le combat peut continuer
     */
    private boolean canContinue() {
        return !this.challenger1.isEscaping() && !this.challenger2.isEscaping() && this.challenger1.getHealthPoints() > 0 && this.challenger2.getHealthPoints() > 0;
    }

}
