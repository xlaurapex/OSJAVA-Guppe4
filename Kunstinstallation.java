
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
                             int jahresangabe, String thema, double attraktivitaet, int kosten,
                             String nameMuseums, String anschriftMuseums, int hoehe,
                             int breite, int laenge, double gewicht) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema,
                attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.laenge = laenge;
        this.gewicht = gewicht;
    }

            /**
 * Getters and setters - da wir alle Attributen als private deklariert haben, brauchen wir jetzt getters und setters, um den Zugang zu den Attributen zu gewärhleisten
 */
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
