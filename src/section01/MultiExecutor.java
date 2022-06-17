package section01;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    private final List<Runnable> tasks = new ArrayList<>();
    public MultiExecutor(List<Runnable> tasks){
        this.tasks.addAll(tasks);
    }
    public void executeAll(){
        for(Runnable task : tasks){
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
class Demo{
    public static void main(String[] args) {
        Runnable r1 = ()-> System.out.println("Thread start : " + Thread.currentThread().getName());
        Runnable r2 = ()-> System.out.println("Thread start : " + Thread.currentThread().getName());
        Runnable r3 = ()-> System.out.println("Thread start : " + Thread.currentThread().getName());
        MultiExecutor multiExecutor = new MultiExecutor(List.of(r1,r2,r3));
        multiExecutor.executeAll();
    }
}
