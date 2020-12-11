package at.htl.skischool.entity;

import at.htl.skischool.repository.LocationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationRepositoryTest {

    static LocationRepository repo;

    @BeforeAll
    static void beforeAll(){
        repo = new LocationRepository();
    }

    @Test
    void addLocation(){

        repo.locationList.clear();
        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.save(location);

        assertThat(repo.locationList).contains(location);

    }

    @Test
    void updateLocations(){

        Integer id;
        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.locationList.clear();

        repo.save(location);

        id = location.getId();
        Location locationnew = new Location(id, "Skizentrum Schlick 2000", 11, 300 );

        repo.save(locationnew);

        assertThat(repo.locationList.get(0).getKilometersOfSlopes()).isEqualTo(locationnew.getKilometersOfSlopes());

    }

    @Test
    void deleteLocation(){

        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );

        repo.locationList.clear();

        repo.save(location);

        Integer id = location.getId();

        repo.delete(id);

        assertThat(repo.locationList).hasSize(0);
        assertThat(repo.locationList).doesNotContain(location);

    }

    @Test
    void findAllLocations(){

        repo.locationList.clear();

        List<Location> list;

        Location location = new Location("Skizentrum Schlick 2000", 11, 22 );
        Location location1 = new Location("Skizentrum", 11, 22 );
        Location location2 = new Location("Skizentrum Schlick ", 11, 22 );

        repo.save(location);
        repo.save(location1);
        repo.save(location2);

        list = repo.findAll();

        assertThat(list).hasSize(3);
        assertThat(list).contains(location, location1, location2);

    }
}
