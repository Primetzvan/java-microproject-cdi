package at.htl;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceTestSkistudent {

    @Test
    public void testskistudent() {
        var smt =given()
                .when().get("/skistudentService/skiStudent")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        assertThat(smt).isEqualTo("[Person mit der id 0', namens Jonas Müller, mit dem alter 10, befindet sich im Kurs Anfänger05-01-2021\n" +
                ", Person mit der id 1', namens Sarah Hofer, mit dem alter 11, befindet sich im Kurs Anfänger05-01-2021\n" +
                ", Person mit der id 2', namens Sebastian Mayer, mit dem alter 15, befindet sich im Kurs Anfänger05-01-2021\n" +
                "]");
    }

//    @Test
//    public void testnewSkiStudent() {
//        var smt =given()
//                .when().post("/skiteacherService/newSkiTeacher")
//                .then()
//                .statusCode(200);
//
//        //    assertThat(smt));
//    }
//
//    @Test
//    public void testdeletenewSkiStuden() {
//        var smt =given()
//                .when().post("/skiteacherService/deleteSkiteacher")
//                .then()
//                .statusCode(200);
//    }

}
