
public interface Healer {

    void heal(Character ch) throws DeadCharacterException;

    int getHealCapacity();
}
