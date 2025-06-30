package Com.Multithreding.Look;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);

        if(balance >= amount){
            System.out.println(Thread.currentThread().getName()+" Proceeding with withdrawal ");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            balance -=amount;

        }else {
            System.out.println(Thread.currentThread().getName()+ " insufficient balance");
        }
    }

}
