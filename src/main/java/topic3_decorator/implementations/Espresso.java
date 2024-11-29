package topic3_decorator.implementations;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return costCalculation(1.99);
    }
}
