
import java.util.ArrayList;
import java.util.List;

public class Character {

    private final String name;
    private final int maxHealth;
    private int currentHealth;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        Character.allCharacters.add(this);
    }

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\n"
                    + "Nobody's fighting right now !\n"
                    + "------------------------------------------\n";
        }

        String fmt = "------------------------------------------\nCharacters currently fighting :\n";

        for (Character ch : allCharacters) {
            fmt += String.format(" - %s\n", ch.toString());
        }

        return fmt + "------------------------------------------\n";
    }

    // Getters
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

    // Fight
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

    public static Character fight(Character c1, Character c2) {
        while (true) {
            c1.attack(c2);
            if (c2.currentHealth == 0) {
                return c1;
            }

            c2.attack(c1);
            if (c1.currentHealth == 0) {
                return c2;
            }

        }
    }
}
