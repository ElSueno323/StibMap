
package nvs.alg2ir.deadlock;

/**
 * Thread utilisant une methode d'une instance de MyObject
 */
public class MyThread extends Thread {

    private MyObj myObject;

    public MyThread(String name, MyObj myObject) {
        super(name);
        this.myObject = myObject;
    }

    public void run() {
        String nom = Thread.currentThread().getName();
        System.out.println("My thread: thread  " + nom + " in run");
        myObject.fct();
        System.out.println("My thread: thread " + nom + " out run");
    }
}