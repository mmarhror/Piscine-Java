
public class Sorcerer extends Character implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    // Getters/Setters
    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    // Formatting
    @Override
    public String toString() {
        String name = this.getName();
        int currentHealth = this.getCurrentHealth();

        if (currentHealth == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", name, healCapacity);
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", name, currentHealth, healCapacity);
    }

    // Fight
    public void takeDamage(int dmg) {
        int health = this.getCurrentHealth();

        int res = health - dmg;

        if (res < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(res);
        }
    }

    public void attack(Character ch) {
        this.heal(this);
        ch.takeDamage(10);
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

}
