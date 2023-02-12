/**
 * Die Klasse „Bild“ ist eine Child-Klasse der abstrakten Klasse „Kunstwerk“, welche durch die besonderen Attribute eines Bildes 
 * (z.B. Luftfeuchtigkeit) ergänzt wird. Die Klasse „Bild“ ist somit eine Datenträgerklasse.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bild extends Kunstwerk
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private double minTemperatur;
    private double maxTemperatur;
    private double minLuftfeuchtigkeit;
    private double maxLuftfeuchtigkeit;
    //neue Attribute
    private String wand;
    //Platzierung an der Wand in cm ausgehend von der oberen linken Ecke
    private int xAufhaengung;
    private int yAufhaengung;

    /**
     * Konstruktor der Klasse Bild
     *
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
     * @param minTemperatur
     * @param maxTemperatur
     * @param minLuftfeuchtigkeit
     * @param maxLuftfeuchtigkeit
     * @param wirdAusgestellt
     * @param inRaum
     */
    public Bild(int laufendeNummer, String bezeichnung, String kuenstlername, String jahresangabe, String thema,
     double attraktivitaet, int kosten, String nameMuseums, String anschriftMuseums,
      int hoehe, int breite, double minTemperatur, double maxTemperatur, double minLuftfeuchtigkeit,
       double maxLuftfeuchtigkeit) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema, attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.minTemperatur = minTemperatur;
        this.maxTemperatur = maxTemperatur;
        this.minLuftfeuchtigkeit = minLuftfeuchtigkeit;
        this.maxLuftfeuchtigkeit = maxLuftfeuchtigkeit;
        this.wand = "";
        this.xAufhaengung = 0;
        this.yAufhaengung = 0; 
    }

    /**
     * Da das Attribut MinTemperatur als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return minTemperatur
     */
    
    public double getMinTemperatur() {
        return minTemperatur;
    }

    /**
     * Da das Attribut MinTemperatur als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param minTemperatur
     */
    
    public void setMinTemperatur(double minTemperatur) {
        this.minTemperatur = minTemperatur;
    }

    /**
     * Da das Attribut MaxTemperatur als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return maxTemperatur
     */
    
    public double getMaxTemperatur() {
        return maxTemperatur;
    }

    /**
     * Da das Attribut MaxTemperatur als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param maxTemperatur
     */
    
    public void setMaxTemperatur(double maxTemperatur) {
        this.maxTemperatur = maxTemperatur;
    }

    /**
     * Da das Attribut MinLuftfeuchtigkeit als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return minLuftfeuchtigkeit
     */
    
    public double getMinLuftfeuchtigkeit() {
        return minLuftfeuchtigkeit;
    }

    /**
     * Da das Attribut MinLuftfeuchtigkeit als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param minLuftfeuchtigkeit
     */
    
    public void setMinLuftfeuchtigkeit(double minLuftfeuchtigkeit) {
        this.minLuftfeuchtigkeit = minLuftfeuchtigkeit;
    }

    /**
     * Da das Attribut MaxLuftfeuchtigkeit als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return maxLuftfeuchtigkeit
     */
    
    public double getMaxLuftfeuchtigkeit() {
        return maxLuftfeuchtigkeit;
    }

    /**
     * Da das Attribut MaxLuftfeuchtigkeit als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param maxLuftFeuchtigkeit
     */
    
    public void setMaxLuftfeuchtigkeit(double maxLuftfeuchtigkeit) {
        this.maxLuftfeuchtigkeit = maxLuftfeuchtigkeit;
    }
    
    /**
     * Da das Attribut XAufhaengung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return xAufhaengung
     */
    
    public int getXAufhaengung() {
        return xAufhaengung;
    }

    /**
     * Da das Attribut XAufhaengung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param xAufhaengung
     */
    
    public void setXAufhaengung(int xAufhaengung) {
        this.xAufhaengung = xAufhaengung;
    }
    
    /**
     * Da das Attribut YAufhaengung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return yAufhaengung
     */
    
    public int getYAufhaengung() {
        return yAufhaengung;
    }

    /**
     * Da das Attribut YAufhaengung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param yAufhaengung
     */
    
    public void setYAufhaengung(int YAufhaengung) {
        this.yAufhaengung = yAufhaengung;
    }
    
    /**
     * Da das Attribut Wand als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     * @return Wand
     */
    
    public String getWand() {
        return wand;
    }

    /**
     * Da das Attribut Wand als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     * @param Wand
     */
    
    public void setWand(String wand) {
        this.wand = wand;
    }

    /**
     * Representiert die Klasse als String
     * @return String mit allen Parametern
     */
    public String toString() {
        return "Bild{" +
                super.toString() +
                "minTemperatur=" + minTemperatur +
                ", maxTemperatur=" + maxTemperatur +
                ", minLuftfeuchtigkeit=" + minLuftfeuchtigkeit +
                ", maxLuftfeuchtigkeit=" + maxLuftfeuchtigkeit +
                '}';
    }
    
    /**
     * Raeumt die xy Koordinaten des Bildes auf
     */
    public void clearZuordnung(){
        super.clearZuordnung();
        this.wand = "";
        xAufhaengung = 0;
        yAufhaengung = 0; 
        
    }

}  
