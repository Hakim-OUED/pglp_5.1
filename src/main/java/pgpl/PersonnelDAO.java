package pgpl;

import pgpl.DAO;
import pgpl.annuaire.Personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PersonnelDAO
        implements DAO<Personnel>, Serializable {


    private static final long serialVersionUID = 1L;

    private ArrayList <Personnel> personnels;

    PersonnelDAO(){
        this.personnels = new ArrayList<Personnel>();
    }

    @Override
    public Personnel get(String nom) {
       for (Personnel p : personnels){
           if (p.getNom().equals(nom)){
               return p;
           }
       }
       return null;
    }

    @Override
    public List getAll() {
        return (ArrayList<Personnel>) personnels.clone();
    }

    @Override
    public void create(Personnel p) {
        personnels.add(p);
    }

    @Override
    public void update(Personnel personnel, String[] params) {

    }

    @Override
    public void delete(Personnel p) {
        personnels.remove(p);
    }


}
