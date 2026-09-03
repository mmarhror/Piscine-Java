
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

        if (this.getWeapon() != null) {
            return msg + String.format(" He has the weapon %s.", this.getWeapon().toString());
        }
        return msg;
    }

    // Fight
    @Override
    public void takeDamage(int dmg) throws DeadCharacterException {

        int health = this.getCurrentHealth();

        if (health == 0) {
            throw new DeadCharacterException(this);
        }

        int res = health - dmg;

        if (res < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(res);
        }
    }

    @Override
    public void attack(Character ch) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        if (ch.getCurrentHealth() == 0) {
            throw new DeadCharacterException(ch);
        }

        this.heal(this);

        Weapon weapon = this.getWeapon();
        int dmg = weapon == null ? 10 : weapon.getDamage();
        ch.takeDamage(dmg);
    }

    @Override
    public void heal(Character ch) throws DeadCharacterException {
        int health = ch.getCurrentHealth();

        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        if (health == 0) {
            throw new DeadCharacterException(ch);
        }

        int max = ch.getMaxHealth();

        int res = health + healCapacity;

        if (res > max) {
            ch.setCurrentHealth(max);
        } else {
            ch.setCurrentHealth(res);
        }

    }

}
