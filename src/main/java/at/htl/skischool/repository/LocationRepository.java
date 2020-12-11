package at.htl.skischool.repository;

import at.htl.skischool.entity.Course;
import at.htl.skischool.entity.Location;
import at.htl.skischool.entity.Skistudent;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LocationRepository implements Repository<Location> {

    public List<Location> locationList = new ArrayList<>();


    public LocationRepository() {

        save(new Location("Skizentrum Schlick 2000", 11, 22 ));
        save(new Location("Elferlifte", 4, 6));
        save(new Location("Muttereralm", 16,     16 ));
    }

    public void save(Location entity){


        if (entity.getId() == null){
            //SAVE
            entity.setId(locationList.size());
            locationList.add(entity);

        }else {
            //UPDATE
            Location location = findById(entity.getId());

            location.setName(entity.getName());
            location.setKilometersOfSlopes(entity.getKilometersOfSlopes());
            location.setNumberOfSkilifts(entity.getNumberOfSkilifts());

        }

    }

    public String delete(int id){


        if (id != -1){
            locationList.remove(id);
            renewID();
            return "Gelöscht";
        }

//        for (String i = 0; i < skilehrerList.size(); i++) {
//            skilehrerList.get(i).setId(i);
//        }
        return "Nichts gelöscht";

    }

    public List<Location> findAll(){

        return locationList;

    }

    public Location findById(int id){

        for (Location l: locationList) {
            if (l.getId() == id){
                return l;
            }
        }

        return null;

    }

    private void renewID(){
        for (int i = 0; i < locationList.size(); i++) {
            locationList.get(i).setId(i);
        }
    }

}
