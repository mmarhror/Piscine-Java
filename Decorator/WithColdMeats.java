
public class WithColdMeats extends RacletteDecorator{


    public WithColdMeats(Raclette raclette) {
        super(raclette);
    }

    public int getCalories() {
        return 350 + super.getCalories();
    }

    public String getIngredients() {
        return super.getIngredients() + ", charcuterie";
    }

    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }
}
