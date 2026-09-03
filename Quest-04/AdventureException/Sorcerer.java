
public class Sorcerer extends Character implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
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
        int health = this.getCurrentHealth();

        String msg;

        if (health == 0) {
            msg = String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", name, healCapacity);
        } else {
            msg = String.format("%s is a sorcerer with %d HP. It can heal %d HP.", name, health, healCapacity);
        }

        return msg + String.format(" He has the weapon %s.", this.getWeapon().toString());
    }

    // Fight
    @Override
    public void takeDamage(int dmg) {
        int health = this.getCurrentHealth();

        int res = health - dmg;

        if (res < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(res);
        }
    }

    @Override
    public void attack(Character ch) {
        this.heal(this);

        Weapon weapon = this.getWeapon();
        int dmg = weapon == null ? 10 : weapon.getDamage();
        ch.takeDamage(dmg);
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
