package at.htl.skischool.entity;

public class Course {

    private String name;
    private int member;
    private Class aClass;
    private Location location;
    private Skiteacher skiteacher;

    public Course() {
    }

    public Course(String name, int aclass, Location location, Skiteacher skiteacher) {
        this.name = name;
        this.location = location;
        this.skiteacher = skiteacher;

        switch (aclass) {
            case 1:
                this.aClass = Class.PROFIS;
                break;
            case 2:
                this.aClass = Class.KOENNER;
                break;
            case 3:
                this.aClass = Class.ANFAENGER;
                break;
            default:
                this.aClass = Class.UNBEKANNT;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Skiteacher getSkiteacher() {
        return skiteacher;
    }

    public void setSkiteacher(Skiteacher skiteacher) {
        this.skiteacher = skiteacher;
    }

    @Override
    public String toString() {
        return "Kurs " +
                "namens " + name +
                ", hat " + member +
                " teilnehmer" +
                "\n";
    }
}
