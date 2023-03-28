package challenger;

public final class Attack {

    private final String name;
    private final int damage;

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() { return this.name; }

    public int getDamage() { return this.damage; }

    @Override
    public String toString() { return this.name; }
}
