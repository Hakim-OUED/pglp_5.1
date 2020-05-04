package pgpl;

import pgpl.DAO;
import pgpl.annuaire.Personnel;

import java.io.*;
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
       Personnel p = deserialisation(nom);

       return p;
    }

    @Override
    public List getAll() {
        return (ArrayList<Personnel>) personnels.clone();
    }

    @Override
    public void create(Personnel p) {
        personnels.add(p);
        this.serialisation(p);
    }

    @Override
    public void update(Personnel personnel, String[] params) {

    }

    @Override
    public void delete(Personnel p) {
        personnels.remove(p);
        final String chemin = System.getProperty("user.dir")+ "\\" + p.getNom() + ".ser";
        ObjectInputStream reader = null;
        File file = new File(chemin);
        file.delete();
    }

    public void serialisation(Personnel p) {
        String chemin = p.getNom() + ".ser";
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(chemin);
            writer = new ObjectOutputStream(file);
            writer.writeObject(p);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Personnel deserialisation(String chemin) {
        ObjectInputStream reader = null;
        Personnel p = null;

        try {
            FileInputStream file = new FileInputStream(chemin);
            reader = new ObjectInputStream(file);
            p = (Personnel) reader.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("le fichier introuvable");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }

}
