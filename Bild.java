import apple.laf.JRSUIConstants.Widget;

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
       double maxLuftfeuchtigkeit, boolean wirdAusgestellt,Raum inRaum) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema, attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite, wirdAusgestellt, inRaum);
        this.minTemperatur = minTemperatur;
        this.maxTemperatur = maxTemperatur;
        this.minLuftfeuchtigkeit = minLuftfeuchtigkeit;
        this.maxLuftfeuchtigkeit = maxLuftfeuchtigkeit;
        this.wand = "";
        this.xAufhaengung = 0;
        this.yAufhaengung = 0; 
    }

        /**
     * Getters and setters - da wir alle Attributen als private deklariert haben, brauchen wir jetzt getters und setters, um den Zugang zu den Attributen zu gewärhleisten
         */
    public double getMinTemperatur() {
        return minTemperatur;
    }

    public void setMinTemperatur(double minTemperatur) {
        this.minTemperatur = minTemperatur;
    }

    public double getMaxTemperatur() {
        return maxTemperatur;
    }

    public void setMaxTemperatur(double maxTemperatur) {
        this.maxTemperatur = maxTemperatur;
    }

    public double getMinLuftfeuchtigkeit() {
        return minLuftfeuchtigkeit;
    }

    public void setMinLuftfeuchtigkeit(double minLuftfeuchtigkeit) {
        this.minLuftfeuchtigkeit = minLuftfeuchtigkeit;
    }

    public double getMaxLuftfeuchtigkeit() {
        return maxLuftfeuchtigkeit;
    }

    public void setMaxLuftfeuchtigkeit(double maxLuftfeuchtigkeit) {
        this.maxLuftfeuchtigkeit = maxLuftfeuchtigkeit;
    }
    
    public int getXAufhaengung() {
        return xAufhaengung;
    }

    public void setXAufhaengung(int xAufhaengung) {
        this.xAufhaengung = xAufhaengung;
    }
    
    public int getYAufhaengung() {
        return xAufhaengung;
    }

    public void setYAufhaengung(int YAufhaengung) {
        this.yAufhaengung = yAufhaengung;
    }
    
        public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }

    /**
     * Representiert die Klasse als String
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
    
    public void clearZuordnung(){
        super.clearZuordnung();
        this.wand = "";
        xAufhaengung = 0;
        yAufhaengung = 0; 
        
    }

}  
