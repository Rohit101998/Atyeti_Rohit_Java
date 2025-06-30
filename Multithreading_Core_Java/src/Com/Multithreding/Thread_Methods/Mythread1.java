package Com.Multithreding.Thread_Methods;

public class Mythread1 extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Thread is running........");
        }catch (InterruptedException e){
            System.out.println("Thread interrupted: "+e);
        }
    }

    public static void main(String[] args) {
       Mythread1 t1 = new Mythread1();
       t1.start();
       t1.interrupt();
    }
}
