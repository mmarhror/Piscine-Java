
public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    // Formatting
    @Override
    public String toString() {
        int health = this.getCurrentHealth();
        String name = this.getName();

        if (health == 0) {
            return String.format("%s is a monster and is dead", name);
        }

        return String.format("%s is a monster with %d HP", name, health);
    }

    // Fight
    public void takeDamage(int dmg) {
        int health = this.getCurrentHealth();

        int res = health - (int) Math.floor(dmg * 0.8);

        if (res < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(res);
        }
    }

    public void attack(Character ch) {
        ch.takeDamage(7);
    }

}
