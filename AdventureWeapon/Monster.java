
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

        return msg + String.format(" He has the weapon %s.", this.getWeapon().toString());
    }

    // Fight
    @Override
    public void takeDamage(int dmg) {
        int health = this.getCurrentHealth();

        int res = health - (int) Math.floor(dmg * 0.8);

        if (res < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(res);
        }
    }

    @Override
    public void attack(Character ch) {
        Weapon weapon = this.getWeapon();

        int dmg = weapon == null ? 7 : weapon.getDamage();
        ch.takeDamage(dmg);
    }

}
