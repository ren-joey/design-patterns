package code.testing.basics;

import java.util.*;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> a = Arrays.asList("a", "b", "c");
        a.forEach(s -> {
            if (Objects.equals(s, "a")) {
                return;
            }
            System.out.println(s);
            return;
        });
    }
}
