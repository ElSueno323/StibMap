package g54720.sortingrace.model;

public enum Type {
    BUBBLE("Bubble"),MERGE("Merge");

    private String type;

    Type(String type){
        this.type=type;
    }
    @Override
    public String toString() {
        return type;
    }
}
