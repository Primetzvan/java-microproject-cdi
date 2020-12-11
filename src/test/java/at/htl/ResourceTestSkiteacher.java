package at.htl;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceTestSkiteacher {

    @Test
    public void testskiteacher() {
        var smt =given()
                .when().get("/skiteacherService/skiTeacher")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        assertThat(smt).isEqualTo("[Person mit der id 0', namens Hans Müller, mit dem alter 55, leitet den Kurs Anfänger05-01-2021\n" +
                ", Person mit der id 1', namens Peter Hofer, mit dem alter 50, leitet den Kurs Anfänger05-01-2021\n" +
                ", Person mit der id 2', namens Lisa Müller, mit dem alter 25, leitet den Kurs Anfänger05-01-2021\n" +
                "]");
    }

//    @Test
//    public void testnewSkiTeacher() {
//        var smt =given()
//                .when().post("/skiteacherService/newSkiTeacher")
//                .then()
//                .statusCode(200);
//
//    //    assertThat(smt));
//    }
//
//    @Test
//    public void testdeletenewSkiTeacher() {
//        var smt =given()
//                .when().post("/skiteacherService/deleteSkiteacher")
//                .then()
//                .statusCode(200);
//    }


}
