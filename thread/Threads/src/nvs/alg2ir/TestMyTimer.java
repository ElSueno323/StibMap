package nvs.alg2ir;

/**
 * Classe de test de la classe MyTimer
 */
public class TestMyTimer {

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(4000);
        myTimer.start();
        try {
            Thread.sleep(7011);
            System.out.println("wait Thread");
        } catch (InterruptedException e) {
            System.out.println("TestMyTimer: exception " + e);
        }
        myTimer.shouldRun = false;//arret du while,de timer, grace à ça 
        System.gc();//appel explicite du garbage collector
        //ici le garbage collectorne sert a rien 
        System.out.println("MyTimer: gc called");
        System.out.println("MyTimer: end");
    }

}
