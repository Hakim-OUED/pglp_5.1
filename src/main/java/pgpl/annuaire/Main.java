package pgpl.annuaire;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args )
    {
        Annuaire a;
        Section a1 = new Section("Direction");
        Section a2 = new Section("Comptabilite");
        Section a3 = new Section("Autre");
        Section a4 = new Section("Tresorerie");
        Personnel p1 = new Personnel.BuilederPersonnel("Hakim","PDG","0758841701").build();
        Personnel p2 = new Personnel.BuilederPersonnel("Hamid","Responsable suivis","0758841701").build();
        Personnel p3 = new Personnel.BuilederPersonnel("OUEDRAOGO","coursier","0758841701").build();
        Personnel p5 = new Personnel.BuilederPersonnel("OUEDRAOGO","coursier","0758841701").build();
        Personnel p4 = new Personnel.BuilederPersonnel("Latifa","tresoriere","0758841701").build();

        a1.addContact(p1);
        a1.addContact(a2);
        a1.addContact(a3);
        a2.addContact(a4);
        a2.addContact(p2);
        a4.addContact(p4);

        a3.addContact(p3);
        a3.addContact(p5);
        a=new Annuaire(a1);
       // a.hierarchicPrint();
        a.groupPrint();
    }
}