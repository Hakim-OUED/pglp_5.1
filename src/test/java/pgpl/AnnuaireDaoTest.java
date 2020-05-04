package pgpl;

import org.junit.Test;
import pgpl.annuaire.Annuaire;
import pgpl.annuaire.Section;

import static org.junit.Assert.*;

public class AnnuaireDaoTest {
  AnnuaireDao dao;

  public AnnuaireDao init() {

    AnnuaireDao annuaireDAO = (AnnuaireDao) DaoFactory.getAnnuaireDao();
    return annuaireDAO;

  }


  @Test
  public void deleteTest() {
    this.dao = init();
    Section section = new Section("Direction");
    Annuaire a = new Annuaire("annuaire UVSQ", section);
    dao.create(a);
    dao.delete(a);
    assertNull(dao.get("annuaire UVSQ"));
  }
}