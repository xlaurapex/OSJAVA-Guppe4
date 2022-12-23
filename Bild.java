
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
     */
    public Bild(int laufendeNummer, String bezeichnung, String kuenstlername, String jahresangabe, String thema, double attraktivitaet, int kosten, String nameMuseums, String anschriftMuseums, int hoehe, int breite, double minTemperatur, double maxTemperatur, double minLuftfeuchtigkeit, double maxLuftfeuchtigkeit) {
        super(laufendeNummer, bezeichnung, kuenstlername, jahresangabe, thema, attraktivitaet, kosten, nameMuseums, anschriftMuseums, hoehe, breite);
        this.minTemperatur = minTemperatur;
        this.maxTemperatur = maxTemperatur;
        this.minLuftfeuchtigkeit = minLuftfeuchtigkeit;
        this.maxLuftfeuchtigkeit = maxLuftfeuchtigkeit;
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

}  
