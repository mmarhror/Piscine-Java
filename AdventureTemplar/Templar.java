
public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);

        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public void heal(Character ch) {
        int health = ch.getCurrentHealth();
        int max = ch.getMaxHealth();
        int res = health + healCapacity;
        if (res > max) {
            ch.setCurrentHealth(max);
        } else {
            ch.setCurrentHealth(res);
        }
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        String name = this.getName();
        int currentHealth = this.getCurrentHealth();

        if (currentHealth == 0) {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", name, shield, healCapacity);
        }
        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", name, currentHealth, healCapacity, shield);
    }

}
