
/**
 * Die Klasse „Kunstgegenstand“ ist eine Child-Klasse der abstrakten Klasse „Kunstwerk“, welche durch die besonderen 
 * Attribute eines Kunstgegenstands (z.B. Länge) ergänzt wird. Die Klasse „Kunstgegenstand“ ist somit eine Datenträgerklasse.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kunstgegenstand extends Kunstwerk {
    private int laenge;
    private double gewicht;

    public Kunstgegenstand(long laufendeNummer, String bezeichnung,
                           String kuenstlername, int jahresangabe,
                           String thema, double attraktivitaet, int kosten,
                           String nameMuseums, String anschriftMuseums, int hoehe,
                           int breite, int laenge, double gewicht) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema,
                attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.laenge = laenge;
        this.gewicht = gewicht;
    }

    //Getters und Setters

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return "Kunstgegenstand{" +
                super.toString() +
                "laenge=" + laenge +
                ", gewicht=" + gewicht +
                '}';
    }
}
