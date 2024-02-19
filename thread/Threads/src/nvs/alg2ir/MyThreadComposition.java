
package nvs.alg2ir;

/**
 *
 * @author g54720
 */
public class MyThreadComposition {
    private Thread th;
    
    public MyThreadComposition(String s){
        th=new Thread(s);
    }
    
    public void run(){
        for(int i=0;i<10;++i){
            for(int j=0;j<5000;++j);
            System.out.println("MyThreadComposition: "+th.getName());
        }
    }
}
