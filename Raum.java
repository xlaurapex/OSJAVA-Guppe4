
/**
 * Die Klasse Raum dient der Datenhaltung einzelner Räume und definiert deren Attribute, wie z.B. Ausmaße. Die Klasse Raum ist somit eine 
 * Datenträgerklasse. Auf die Klasse „Raumverwaltung“ wird durch die Klasse „Ausstellungsverwaltung“ zugegriffen, um auf Ba-sis der 
 * Räume eine Ausstellung erstellen zu können. Zudem wird die Klasse „Datei“ ver-wendet, um die Raumdatei einlesen und verarbeiten zu können.
 * 
 * @author Johannes Riedmeier
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Raum
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int lfdNr;
    private String bezeichnung;
    private int laenge;
    private int breite;
    private int hoehe; 
    private int tNord;
    private int tOst;
    private int tSued;
    private int tWest;
    private Wand w;
    /**
     * Konstruktor für Objekte der Klasse Raum
     */
    public Raum()
    {
        // Instanzvariable initialisieren
        
    }
    
    /**
     * Konstruktor für Objekte der Klasse Raum
     */
    public Raum(int lfdNr, String bezeichnung, int laenge, int breite, int hoehe, int tNord, int tOst, int tSued, int tWest)
    {
        this.lfdNr = lfdNr;
        this.bezeichnung = bezeichnung;
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
        this.tNord = tNord;
        this.tOst = tOst;
        this.tSued = tSued;
        this.tWest = tWest;
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    // public int beispielMethode(int y)
    // {
        // // tragen Sie hier den Code ein
        
    // }
}
