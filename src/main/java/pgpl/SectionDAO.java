package pgpl;

import pgpl.annuaire.Section;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO
        implements DAO<Section>, Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Section> listSection;

    SectionDAO(){
        listSection = new ArrayList<Section>();
    }

    @Override
    public Section get(String nom) {
        for(Section section : listSection) {
            if (section.getNomSection().equals(nom)){
                return section;
            }
        }
        Section section = deserialisation(nom);
        return section;
    }

    @Override
    public List<Section> getAll() {
        return (ArrayList<Section>) listSection.clone();
    }

    @Override
    public void create(Section section) {
        listSection.add(section);
        this.serialisation(section);
    }

    @Override
    public void update(Section section, String[] params) {
        listSection.remove(section);
    }

    @Override
    public void delete(Section section) {
        listSection.remove(section);
        final String chemin = System.getProperty("user.dir")+ "\\" + section.getNomSection() + ".ser";
        ObjectInputStream reader = null;
        File file = new File(chemin);
        file.delete();
    }

    public void serialisation(Section s) {
        String chemin = s.getNomSection() + ".ser";
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(chemin);
            writer = new ObjectOutputStream(file);
            writer.writeObject(s);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Section deserialisation(String chemin) {
        ObjectInputStream reader = null;
        Section s = null;

        try {
            FileInputStream file = new FileInputStream(chemin);
            reader = new ObjectInputStream(file);
            s = (Section) reader.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("le fichier introuvable");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
