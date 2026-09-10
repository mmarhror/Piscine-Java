
public abstract class RacletteDecorator implements Raclette {

    private Raclette raclette;

    public RacletteDecorator(Raclette raclette) {
        this.raclette = raclette;
    }

    public int getCalories() {
        return raclette.getCalories();
    }

    public String getIngredients() {
        return raclette.getIngredients();
    }

    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }

}
