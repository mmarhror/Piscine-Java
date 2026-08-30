
import java.util.ArrayList;
import java.util.List;

public abstract class Character {

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

    // Getters/Setters
    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int health) {
        currentHealth = health;
    }

    // Formatters
    @Override
    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s : KO", name);
        }
        return String.format("%s : %d/%d", name, currentHealth, maxHealth);
    }

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return """
                ------------------------------------------
                Nobody's fighting right now !
                ------------------------------------------
                """;
        }

        String fmt = """
        ------------------------------------------
        Characters currently fighting :
        """;

        for (Character ch : allCharacters) {
            fmt += String.format(" - %s\n", ch.toString());
        }

        return fmt + "------------------------------------------\n";
    }

    // Fight
    public abstract void takeDamage(int dmg);

    public abstract void attack(Character ch);

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
