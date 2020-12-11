package at.htl.skischool.entity;

import at.htl.skischool.entity.Course;
import at.htl.skischool.entity.Skistudent;
import at.htl.skischool.repository.CourseRepository;
import at.htl.skischool.repository.SkistudentRepository;
import at.htl.skischool.repository.SkiteacherRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class CourseRepositoryTest {

    static CourseRepository repo;
    static SkiteacherRepository repoSki;

    @BeforeAll
    static void beforeAll(){
        repo = new CourseRepository();
        repoSki = new SkiteacherRepository();
    }

    @Test
    void addSkiKurs(){
        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.courseList.clear();

        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);
        Course course = new Course("Anfänger20-01-2022", 3, location ,teacher);

        repo.save(course);

        assertThat(repo.courseList).contains(course);

    }


    @Test
    void deleteSkiKurs(){

        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.courseList.clear();
        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);
        Course course = new Course("Anfänger20-01-2022", 3, location ,teacher);

        repo.save(course);

        String id = course.getName();

        repo.delete(id);

        assertThat(repo.courseList).hasSize(0);
        assertThat(repo.courseList).doesNotContain(course);

    }

    @Test
    void findAll(){

        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.courseList.clear();
        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);

        List<Course> list;
        Course course = new Course("Anfänger20-01-2022", 3, location ,teacher);
        Course course1 = new Course("Koenner05-01-2021",2, location ,teacher);
        Course course2 = new Course("Profi05-01-2021",1, location ,teacher);

        repo.save(course);
        repo.save(course1);
        repo.save(course2);

        list = repo.findAll();

        assertThat(list).hasSize(3);
        assertThat(list).contains(course, course1, course2);

    }

    @Test
    void findById(){

        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.courseList.clear();

        String id;

        Skiteacher teacher = new Skiteacher("Hans", "Müller", 55,  1430);

        Course course = new Course("Anfänger20-01-2022", 3, location ,teacher);
        Course course1 = new Course("Koenner05-01-2021",2, location ,teacher);
        Course course2 = new Course("Profi05-01-2021",1, location ,teacher);

        repo.save(course);
        repo.save(course1);
        repo.save(course2);


        id = course.getName();

        Course k = repo.findById(id);

        assertThat(k).isEqualTo(course);

    }

}
