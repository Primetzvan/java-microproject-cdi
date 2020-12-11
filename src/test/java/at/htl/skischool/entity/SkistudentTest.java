package at.htl.skischool.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkistudentTest {

    static Course course;
    static Location location;
    static Skistudent skistudent;
    static Skiteacher teacher;

    @BeforeAll
    static void beforeAll(){
        location = new Location("Skizentrum Schlick 2000", 11, 22 );
        teacher =new Skiteacher("Hans", "Müller", 55,  1430);
        course = new Course("Anfänger20-01-2022", 3, location, teacher);
        skistudent = new Skistudent("Hans", "Müller", 10);
    }

    @Test
    void testToString(){

        String testString = skistudent.toString();
        String rightString = "Person mit der " +
                "id " + skistudent.getId() + '\'' +
                ", namens " + skistudent.getFirstname() +
                " " + skistudent.getLastname() +
                ", mit dem alter " + skistudent.getAge() +
                "\n";

        assertThat(testString).isEqualTo(rightString);

    }

}
