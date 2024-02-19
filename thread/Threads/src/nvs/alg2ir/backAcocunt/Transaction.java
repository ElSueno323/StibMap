
package nvs.alg2ir.backAcocunt;

/**
 *
 * @author g54720
 */
public class Transaction extends Thread{
    private BankAccount bk;
    
    public Transaction(String name,BankAccount k){
        super(name);
        bk=k;       
    }
    
    public void run(){
        System.out.println("solde ="+bk.getBalance());
        while(true){
            int tmp=5;//(int)(Math.random()*10);
            bk.deposit(tmp);
            //System.out.println("solde ="+bk.getBalance()+"+++add  "+tmp+"+++");
            bk.withdraw(tmp);
            System.out.println("solde="+bk.getBalance());
            //System.out.println("solde ="+bk.getBalance()+"---withdraw "+tmp+"---");
        }
    }
}
