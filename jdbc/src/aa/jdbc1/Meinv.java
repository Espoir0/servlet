package aa.jdbc1;

import java.util.Date;

public class Meinv {
    private int id;
    private String name;
    private int xw;
    private int height;
    private int other_id;
    private Date date;

    public Meinv() {
    }

    public Meinv(int id, String name, int xw, int height, int other_id, Date date) {
        this.id = id;
        this.name = name;
        this.xw = xw;
        this.height = height;
        this.other_id = other_id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meinv{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", xw=" + xw +
                ", height=" + height +
                ", other_id=" + other_id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXw() {
        return xw;
    }

    public void setXw(int xw) {
        this.xw = xw;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOther_id() {
        return other_id;
    }

    public void setOther_id(int other_id) {
        this.other_id = other_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
