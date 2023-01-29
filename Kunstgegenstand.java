
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
    //neue Attribute
    //Platzierung im Raum in cm ausgehend von der Nordwest-Ecke
    private int xPlatzierung;
    private int yPlatzierung;

       /**
     * Kontruktor für Objekte der abstrakten Klasse Kunstgegenstand
     */
    public Kunstgegenstand(int laufendeNummer, String bezeichnung,
                           String kuenstlername, String jahresangabe,
                           String thema, double attraktivitaet, int kosten,
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
    
    public int getXPlatzierung() {
        return xPlatzierung;
    }

    public void setXPlatzierung(int xPlatzierung) {
        this.xPlatzierung = xPlatzierung;
    }
    
    public int getYPlatzierung() {
        return yPlatzierung;
    }

    public void setYPlatzierung(int yPlatzierung) {
        this.yPlatzierung = yPlatzierung;
    }

    /**
     * Representiert die Klasse als String
     */
    public String toString() {
        return "Kunstgegenstand{" +
                super.toString() +
                "laenge=" + laenge +
                ", gewicht=" + gewicht +
                '}';
    }
    
    public void clearZuordnung(){
        super.clearZuordnung();
        xPlatzierung = 0;
        yPlatzierung = 0; 
    }
}
