package nvs.alg2ir;

/**
 * Classe de test de la classe MyThread
 */
public class TestMyThread {

    public static void main(String[] args) {
        MyThread t = new MyThread("one");
        t.start(); //permet de lancer une thread dans une xecutioin parallele
        // t.run(); //execut le thread dans la meme execution donc pas parallele
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10000000; ++j) ;
            System.out.println("TestMyThread: " + i);
        }
    }
}
