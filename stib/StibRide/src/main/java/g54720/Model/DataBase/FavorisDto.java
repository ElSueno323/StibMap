package g54720.Model.DataBase;

import g54720.utils.Dto;

public class FavorisDto extends Dto<Integer[]> {
    private int id_favoris;
    private int id_origin;
    private int id_destination;

    private String text_destination;

    private String text_origin;

    public FavorisDto(int id_favoris,int id_origin,int id_destination,String text_destination,String text_origin){
        super(new Integer[]{id_favoris,id_origin,id_destination});
        this.id_favoris=id_favoris;
        this.id_origin=id_origin;
        this.id_destination=id_destination;
        this.text_destination=text_destination;
        this.text_origin=text_origin;
    }

    @Override
    public String toString() {
        return "id_favoris=" + id_favoris +
                ", id_origin=" + id_origin +
                ", id_destination=" + id_destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavorisDto that)) return false;
        if (!super.equals(o)) return false;

        if (id_favoris != that.id_favoris) return false;
        if (id_origin != that.id_origin) return false;
        return id_destination == that.id_destination;
    }

    public String getText_destination() {
        return text_destination;
    }

    public String getText_origin() {
        return text_origin;
    }

    public int getId_favoris() {
        return id_favoris;
    }

    public int getId_origin() {
        return id_origin;
    }

    public int getId_destination() {
        return id_destination;
    }
}
