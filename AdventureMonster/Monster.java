
public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        int health = this.getCurrentHealth();
        String name = this.getName();

        if (health == 0) {
            return String.format("%s is a monster and is dead", name);
        }

        return String.format("%s is a monster with %d HP", name, health);
    }

}
