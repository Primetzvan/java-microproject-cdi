package at.htl.skischool.boundary;

import at.htl.skischool.entity.Course;
import at.htl.skischool.entity.Location;
import at.htl.skischool.entity.Skistudent;
import at.htl.skischool.repository.CourseRepository;
import at.htl.skischool.repository.LocationRepository;
import at.htl.skischool.repository.SkistudentRepository;
import at.htl.skischool.repository.SkiteacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/locationService")
public class LocationService {

    @Inject
    public LocationRepository repoLocation;

//    public CourseRepository repoCourse = new CourseRepository();
//    public SkiteacherRepository repoTeacher = new SkiteacherRepository();
//    public SkistudentRepository repoStudent = new SkistudentRepository();
//    public LocationRepository repoLocation = new LocationRepository();


    @GET
    @Path("/location")
    @Produces(MediaType.TEXT_PLAIN)
    public List location() {

        List<Location> locations = repoLocation.findAll();

        return locations;

    }


    @POST
    @Path("/newLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public String newLocation(JsonValue value) {

        List<Location> locationList = new ArrayList<>();

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {


            Location location = new Location(
                    value.asJsonObject().getString("name"),
                    value.asJsonObject().getInt("numberOfSkilifts"),
                    value.asJsonObject().getInt("kilometersOfSlopes")
            );

            repoLocation.save(location);

            if (value.asJsonObject().containsKey("id")){
                location.setId(value.asJsonObject().getInt("id"));
            }

            return value.toString();
        } else {
            for (int i = 0; i < value.asJsonArray().size(); i++) {

                Location location = new Location(
                        value.asJsonArray().get(i).asJsonObject().getString("name"),
                        value.asJsonArray().get(i).asJsonObject().getInt("numberOfSkilifts"),
                        value.asJsonArray().get(i).asJsonObject().getInt("kilometersOfSlopes")
                );

                locationList.add(location);

                repoLocation.save(location);

                if (value.asJsonArray().get(i).asJsonObject().containsKey("id")){
                    location.setId(value.asJsonArray().get(i).asJsonObject().getInt("id"));
                }

            }

            return locationList.toString();

        }


    }


    @DELETE
    @Path("/locationDelete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String locationDelete(JsonValue value) {

        StringBuilder elements = new StringBuilder();

        int id;

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            id = value.asJsonObject().getInt("id");

            return repoLocation.delete(id);

        }else {
            for (int i = 0; i < value.asJsonArray().size(); i++) {

                id = value.asJsonArray().get(i).asJsonObject().getInt("id");

                elements.append(repoLocation.delete(id))
                        .append(" ");

            }
            return elements.toString();
        }
    }

    @GET
    @Path("/findLocation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String findLocation(JsonValue value) {

        int id;
        List<Location> locations = new ArrayList<>();

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            id = value.asJsonObject().getInt("id");

            return repoLocation.findById(id).toString();

        }
        else if (value.getValueType().equals(JsonValue.ValueType.ARRAY)){
            for (int i = 0; i < value.asJsonArray().size(); i++) {

                id = value.asJsonArray().get(i).asJsonObject().getInt("id");

                locations.add(repoLocation.findById(id));
            }

            return locations.toString();

        }else {
            return "Kein Skigebiet mit dieser ID gefunden!";
        }

    }



}
