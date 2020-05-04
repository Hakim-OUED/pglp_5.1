package pgpl;

import org.junit.Test;
import pgpl.annuaire.Personnel;

import static org.junit.Assert.*;

public class PersonnelDAOTest {
    PersonnelDAO dao;
    public PersonnelDAO init() {

        PersonnelDAO personnelDAO = (PersonnelDAO) DAOFactory.getPersonnelDAO();
        return personnelDAO;

    }


    @Test
    public void createTest() {
        this.dao = init();
        Personnel p1 = new Personnel.BuilederPersonnel("Hakim","PDG","0758841701").build();
        dao.create(p1);
        Personnel p2 = dao.get("Hakim");
        String expected = "Nom:  Hakim " +
                "Fonction: PDG " +
                "Telephone{{numéro pro=0758841701}}";

        assertTrue(p2.toString().equals(expected));
    }

}