package Com.Multithreding.Thread_Methods;

public class MyThread extends Thread{

    //How to change a name of Thread
    public MyThread(String name){
        super(name);
    }


    @Override
    public void run() {
        //System.out.println("Thread is running............");
//        for (int i=1;i <= 5;i++){
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);


        // set Priority

        for(int i=0;i<5;i++){
            String a = "";
            for (int j = 0;j < 10000; j++){
                a += "a";
            }
            System.out.println(Thread.currentThread().getName()+" - Priority: "+Thread.currentThread().getPriority()+"- count: "+i);

            try{
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       // MyThread t1 =new MyThread("Rohit");
        MyThread l = new MyThread("Low Priority Thread");
        MyThread m = new MyThread("Medium Priority Thread");
        MyThread h = new MyThread("High Priority Thread");

        l.start();
        m.start();
        h.start();

       // t1.start();

        //t1.join();
       // System.out.println("Hello");
    }
}
