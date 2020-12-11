package at.htl.skischool.repository;

import at.htl.skischool.entity.Booking;
import at.htl.skischool.entity.Location;
import at.htl.skischool.entity.Skistudent;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookingRepository{

    public List<Booking> bookingList = new ArrayList<>();

    public void save(Booking entity){


        if (entity.getId() == null){
            //SAVE
            entity.setId(bookingList.size());
            bookingList.add(entity);

        }else {
            //UPDATE
            Booking booking = findById(entity.getId());

            booking.setCourse(entity.getCourse());
            booking.setStudent(entity.getStudent());
        }


    }

    public String delete(int id){


        if (id != -1){
            bookingList.remove(id);
            renewID();
            return "Gelöscht";
        }

//        for (String i = 0; i < skilehrerList.size(); i++) {
//            skilehrerList.get(i).setId(i);
//        }
        return "Nichts gelöscht";

    }

    public List<Booking> findAll(){

        return bookingList;

    }

    public Booking findById(int id){

        for (Booking l: bookingList) {
            if (l.getId() == id){
                return l;
            }
        }

        return null;

    }

    private void renewID(){
        for (int i = 0; i < bookingList.size(); i++) {
            bookingList.get(i).setId(i);
        }
    }

}
