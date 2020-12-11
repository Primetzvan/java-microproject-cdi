package at.htl;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ResourceTestCourse {

    @Test
    public void testcourse() {
        var smt =given()
                .when().get("/courseService/course")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        assertThat(smt).isEqualTo("[Kurs namens Anfänger05-01-2021, hat 0 teilnehmer\n" +
                ", Kurs namens Koenner05-01-2021, hat 0 teilnehmer\n" +
                ", Kurs namens Profis22-12-2020, hat 0 teilnehmer\n" +
                "]");
    }


    @Test
    public void testnewcourse() {
        given()
         .accept(ContentType.JSON)
         .contentType(ContentType.JSON)
         .body(
         """
           {
             "name": "Anfänger14-12-2020",
             "aclass": 3,
             "location": 0
           }
         """)
         .when().post("/courseService/newCourse")
         .then()
             .statusCode(200);
    }

//    @Test
//    public void testHelloEndpoint() {
//        given()
//          .when().get("/resteasy/hello")
//          .then()
//             .statusCode(200)
//             .body(is("hello"));
//    }

}
