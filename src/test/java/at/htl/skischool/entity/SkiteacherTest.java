package at.htl.skischool.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkiteacherTest {

    static Course course;
    static Location location;
    static Skiteacher skiteacher;

    @BeforeAll
    static void beforeAll(){
        location = new Location("Skizentrum Schlick 2000", 11, 22 );
        skiteacher = new Skiteacher("Hans", "Müller", 55,  1430);
        course = new Course("Anfänger20-01-2022", 3, location, skiteacher);
    }

    @Test
    void testToString(){

        String testString = skiteacher.toString();
        String rightString = "Person mit der " +
                "id " + skiteacher.getId() + '\'' +
                ", namens " + skiteacher.getFirstname() +
                " " + skiteacher.getLastname() +
                ", mit dem alter " + skiteacher.getAge() +
                "\n";

        assertThat(testString).isEqualTo(rightString);

    }


}
