package pgpl;

import pgpl.annuaire.Annuaire;

import java.io.Serializable;
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
        return null;
    }

    @Override
    public List<Annuaire> getAll() {
        return (ArrayList<Annuaire>) list.clone();
    }

    @Override
    public void create(Annuaire annuaire) {
        list.add(annuaire);
    }

    @Override
    public void update(Annuaire annuaire, String[] params) {

    }

    @Override
    public void delete(Annuaire annuaire) {
        list.remove(annuaire);
    }
}
