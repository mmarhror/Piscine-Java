
public class Sorcerer extends Character implements Healer {

    private int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public void heal(Character ch) {
        int res = ch.currentHealth + healCapacity;
        int max = ch.getMaxHealth();

        if (res > max) {
            ch.currentHealth = max;
        } else {
            ch.currentHealth = res;
        }

    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public String toString() {
        String name = this.getName();

        if (currentHealth == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", name, healCapacity);
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", name, this.currentHealth, healCapacity);
    }

}
