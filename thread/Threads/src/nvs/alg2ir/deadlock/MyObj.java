/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvs.alg2ir.deadlock;

/**
 *
 * @author g54720
 */
public class MyObj {

    private String my;
    private String other;
    public MyObj(String a,String b) {
        my=a;
        other=b;
    }

    public void fct() {
        String nom = Thread.currentThread().getName();
        System.out.println("MyObject: " + nom + " in fct");

        synchronized (my) {
            System.out.println("MyObject: " + nom + " in bloc 1 locked "+my);            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            synchronized(other){
                System.out.println("MyObject: " + nom + " out bloc 1");
            }            
        }
        System.out.println("MyObject: " + nom + " between bloc 1 and bloc 2");
        synchronized (other) {
            System.out.println("MyObject: " + nom + " in bloc 2 locked "+other);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("MyObject: " + nom + " out bloc 2");
        }
        System.out.println("MyObject: " + nom + " out fct");

    }
}
