package Com.Multithreding.Synchronized;

public class Counter {
    private int count = 0;

    //Race vs Synchronized


//    public void increment(){
//        synchronized (this) {
//            count++;
//        }
//    }


    //or

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
