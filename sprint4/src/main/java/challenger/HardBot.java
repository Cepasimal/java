package challenger;

import app.UI;

public class HardBot extends Challenger {

    public HardBot() {
        super("Hard bot", 1.8, 0.8, 2);
    }

    @Override
    public void doAction(IChallenger enemy) {
        if (this.getHealthPoints() < 25 && this.getPotions().size() > 0) {
            int currentHeal = this.heal();
            UI.getInstance().heal(this, currentHeal);
        }
        else {
            Attack attack = getMaxDamageAttack();
            this.attacks(enemy, attack);
        }
    }

    private Attack getMaxDamageAttack() {
        Attack maxDamageAttack = getAttacks().get(0);
        for (Attack attack : this.getAttacks()) {
            if (attack.getDamage() > maxDamageAttack.getDamage()) {
                maxDamageAttack = attack;
            }
        }
        return maxDamageAttack;
    }

}
