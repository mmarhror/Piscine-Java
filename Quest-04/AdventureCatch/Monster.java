
public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    // Formatting
    @Override
    public String toString() {
        int health = this.getCurrentHealth();
        String name = this.getName();

        String msg;

        if (health == 0) {
            msg = String.format("%s is a monster and is dead.", name);
        } else {
            msg = String.format("%s is a monster with %d HP.", name, health);
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

        int res = health - (int) Math.floor(dmg * 0.8);

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

        Weapon weapon = this.getWeapon();

        int dmg = weapon == null ? 7 : weapon.getDamage();
        ch.takeDamage(dmg);
    }

}
