package g54720.sortingrace.model;

public class MergeSort extends Sort{

    public MergeSort(int size){
        this.size=size;
        this.debut = System.currentTimeMillis();
        nameTri="MERGE";
        operations=0;
    }

    @Override
    public void sort() {
        operations=operations+mergeSort(data,data.length);
        operations++;
        end();
    }
    private long mergeSort(int[]tb,int sz){
        // dans Merge
        //int opt=0;
        if(sz<2){
            return 1;
        }
        int mid=sz/2;
        int[]l=new int[mid];
        int[]r=new int[sz-mid];
        for (int i = 0; i <mid ; i++) {
            l[i]=tb[i]; operations++;
        }
        for (int i = mid; i <sz ; i++) {
            r[i-mid]=tb[i]; operations++;
        }
        operations=operations+mergeSort(l,mid)+mergeSort(tb,sz-mid);
        operations=operations+merge(tb,l,r,mid,sz-mid);
        return operations;
    }

    private static long merge(int []a,int []l,int[]r,int left ,int right){
        long cpt=0;
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


}










