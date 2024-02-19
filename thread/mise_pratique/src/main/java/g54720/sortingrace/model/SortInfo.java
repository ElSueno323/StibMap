package g54720.sortingrace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortInfo { // objet en trop, les data sont dans le DataGenerator
    private final Type type;
    private final int div;

    private int actual=0;

    private final int max=10;

    private List<int[]> data; // dans DataGenerator.
    private final Map<Integer,Sort> sorts;
    public SortInfo(SizeSort size,Type type){
        this.type=type;
        div=size.nbr()/10;
        sorts=new HashMap<>();
        data=new ArrayList<>();
        generate();
    }

    private void generate(){
        for(int i=0;i<max;i++) {
            int tab[] = new int[i*div];
            tab = creatT(tab);
            data.add(actual,tab);
            actual++;
        }
        actual=0;
    }

    private int[] creatT(int[]tab){
        for(int i =0;i<tab.length;i++){
            int nbrRandom=(int) (Math.random()*tab.length-1)+1;
            tab[i]=nbrRandom;
        }
        return tab;
    }

    public Type getType() {
        return type;
    }


    public List<int[]> getData() {
        return data;
    }


    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public int getMax() {
        return max;
    }
}
