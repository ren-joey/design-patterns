package behaviors.implementations;

import behaviors.interfaces.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("behaviors.implementations.Squeak");
    }
}
