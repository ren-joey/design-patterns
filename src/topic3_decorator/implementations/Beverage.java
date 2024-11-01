package topic3_decorator.implementations;

import topic3_decorator.interfaces.Product;


public abstract class Beverage implements Product {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
