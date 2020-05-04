package pgpl;

import pgpl.annuaire.Annuaire;
import pgpl.annuaire.Section;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnnuaireDAO implements DAO<Annuaire>, Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Annuaire> list;

    AnnuaireDAO() {
        this.list = new ArrayList<Annuaire>();
    }

    @Override
    public Annuaire get(String intitule) {
        for (Annuaire a : list){
            if(a.getIntitule().equals(intitule)){
                return a;
            }
        }
        Annuaire annuaire = this.deserialisation(intitule);
        return annuaire;
    }

    @Override
    public List<Annuaire> getAll() {
        return (ArrayList<Annuaire>) list.clone();
    }

    @Override
    public void create(Annuaire annuaire) {
        list.add(annuaire);
        this.serialisation(annuaire);
    }

    @Override
    public void update(Annuaire annuaire, String[] params) {

    }

    @Override
    public void delete(Annuaire annuaire) {
        list.remove(annuaire);
        final String chemin = System.getProperty("user.dir")+ "\\" + annuaire.getIntitule() + ".ser";
        ObjectInputStream reader = null;
        File file = new File(chemin);
        file.delete();
    }

    public void serialisation(Annuaire a) {
        String chemin = a.getIntitule() + ".ser";
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(chemin);
            writer = new ObjectOutputStream(file);
            writer.writeObject(a);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Annuaire deserialisation(String chemin) {
        ObjectInputStream reader = null;
        Annuaire a = null;

        try {
            FileInputStream file = new FileInputStream(chemin);
            reader = new ObjectInputStream(file);
            a = (Annuaire) reader.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
           System.out.println("Le fichier est introuvable");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
}
