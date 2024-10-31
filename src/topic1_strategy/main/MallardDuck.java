package topic1_strategy.main;

import topic1_strategy.behaviors.implementations.FlyWithWings;
import topic1_strategy.behaviors.implementations.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
