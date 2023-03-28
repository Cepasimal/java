package challenger;

import app.UI;
import equipment.Potion;

import java.util.ArrayList;
import java.util.List;

abstract public class Challenger implements IChallenger {

    private final static int MAX_HEALTH_POINTS = 100;
    private final String name;
    private int healthPoints;
    private final double powerPoints;
    private final double defensePoints;
    private final int speedPoints;
    private boolean isEscaping;
    private final List<Potion> potion;
    private final List<Attack> attacks;

    public Challenger(String name, double powerPoints, double defensePoints, int speedPoints) {
        Attack attack1 = new Attack("Punch", 10);
        Attack attack2 = new Attack("Fireball", 20);
        Attack attack3 = new Attack("Flash", 60);

        this.name = name;
        this.healthPoints = MAX_HEALTH_POINTS;
        this.powerPoints = powerPoints;
        this.defensePoints = defensePoints;
        this.speedPoints = speedPoints;
        this.attacks = List.of(attack1, attack2, attack3);
        this.isEscaping = false;
        this.potion = new ArrayList<>();
        this.potion.add(new Potion(25));
    }

    /**
     * Fait une copie du challenger en paramètre
     * @param challenger - le challenger à copier
     */
    public Challenger(Challenger challenger) {
        Attack attack1 = new Attack("Punch", 10);
        Attack attack2 = new Attack("Fireball", 20);
        Attack attack3 = new Attack("Flash", 60);

        this.name = challenger.getName();
        this.healthPoints = MAX_HEALTH_POINTS;
        this.powerPoints = challenger.getPowerPoints();
        this.defensePoints = challenger.defensePoints;
        this.speedPoints = challenger.speedPoints;
        this.attacks = List.of(attack1, attack2, attack3);
        this.isEscaping = false;
        this.potion = new ArrayList<>();
        this.potion.add(new Potion(25));
    }

    /**
     * Calcul les dommages
     * @param attack - attaque choisie
     * @return les dommages infligés
     */
    public int getDamage(IChallenger enemy, Attack attack) {
        double defense = attack.getDamage() * enemy.getDefensePoints();
        return (int) Math.round(attack.getDamage() * this.getPowerPoints() - defense);
    }

    /**
     * Utilise l'attaque contre l'ennemi
     * @param enemy - Joueur ennemi
     * @param attack - Attaque utilisée
     */
    public void attacks(IChallenger enemy, Attack attack) {
        int damage = this.getDamage(enemy, attack);
        if (this.isFailHit()) {
            UI.getInstance().failHit();
        }
        else if (this.isCriticalHit()) {
            damage *= 2;
            UI.getInstance().criticalHit();
        }
        this.inflictDamage(enemy, damage);
        UI.getInstance().attack(this, enemy, attack, damage);
    }

    /**
     * Baisse la vie de l'ennemi en fonction des dégâts de l'attaque du joueur
     * @param enemy - Joueur ennemi
     * @param damage - Dégâts subits
     */
    public void inflictDamage(IChallenger enemy, int damage) {
        if (enemy.getHealthPoints() - damage < 0) {
            damage = enemy.getHealthPoints();
            enemy.setHealthPoints(0);
        }

        enemy.setHealthPoints(enemy.getHealthPoints() - damage);
    }

    /**
     * Augmente la vie du joueur en fonction des points de vie donnés par sa première potion
     * @return le nombre de points de vie récupérer
     */
    public int heal() {
        int healthRecover = 0;
        if (this.getPotions().size() == 0 || this.getHealthPoints() == Challenger.getMaxHealthPoints()) return healthRecover;

        Potion currentPotion = this.getPotions().get(0);
        if (this.getHealthPoints() + currentPotion.getHealPoint() > Challenger.getMaxHealthPoints()) {
            healthRecover = Challenger.getMaxHealthPoints() - currentPotion.getHealPoint();
            this.setHealthPoints(Challenger.getMaxHealthPoints());
        } else {
            healthRecover = currentPotion.getHealPoint();
            this.setHealthPoints(this.getHealthPoints() + healthRecover);
        }

        this.getPotions().remove(currentPotion);
        return healthRecover;
    }

    /**
     * Calcul la probabilté de rater un attaque
     * @return est-ce que l'attaque a raté
     */
    public boolean isFailHit() { return Math.round(Math.random() * 100) < 10; }

    /**
     * Calcul la probabilté de faire un coup critique
     * @return est-ce que l'attaque est un coup de critique
     */
    public boolean isCriticalHit() { return Math.round(Math.random() * 100) < 20; }

    @Override
    public String getName() {
        return this.name;
    }

    public double getPowerPoints() { return this.powerPoints; }

    public int getSpeedPoints() { return this.speedPoints; }

    public double getDefensePoints() { return this.defensePoints; }

    public int getHealthPoints() { return this.healthPoints; }

    public void setHealthPoints(int healthPoints) { this.healthPoints = healthPoints; }

    public List<Attack> getAttacks() { return this.attacks; }

    public List<Potion> getPotions() { return this.potion; }

    public static int getMaxHealthPoints() {
        return MAX_HEALTH_POINTS;
    }

    public boolean isEscaping() {
        return isEscaping;
    }

    public void setEscaping(boolean escaping) {
        isEscaping = escaping;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + "\n" +
                "HP : " + this.healthPoints + "\n" +
                "Attacks : " + this.attacks;
    }

}
