package code.testing.stringformat;

public class Main {
    public static void main(String[] args) {
        String name = "John";
        int age = 25;
        String message = String.format("Hello, %s! You are %d years old.", name, age);
        System.out.println(message);
    }
}
