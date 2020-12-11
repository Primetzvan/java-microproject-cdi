package at.htl.skischool.boundary;

import at.htl.skischool.entity.*;
import at.htl.skischool.repository.*;

import javax.inject.Inject;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    @Inject
    public BookingRepository repoBooking;
    @Inject
    public CourseRepository repoCourse;
    @Inject
    public SkistudentRepository repoStudent;

    @GET
    @Path("/booking")
    @Produces(MediaType.TEXT_PLAIN)
    public List bookingString() {

        List<Booking> bookings = repoBooking.findAll();

        return bookings;

    }

    @POST
    @Path("/newBooking")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String newBooking(JsonValue value) {

        Course course = null;
        Skistudent skistudent = null;


        List<Booking> bookingList = new ArrayList<>();

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            course = repoCourse.findById(value.asJsonObject().getString("course"));
            skistudent = repoStudent.findById(value.asJsonObject().getInt("student"));

            Booking booking = new Booking(
                    skistudent,
                    course
            );

            repoCourse.save(course);

            if (value.asJsonObject().containsKey("id")){
                booking.setId(value.asJsonObject().getInt("id"));
            }

            return value.toString();
        } else {
            for (int i = 0; i < value.asJsonArray().size(); i++) {


                course = repoCourse.findById(value.asJsonArray().get(i).asJsonObject().getString("course"));
                skistudent = repoStudent.findById(value.asJsonArray().get(i).asJsonObject().getInt("student"));

                Booking booking = new Booking(
                        skistudent,
                        course
                );

                bookingList.add(booking);

                repoBooking.save(booking);

                if (value.asJsonArray().get(i).asJsonObject().containsKey("id")){
                    booking.setId(value.asJsonArray().get(i).asJsonObject().getInt("id"));
                }

            }

            return bookingList.toString();

        }
    }

    @DELETE
    @Path("/deleteBooking")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteBooking(JsonValue value) {

        StringBuilder elements = new StringBuilder();

        int id;

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            id = value.asJsonObject().getInt("id");

            return repoBooking.delete(id);

        }else {
            for (int i = 0; i < value.asJsonArray().size(); i++) {

                id = value.asJsonArray().get(i).asJsonObject().getInt("id");

                elements.append(repoBooking.delete(id))
                        .append(" ");

            }
            return elements.toString();
        }
    }

    @GET
    @Path("/findBooking")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String findBooking(JsonValue value) {

        int id;
        List<Booking> bookingList = new ArrayList<>();

        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            id = value.asJsonObject().getInt("id");

            return repoBooking.findById(id).toString();

        }
        else if (value.getValueType().equals(JsonValue.ValueType.ARRAY)){
            for (int i = 0; i < value.asJsonArray().size(); i++) {

                id = value.asJsonArray().get(i).asJsonObject().getInt("id");

                bookingList.add(repoBooking.findById(id));
            }

            return bookingList.toString();

        }else {
            return "Keine Buchung mit dieser ID gefunden!";
        }

    }
}


