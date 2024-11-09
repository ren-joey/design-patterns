package topic3_decorator.implementations;

import topic3_decorator.interfaces.Product;


public abstract class Beverage implements Product {
    public enum Size {
        TALL, GRANDE, VENTI
    };
    Size size = Size.TALL;
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    };

    public void setSize(Size size) {
        this.size = size;
    };

    public abstract double cost();

    public double costCalculation(double cost) {
        if (size == Size.TALL) {
            cost *= 1;
        } else if (size == Size.GRANDE) {
            cost *= 1.05;
        } else if (size == Size.VENTI) {
            cost *= 1.1;
        }
        return cost;
    }
}
