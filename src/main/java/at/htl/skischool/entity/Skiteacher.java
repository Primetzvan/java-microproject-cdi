package at.htl.skischool.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Skiteacher extends Person {

    private int salary;

    public Skiteacher(String firstname, String lastname, int age,int salary) {
        super(firstname, lastname, age);
        this.salary = salary;
    }

    protected Skiteacher(int id, String firstname, String lastname, int age,int salary) {
        super(id, firstname, lastname, age);
        this.salary = salary;
    }

    public Skiteacher() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person mit der " +
                "id " + super.getId() + '\'' +
                ", namens " + super.getFirstname() +
                " " + super.getLastname() +
                ", mit dem alter " + super.getAge() +
                "\n";
    }

}
