package at.htl.skischool.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkistudentTest {

    static Course course;
    static Location location;
    static Skistudent skistudent;

    @BeforeAll
    static void beforeAll(){
        location = new Location("Skizentrum Schlick 2000", 11, 22 );
        course = new Course("Anfänger20-01-2022", 3, location);
        skistudent = new Skistudent("Hans", "Müller", 10, course);
    }

    @Test
    void testToString(){

        String testString = skistudent.toString();
        String rightString = "Person mit der " +
                "id " + skistudent.getId() + '\'' +
                ", namens " + skistudent.getFirstname() +
                " " + skistudent.getLastname() +
                ", mit dem alter " + skistudent.getAge() +
                ", befindet sich im Kurs " + skistudent.getCourse().getName() +
                "\n";

        assertThat(testString).isEqualTo(rightString);

    }

}
