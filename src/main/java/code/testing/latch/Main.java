package code.testing.latch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WaitForAllThreadsFinished.run();
        WaitForMainProcessFinished.run();
    }
}
