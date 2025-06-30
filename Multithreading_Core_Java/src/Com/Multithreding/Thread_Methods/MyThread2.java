package Com.Multithreding.Thread_Methods;

public class MyThread2 extends Thread {

    public MyThread2(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+" is running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("t1");
        MyThread2 t2 = new MyThread2("t2");
        t1.start();
        t2.start();
    }
}
