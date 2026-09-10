
public class WithPickles extends RacletteDecorator {

    public WithPickles(Raclette raclette) {
        super(raclette);
    }

    public int getCalories() {
        return 50 + super.getCalories();
    }

    public String getIngredients() {
        return super.getIngredients() + ", cornichons";
    }

    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }
}
