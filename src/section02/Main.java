package section02;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        System.out.println("isInterrupted : " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("isInterrupted : " + thread.isInterrupted());
    }
    private static class BlockingTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Exit --");
            }
        }
    }
}
