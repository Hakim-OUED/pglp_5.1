package pgpl;

import pgpl.annuaire.Annuaire;
import pgpl.annuaire.Personnel;
import pgpl.annuaire.Section;

public class DAOFactory {
    private DAOFactory() {
    }

    public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }

    public static DAO<Annuaire> getAnnuaireDAO() {
        return new AnnuaireDAO();
    }

    public static DAO<Section> getSectionDAO() {
        return new SectionDAO();
    }


}
