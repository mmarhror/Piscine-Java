
public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);

        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    // Getters/Setters
    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

    // Formatting
    @Override
    public String toString() {
        String name = this.getName();
        int health = this.getCurrentHealth();

        String msg;
        if (health == 0) {
            msg = String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", name, shield, healCapacity);
        } else {
            msg = String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", name, health, healCapacity, shield);
        }

        return msg + String.format(" He has the weapon %s.", this.getWeapon().toString());
    }

    // Fight
    @Override
    public void takeDamage(int dmg) {
        int health = this.getCurrentHealth();

        int res = (health + shield) - dmg;

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
        int dmg = weapon == null ? 6 : weapon.getDamage();
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
