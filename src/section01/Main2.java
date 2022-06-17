package section01;

public class Main2 {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            this.setName("My Thread Hi Hi Hi");
            System.out.println("Hello Thread From : " + this.getName());
        }
    }
}
