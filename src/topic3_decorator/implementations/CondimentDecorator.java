package topic3_decorator.implementations;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public double costCalculation(double cost) {
        if (getSize() == Size.TALL) {
            cost *= 1;
        } else if (getSize() == Size.GRANDE) {
            cost *= 1.5;
        } else if (getSize() == Size.VENTI) {
            cost *= 2;
        }
        return cost;
    }
}
