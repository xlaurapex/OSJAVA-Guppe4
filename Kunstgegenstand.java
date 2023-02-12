
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
     * Da das Attribut XPlatzierung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getXPlatzierung() {
        return xPlatzierung;
    }

    /**
     * Da das Attribut XPlatzierung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setXPlatzierung(int xPlatzierung) {
        this.xPlatzierung = xPlatzierung;
    }
    
    /**
     * Da das Attribut YPlatzierung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getYPlatzierung() {
        return yPlatzierung;
    }

    /**
     * Da das Attribut YPlatzierung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
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
