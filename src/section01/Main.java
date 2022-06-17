package section01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("first thread");
                System.out.println("current thread : " + Thread.currentThread().getName());
                System.out.println("setPriority : " + Thread.currentThread().getPriority());
                throw new RuntimeException("에러발생!!!");
            }
        });

        Thread thread2 = new Thread(()-> System.out.println("second Thread"));

        thread.setName("my thread 01");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName() + " got exception --> " + e.getMessage());
        });

        System.out.println("current thread before : " + Thread.currentThread().getName());
        thread.start();
        System.out.println("current thread after : " + Thread.currentThread().getName());
        Thread.sleep(10000);
//        thread2.start();
    }
}
