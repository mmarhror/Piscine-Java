
public class Character {

    private final String name;
    private final int maxHealth;
    private int currentHealth;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s : KO", name);
        }
        return String.format("%s : %s/%s", name, currentHealth, maxHealth);
    }

    public void takeDamage(int dmg) {
        int res = currentHealth - dmg;

        if (res < 0) {
            currentHealth = 0;
        } else {
            currentHealth = res;
        }
    }

    public void attack(Character ch) {
        ch.takeDamage(9);
    }
}
