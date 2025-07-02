package Com.Multithreding.DeadLock;
class Pen{
    public synchronized void writeWithPenANDPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is using pen " + this + " and trying to execute paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using pen "+this);
    }
}
class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using paper "+ this + " and trying to execute pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using paper "+ this);
    }
}

class Task1 implements Runnable{

    private Pen pen;

    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenANDPaper(paper);//thread 1 locks pen and tries to lock paper
    }
}

class Task2 implements Runnable{

    private Pen pen;

    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.writeWithPaperAndPen(pen);//thread 1 locks pen and tries to lock paper
    }
}

public class DeadLockExample {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread t1=new Thread(new Task1(pen,paper),"Thread 1");
        Thread t2=new Thread(new Task2(pen,paper),"Thread 2");

        t1.start();
        t2.start();

    }
}
