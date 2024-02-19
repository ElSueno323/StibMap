package g54720.sortingrace.model;


import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private List<int[]> data;
    private final int max=10;
    private int actual=0;
    private int divisor;

    private Type type;
    //private final SortInfo sortinf; // c'est objet est en trop.
    public DataGenerator(SizeSort size,Type type) {
        //sortinf=new SortInfo(size,type);
        divisor=size.nbr()/10;
        data=new ArrayList<>();
        generate();
    }

    /*public SortInfo getSortinf() {
        return sortinf;
    }
*/
    public synchronized int[] getNext(){
        if(hasNext()){
            actual++;
            return data.get(actual-1);
        }
        return null;
    }
    private boolean hasNext(){
        return actual<max;
    }


    public List<int[]> getData() {
        return data;
    }

    public int[] getIndexData(int index){
        return data.get(index);
    }

    public int getSize(){
        return data.size();
    }

    private void generate(){
        for (int index=0;index<max;index++){
            int tab[]=new int[index*divisor];
            tab=createTable(tab);
            data.add(actual,tab);
            actual++;
        }
        actual=0;
    }

    private int[] createTable(int[]tab){
        for (int index=0;index<tab.length;index++){
            int randomNumber=(int)(Math.random()*tab.length-1)+1;
            tab[index]=randomNumber;
        }
        return tab;
    }
}







