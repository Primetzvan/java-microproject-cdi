package at.htl.skischool.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Skistudent extends Person{

    public Skistudent(String firstname, String lastname, int age) {
        super(firstname, lastname, age);
    }

    protected Skistudent(int id, String firstname, String lastname, int age) {
        super(id, firstname, lastname, age);

    }

    public Skistudent() {
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
