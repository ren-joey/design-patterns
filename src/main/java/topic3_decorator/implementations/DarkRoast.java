package topic3_decorator.implementations;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return costCalculation(.99);
    }
}
