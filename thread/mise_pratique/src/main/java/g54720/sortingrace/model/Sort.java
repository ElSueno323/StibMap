package g54720.sortingrace.model;

public abstract class Sort { // classe abstraite.

    protected String nameTri;
    protected int size;
    protected long operations; // dans la classe abstraite ce sera protected.
    protected long debut;
    protected long fin;
    protected long duration;

    protected int [] data;

    public void end(){
        this.fin=System.currentTimeMillis();

        this.operations=operations;
        duration=fin- debut;
    }

    public int getSize(){
        return size;
    }

    public long getOperations(){
        return operations;
    }


    public String getNameTri(){
        return nameTri;
    }
    public long getDuration(){
        return duration;
    }

    public abstract void sort();

    // une méthode sort qui est abstraite et implémenter dans Bubble et dans merge.
}





