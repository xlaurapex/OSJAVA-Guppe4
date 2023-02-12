
/**
 * Die Klasse „Kunstinstallation“ ist eine Child-Klasse der abstrakten Klasse „Kunstwerk“, wel-che durch die Besonderheiten 
 * einer Kunstinstallation (z.B. alleinige Platzierung im Raum) ergänzt wird. Die Klasse „Kunstinstallation“ ist somit eine Datenträgerklasse.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kunstinstallation extends Kunstwerk
{
    private int laenge;
    private double gewicht;

       /**
 * Kontruktor für Objekte der abstrakten Klasse Kunstunstallation
 */
public Kunstinstallation(int laufendeNummer, String bezeichnung, String kuenstlername,
                             String jahresangabe, String thema, double attraktivitaet, int kosten,
                             String nameMuseums, String anschriftMuseums, int hoehe,
                             int breite, int laenge, double gewicht) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema,
                attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.laenge = laenge;
        this.gewicht = gewicht;
    }

    /**
     * Da das Attribut Laenge als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getLaenge() {
        return laenge;
    }

    /**
     * Da das Attribut Laenge als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    /**
     * Da das Attribut Gewicht als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public double getGewicht() {
        return gewicht;
    }

    
    /**
     * Da das Attribut Gewicht als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    /**
 * Representiert die Klasse als String
 */
    public String toString() {
        return "Kunstinstallation{" +
                super.toString() +
                "laenge=" + laenge +
                ", gewicht=" + gewicht +
                '}';
    }
    

}
