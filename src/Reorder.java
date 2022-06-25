class Reorder {

    public static void main(String[] args) throws InterruptedException {
        SharedObject sharedObject = new SharedObject();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                sharedObject.addValue();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                sharedObject.getValue();
            }
        });
        thread1.start();
        thread2.start();
    }
}
class SharedObject{
    private int x;
    private int y;

    public void addValue(){
        x++;
        y++;
    }
    public void getValue(){
        if(x > y){
            throw new IllegalStateException("Illegal data access detected.. ");
        }
    }
}
