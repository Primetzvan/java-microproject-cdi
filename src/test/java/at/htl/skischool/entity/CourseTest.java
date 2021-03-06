package at.htl.skischool.entity;

import at.htl.skischool.repository.SkistudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseTest {

    static Course course;
    static Location location;
    static Skiteacher teacher;

    @BeforeAll
    static void beforeAll(){
        location = new Location("Skizentrum Schlick 2000", 11, 22 );
        teacher = new Skiteacher("Hans", "Müller", 55,  1430);
        course = new Course("Anfänger20-01-2022", 3, location ,teacher);
    }

    @Test
    void testToString(){

        String testString = course.toString();
        String rightString = "Kurs " +
                "namens " + course.getName() +
                ", hat " + course.getMember() +
                " teilnehmer" +
                "\n";

        assertThat(testString).isEqualTo(rightString);

    }


}
