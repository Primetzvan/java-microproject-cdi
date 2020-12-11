package at.htl;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceTestLocation {

    @Test
    public void testlocation() {
        var smt =given()
                .when().get("/locationService/location")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        assertThat(smt).isEqualTo("[Die Location 0: Skizentrum Schlick 2000 mit 11 Skiliften" +
                " und 22 Pistenkilometern wurde gespeuchert., Die Location 1: Elferlifte mit 4" +
                " Skiliften und 6 Pistenkilometern wurde gespeuchert., Die Location 2: Muttereralm" +
                " mit 16 Skiliften und 16 Pistenkilometern wurde gespeuchert.]");
    }

}
