package pgpl;

import pgpl.annuaire.Personnel;
import pgpl.annuaire.Section;

import java.io.Serializable;
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
        return null;
    }

    @Override
    public List<Section> getAll() {
        return (ArrayList<Section>) listSection.clone();
    }

    @Override
    public void create(Section section) {
        listSection.add(section);
    }

    @Override
    public void update(Section section, String[] params) {
        listSection.remove(section);
    }

    @Override
    public void delete(Section section) {

    }
}
