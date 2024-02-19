package g54720.sortingrace.model;

public enum SizeSort {
    VERY_EASY(100),EASY(1000),MEDIUM(10000),HARD(100_000),VERY_HARD(1_000_000);
    private int nbr;
    SizeSort(int nbr){
        this.nbr=nbr;
    }
    public int nbr() {
        return nbr;
    }
}
