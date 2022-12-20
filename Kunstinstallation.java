
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

    public Kunstinstallation(long laufendeNummer, String bezeichnung, String kuenstlername,
                             int jahresangabe, String thema, double attraktivitaet, int kosten,
                             String nameMuseums, String anschriftMuseums, int hoehe,
                             int breite, int laenge, double gewicht) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema,
                attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.laenge = laenge;
        this.gewicht = gewicht;
    }

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
        return "Kunstinstallation{" +
                super.toString() +
                "laenge=" + laenge +
                ", gewicht=" + gewicht +
                '}';
    }
}
