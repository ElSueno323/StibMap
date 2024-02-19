package g54720.Model.DataBase;

import g54720.utils.Dto;

import java.util.Objects;

public class StationsDto extends Dto<Integer> {
    private int id;
    private String text;
    public StationsDto(int id, String text){
        super(id);
        this.id=id;
        this.text=text;
    }

    public int getId(){
        return id;
    }
    public String getText(){
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationsDto that)) return false;
        if (!super.equals(o)) return false;

        if (id != that.id) return false;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", text='" + text ;
    }
}
