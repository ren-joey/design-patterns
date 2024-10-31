package topic1_strategy.behaviors.implementations;

import topic1_strategy.behaviors.interfaces.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
