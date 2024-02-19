
package nvs.alg2ir.backAcocunt;

/**
 *
 * @author g54720
 */
public class BankAccount {
    private int solde;
    
    public BankAccount(int x){
        solde=x;
    }
    synchronized public void deposit(int amount){
        solde=solde+amount;
    }
    synchronized public void withdraw(int amount){
        if(solde>=amount){
            solde=(solde-amount);
        }
    }
    synchronized public int getBalance(){
            return solde;
    }
}
