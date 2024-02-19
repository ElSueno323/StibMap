/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvs.alg2ir.test;

public class Demo implements Runnable {

    private int balance;

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            increment();
            System.out.println("Balance is " + balance);
        }
    }

    private void increment() {
        int i = balance;
        balance = i + 1;
    }

    public static void main(String[] args) {
        Demo job = new Demo();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}