package g54720.sortingrace.model;

import g54720.sortingrace.util.Observable;
import g54720.sortingrace.util.Observer;

import java.util.ArrayList;

public class SortingThread  extends Thread  implements Observable {

    private final ArrayList<Observer> observer;

    //private final DataGenerator dg;

    private final Sort sort;
    //public SortingThread(DataGenerator dg){ // passer un Sort
    public SortingThread(Sort sort){
        this.sort=sort;
        observer=new ArrayList<>();
    }

    @Override
    public void run(){

        sort.sort();

        notifyObserver(sort);
        /*
        int[] data;
        while((data = dg.getNext())!=null){
            Sort sort=sortBegin(data);

            notifyObserver(sort);
        }

         */
    }
/*
    private Sort sortBegin(int[]tb){
        Sort trii;
        Type type=dg.getSortinf().getType();
        long oper;

        if (type == Type.BUBBLE) {
            trii=new BubbleSort(tb.length);
            oper = bulles(tb);
            trii.end(oper);
        } else {
            trii=new MergeSort(tb.length);

            oper = fusion(tb);
            trii.end(oper);
        }

        return trii;
    }

 */
/*
    private int fusion(int tab []){
        int opt =0;
        opt=opt+mergeSort(tab,tab.length);
        opt++;
        return opt;
    }

    // dans Merge
    private static int mergeSort(int[]tb,int sz){ // dans Merge
        int opt=0;
        if(sz<2){
            return 1;
        }
        int mid=sz/2;
        int[]l=new int[mid];
        int[]r=new int[sz-mid];
        for (int i = 0; i <mid ; i++) {
            l[i]=tb[i]; opt++;
        }
        for (int i = mid; i <sz ; i++) {
            r[i-mid]=tb[i]; opt++;
        }
        opt=opt+mergeSort(l,mid)+mergeSort(tb,sz-mid);
        opt=opt+merge(tb,l,r,mid,sz-mid);
        return opt;
    }

    private static int merge(int []a,int []l,int[]r,int left ,int right){
        int cpt=0;
        int i=0,j=i,k=j;
        while(i<left && j<right){ cpt++;
            if(l[i]<=r[j]){

                a[k++]=l[i++];

            }else{
                a[k++]=r[j++];
            }
            cpt++;cpt++;
        }
        while(i<left){
            a[k++]=l[i++];
            cpt++;cpt++;
        }
        while(j<right){
            a[k++]=r[j++];
            cpt++;cpt++;
        }
        return cpt;
    }


    // Bubble
    private long bulles(int tab[]){ // Bubble
        long opt =0;
        int i=0 , size=tab.length; opt++;opt++;
        boolean swapNeeded=true; opt++;
        while(i<size-1 && swapNeeded){ opt++;
            swapNeeded=false; opt++;
            for (int j = 1; j <size-1 ; j++) { opt++;opt++;

                if(tab[j-1]>tab[j]) { opt++;
                    int temp = tab[j - 1]; opt++;
                    tab[j - 1] = tab[j]; opt++;
                    tab[j] = temp; opt++;
                    swapNeeded = true; opt++;
                }
            }
            if(!swapNeeded){ opt++;
                break;
            }
            i++;
        }
        return opt;
    }
*/
    @Override
    public void registerObserver(Observer observer) {
        this.observer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObserver(Object object) {
        for(Observer o:this.observer){
            o.update(object);
        }
    }
}



