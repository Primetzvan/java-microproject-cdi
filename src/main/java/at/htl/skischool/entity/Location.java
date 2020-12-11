package at.htl.skischool.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {

    private Integer id;
    private String name;
    private int numberOfSkilifts;
    private int kilometersOfSlopes;


    public Location(String name, int numberOfSkilifts, int numberOfSlopes) {
        this.name = name;
        this.numberOfSkilifts = numberOfSkilifts;
        this.kilometersOfSlopes = numberOfSlopes;
    }

    public Location(int id, String name, int numberOfSkilifts, int numberOfSlopes) {
        this.id = id;
        this.name = name;
        this.numberOfSkilifts = numberOfSkilifts;
        this.kilometersOfSlopes = numberOfSlopes;
    }

    public Location() {
    }

    public Integer getId() {
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

    public int getNumberOfSkilifts() {
        return numberOfSkilifts;
    }

    public void setNumberOfSkilifts(int numberOfSkilifts) {
        this.numberOfSkilifts = numberOfSkilifts;
    }

    public int getKilometersOfSlopes() {
        return kilometersOfSlopes;
    }

    public void setKilometersOfSlopes(int kilometersOfSlopes) {
        this.kilometersOfSlopes = kilometersOfSlopes;
    }

    @Override
    public String toString() {
        return "Die Location "
                + this.getId()
                + ": "
                + this.getName()
                + " mit "
                + this.getNumberOfSkilifts()
                + " Skiliften und "
                + this.getKilometersOfSlopes()
                + " Pistenkilometern wurde gespeuchert.";
    }
}
