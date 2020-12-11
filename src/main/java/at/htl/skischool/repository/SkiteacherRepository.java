package at.htl.skischool.repository;

import at.htl.skischool.entity.Course;
import at.htl.skischool.entity.Location;
import at.htl.skischool.entity.Skiteacher;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SkiteacherRepository implements Repository<Skiteacher>{

    public List<Skiteacher> skiteacherList = new ArrayList<>();

    public SkiteacherRepository() {

        save(new Skiteacher("Hans", "Müller", 55,  1430));
        save(new Skiteacher("Peter", "Hofer", 50,  1000));
        save(new Skiteacher("Lisa", "Müller", 25,  1000));
    }

    public void save(Skiteacher entity){


        if (entity.getId() == null){
            //SAVE
            entity.setId(skiteacherList.size());
            skiteacherList.add(entity);

        }else {
            //UPDATE
            Skiteacher lehrer = findById(entity.getId());

            lehrer.setFirstname(entity.getFirstname());
            lehrer.setLastname(entity.getLastname());
            lehrer.setAge(entity.getAge());
            lehrer.setSalary(entity.getSalary());

        }



//        id = getElement(entity);
//
//        if (id != -1){
//            entity.setId(id);
//        }

    }

    public String delete(int id){

        int idToDelete;

        idToDelete = getIdFromElement(id);
        if (idToDelete != -1){
            skiteacherList.remove(idToDelete);
            renewID();
            return "Gelöscht";
        }

//        for (String i = 0; i < skilehrerList.size(); i++) {
//            skilehrerList.get(i).setId(i);
//        }
        return "Nichts Gelöscht";

    }

    public List<Skiteacher> findAll(){

        return skiteacherList;

    }

    public Skiteacher findById(int id){

        for (Skiteacher s: skiteacherList) {
            if (s.getId() == id){
                return s;
            }
        }

        return null;

    }

    private int getIdFromElement(int id) {

        for (int i = 0; i < skiteacherList.size(); i++) {
            if (skiteacherList.get(i).getId() == id){
                return i;
            }
        }

        return -1;

    }

    private void renewID(){
        for (int i = 0; i < skiteacherList.size(); i++) {
            skiteacherList.get(i).setId(i);
        }
    }


}
