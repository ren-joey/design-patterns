package behaviors.implementations;

import behaviors.interfaces.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("behaviors.implementations.Quack");
    }
}
