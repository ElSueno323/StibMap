package g54720.sortingrace.model;


public class BubbleSort extends Sort{
    // tout ça dans Sort qui est une classe abstraite.
 // dans la classe abstraite ce sera protected.

    public BubbleSort(int size){
        this.size=size;
        this.debut = System.currentTimeMillis();
        nameTri="BUBBLE";
    }

    @Override
    public void sort() {
        int i=0 , size=data.length; operations++;operations++;
        boolean swapNeeded=true; operations++;
        while(i<size-1 && swapNeeded){ operations++;
            swapNeeded=false; operations++;
            for (int j = 1; j <size-1 ; j++) { operations++;operations++;

                if(data[j-1]>data[j]) { operations++;
                    int temp = data[j - 1]; operations++;
                    data[j - 1] = data[j]; operations++;
                    data[j] = temp; operations++;
                    swapNeeded = true; operations++;
                }
            }
            if(!swapNeeded){ operations++;
                break;
            }
            i++;
        }
        end();
    }
}






