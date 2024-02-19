package g54720.Model.DataBase;

import g54720.utils.Dto;

public class StopsDto extends Dto<Integer[]> {
    private int id_line;
    private int id_station;
    private int id_order;

    public StopsDto(int id_line,int id_station,int id_order){
        super(new Integer[]{id_line,id_station,id_order});
        this.id_line=id_line;
        this.id_station=id_station;
        this.id_order=id_order;
    }

    public int getId_line() {
        return id_line;
    }

    public int getId_station() {
        return id_station;
    }

    public int getId_order() {
        return id_order;
    }

    @Override
    public String toString() {
        return
                "id_line=" + id_line +
                ", id_station=" + id_station +
                ", id_order=" + id_order ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StopsDto stopsDto = (StopsDto) o;

        if (id_line != stopsDto.id_line) return false;
        if (id_station != stopsDto.id_station) return false;
        return id_order == stopsDto.id_order;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id_line;
        result = 31 * result + id_station;
        result = 31 * result + id_order;
        return result;
    }

    public void setId_line(int id_line) {
        this.id_line = id_line;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
}
