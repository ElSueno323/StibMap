package g54720.Model.DataBase;

import g54720.utils.Dto;

public class LineDto extends Dto<Integer> {
    private int id;
    public LineDto(int id){
        super(id);
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineDto lineDto)) return false;
        if (!super.equals(o)) return false;

        return id == lineDto.id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return
                "id=" + id ;
    }
}
