package pgpl;

import org.junit.Test;
import pgpl.annuaire.Personnel;
import pgpl.annuaire.Section;

import static org.junit.Assert.*;

public class SectionDAOTest {
    SectionDAO dao;
    public SectionDAO init() {

        SectionDAO sectionDAO = (SectionDAO) DAOFactory.getSectionDAO();
        return sectionDAO;
    }


    @Test
    public void getTest() {
        this.dao = init();
        Section section = new Section("Direction");
        dao.create(section);
        Section s = dao.get("Direction");
        String expected = "Section: Direction";
        assertTrue(s.toString().equals(expected));
    }
}