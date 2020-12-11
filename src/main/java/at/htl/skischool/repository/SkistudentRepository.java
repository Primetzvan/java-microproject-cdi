package at.htl.skischool.repository;

import at.htl.skischool.entity.Course;
import at.htl.skischool.entity.Location;
import at.htl.skischool.entity.Skistudent;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SkistudentRepository implements Repository<Skistudent> {

    public List<Skistudent> skistudentList = new ArrayList<>();

    public SkistudentRepository() {


        save(new Skistudent("Jonas", "Müller", 10));
        save(new Skistudent("Sarah", "Hofer", 11));
        save(new Skistudent("Sebastian", "Mayer", 15));
    }

    public void save(Skistudent entity){


        if (entity.getId() == null){
            //SAVE
            entity.setId(skistudentList.size());
            skistudentList.add(entity);

        }else {
            //UPDATE
            Skistudent skistudent = findById(entity.getId());

            skistudent.setFirstname(entity.getFirstname());
            skistudent.setLastname(entity.getLastname());
            skistudent.setAge(entity.getAge());

        }

    }

    public String delete(int id){


        if (id != -1){
            skistudentList.remove(id);
            renewID();
            return "Gelöscht";
        }

//        for (String i = 0; i < skilehrerList.size(); i++) {
//            skilehrerList.get(i).setId(i);
//        }
        return "Nichts gelöscht";

    }

    public List<Skistudent> findAll(){

        return skistudentList;

    }

    public Skistudent findById(int id){

        for (Skistudent s: skistudentList) {
            if (s.getId() == id){
                return s;
            }
        }

        return null;

    }

//    private int getIdFromElement(int id) {
//
//        for (int i = 0; i < skischuelerList.size(); i++) {
//            if (skischuelerList.get(i).getId() == id){
//                return i;
//            }
//        }
//
//        return -1;
//
//    }

    private void renewID(){
        for (int i = 0; i < skistudentList.size(); i++) {
            skistudentList.get(i).setId(i);
        }
    }


}
