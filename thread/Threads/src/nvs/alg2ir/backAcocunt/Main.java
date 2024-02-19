
package nvs.alg2ir.backAcocunt;

/**
 *
 * @author g54720
 */
public class Main {
    public static void main(String[] args) {
        BankAccount bk=new BankAccount(10);
        for(int i=0;i<20;i++){
            Transaction tr=new Transaction("i", bk);
            tr.start();
        }
    }
}
