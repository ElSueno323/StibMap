
package nvs.alg2ir.deadlock;

/**
 *
 * @author g54720
 */
public class Test {
    public static void main(String[] args) {
        String a="a";
        String b="b";
        MyObj objA=new MyObj(a,b);
        MyObj objB=new MyObj(b,a);
        MyThread t1=new MyThread("t1", objA);
        MyThread t2=new MyThread("t2", objB);
        t1.start();
        t2.start();
    }
    //deadlock = synchnorized imbriqué.
}
