package at.htl.skischool.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    static Location location;

    @BeforeAll
    static void beforeAll(){
        location = new Location("Skizentrum Schlick 2000", 11, 22 );
    }

    @Test
    void testToString(){

        String testString = location.toString();
        String rightString = "Die Location "
                + location.getId()
                + ": "
                + location.getName()
                + " mit "
                + location.getNumberOfSkilifts()
                + " Skiliften und "
                + location.getKilometersOfSlopes()
                + " Pistenkilometern wurde gespeuchert.";

        assertThat(testString).isEqualTo(rightString);

    }

}
