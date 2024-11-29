package code.testing.set;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        Set<String> set2 = new HashSet<>();
        set2.add("B");
        set2.add("C");
        set.removeAll(set2);
        System.out.println(set);
    }
}