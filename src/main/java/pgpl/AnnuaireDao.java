package pgpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pgpl.annuaire.Annuaire;

public class AnnuaireDao implements Dao<Annuaire>, Serializable {

  private static final long serialVersionUID = 1L;
  private ArrayList<Annuaire> list;

  AnnuaireDao() {
    this.list = new ArrayList<Annuaire>();
  }

  @Override
  public Annuaire get(String intitule) {
    for (Annuaire a : list) {
      if (a.getIntitule().equals(intitule)) {
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
    final String chemin = System.getProperty("user.dir") + "\\" + annuaire.getIntitule() + ".ser";
    ObjectInputStream reader = null;
    File file = new File(chemin);
    file.delete();
  }

  /**
   * methode de Serialisation d'annuaire.
   * @param annuaire l'annuaire à sérialiser
   */
  public void serialisation(Annuaire annuaire) {
    String chemin = annuaire.getIntitule() + ".ser";
    ObjectOutputStream writer = null;
    try {
      FileOutputStream file = new FileOutputStream(chemin);
      writer = new ObjectOutputStream(file);
      writer.writeObject(annuaire);
      writer.flush();
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Methode de désérialisation d'annuaire.
   * @param chemin le chemin du fichier avec l'extension
   * @return l'objet correspondant
   */
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
