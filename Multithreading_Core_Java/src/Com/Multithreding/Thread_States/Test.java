package Com.Multithreding.Thread_States;

public class Test extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING STATE");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Test t1 = new Test();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        //System.out.println(Thread.currentThread().getState());

        Thread.sleep(100);

        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}
