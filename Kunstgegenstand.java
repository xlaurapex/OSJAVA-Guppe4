
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
     * @param laufendeNummer
     * @param bezeichnung
     * @param kuenstlername
     * @param jahresangabe
     * @param thema
     * @param attraktivitaet
     * @param kosten
     * @param nameMuseums
     * @param anschriftMuseums
     * @param hoehe
     * @param breite
     * @param laenge
     * @param gewicht
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
     * Da das Attribut Laenge als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return laenge
     */
    
    public int getLaenge() {
        return laenge;
    }

    /**
     * Da das Attribut Laenge als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param laenge
     */
    
    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    /**
     * Da das Attribut Gewicht als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return gewicht
     */
    
    public double getGewicht() {
        return gewicht;
    }

    /**
     * Da das Attribut Gewicht als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param gewicht
     */
    
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    
    /**
     * Da das Attribut XPlatzierung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return xPlatzierung
     */
    
    public int getXPlatzierung() {
        return xPlatzierung;
    }

    /**
     * Da das Attribut XPlatzierung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param xPlatzierung
     */
    
    public void setXPlatzierung(int xPlatzierung) {
        this.xPlatzierung = xPlatzierung;
    }
    
    /**
     * Da das Attribut YPlatzierung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return yPlatzierung
     */
    
    public int getYPlatzierung() {
        return yPlatzierung;
    }

    /**
     * Da das Attribut YPlatzierung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param yPlatzierung
     */
    
    public void setYPlatzierung(int yPlatzierung) {
        this.yPlatzierung = yPlatzierung;
    }

    /**
     * Representiert die Klasse als String
     * @return String mit allen Parametern
     */
    public String toString() {
        return "Kunstgegenstand{" +
                super.toString() +
                "laenge=" + laenge +
                ", gewicht=" + gewicht +
                '}';
    }
    
    /**
     * Raeumt die xy Koordinaten des Bildes auf
     */
    public void clearZuordnung(){
        super.clearZuordnung();
        xPlatzierung = 0;
        yPlatzierung = 0; 
    }
}
