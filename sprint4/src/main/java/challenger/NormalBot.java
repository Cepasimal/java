package challenger;

import app.UI;

public class NormalBot extends Challenger {

    public NormalBot() {
        super("Normal bot", 1.5, 0.5, 1);
    }

    @Override
    public void doAction(IChallenger enemy) {
        int randomIndex = (int) (Math.random() * this.getAttacks().size());
        Attack randomAttack = this.getAttacks().get(randomIndex);
        this.attacks(enemy, randomAttack);
    }

}
