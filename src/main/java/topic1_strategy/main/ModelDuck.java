package topic1_strategy.main;

import topic1_strategy.behaviors.implementations.FlyNoWay;
import topic1_strategy.behaviors.implementations.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
