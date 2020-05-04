package pgpl;

import org.junit.Test;
import pgpl.annuaire.Section;

import static org.junit.Assert.*;

public class SectionDaoTest {
  SectionDao dao;

  public SectionDao init() {

    SectionDao sectionDAO = (SectionDao) DaoFactory.getSectionDao();
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