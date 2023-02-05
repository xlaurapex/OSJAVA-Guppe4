
/**
 * Die Klasse Raum dient der Datenhaltung einzelner Räume und definiert deren 
 * Attribute, wie z.B. Ausmaße. Die Klasse Raum ist somit eine Datenträgerklasse.
 * Auf die Klasse „Raumverwaltung“ wird durch die Klasse „Ausstellungsverwaltung“
 * zugegriffen, um auf Basis der Räume eine Ausstellung erstellen zu können. 
 * Zudem wird die Klasse „Datei“ verwendet, um die Raumdatei einlesen und 
 * verarbeiten zu können.
 * 
 * @author Johannes Riedmeier
 * @version (1.1 22.12.2022)
 */
public class Raum
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int lfdNr;
    private String bezeichnung;
    private int laenge;
    private int breite;
    private int hoehe; 
    private int tuerNord;
    private int tuerOst;
    private int tuerSued;
    private int tuerWest;
    private String schwerpunktThema;
    private int temperatur;
    private int luftfeuchtigkeit;
    //neue Attribute
    private int freieFlaecheSued;
    private int freieFlaecheWest;
    private int freieFlaecheNord;
    private int freieFlaecheOst;
    private boolean IstRaumVoll;

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
        this.tuerNord = tuerNord;
        this.tuerOst = tuerOst;
        this.tuerSued = tuerSued;
        this.tuerWest = tuerWest;
        this.schwerpunktThema = schwerpunktThema;
        this.temperatur = temperatur;
        this.luftfeuchtigkeit = luftfeuchtigkeit;

    }

        /** 
     * Diese Methode ermöglicht die Ausgabe der laufenden Nummer eines Objekts der Klasse
     * Raum.
     * 
     * @return        beichnung eines Raums
     */
    public int getLfdNr()
    {
        return this.lfdNr;
        
    }
    
    /**
     * Diese Methode ermöglicht das Setzen einer Bezeichnung in einem Raum.
     * 
     * @param     bezeichung für einen Raum
     */

    public void setBezeichnung(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;

    }

    /** 
     * Diese Methode ermöglicht die Ausgabe einer Bezeichnung eines Objekts der Kalsse
     * Raum.
     * 
     * @return        beichnung eines Raums
     */
    public String getBezeichnung()
    {
        return this.bezeichnung;
    }

    /**
     * Diese Methode ermöglicht es einem Objekt Raum ein Thema (Schwerpunkthema)
     * zuzuweisen.
     * 
     * @param  schwerpunktThema    Thema, welches den Schwerpunkt in einem 
     * Raum bildet
     */
    public void setSchwerpunktThema(String schwerpunktThema)
    {
        this.schwerpunktThema = schwerpunktThema;
    }

    /**
     * Diese Methode ermöglicht die Ausgabe eines Themas eines Objekts der Kalsse
     * Raum.
     * 
     * @return     schwerpunktThema eines Raums
     */
    public String getSchwerpunktThema()
    {
        return this.schwerpunktThema;
    }

    /**
     * Diese Methode ermöglicht das Setzen einer Temperatur in einem Raum.
     * 
     * @param  temperatur    Temeperatur in einem Raum
     */
    public void setTemperatur (int temperatur)
    {
        this.temperatur = temperatur;
    }

    /**
     * Diese Methode ermöglicht es die Temeeperatur in einem Raum auszugeben.
     * 
     * @return     temperatur eines Raums
     */
    public int getTemperatur ()
    {
        return 
        this.temperatur;
    }

    /**
     * Diese Methode ermöglicht das Setzen einer Luftfeuchtigkeit in einem Raum.
     * 
     * @param  luftfeuchtigkeit    Luftfeuchtigkeit in einem Raum
     */
    public void setLuftfeuchtigkeit(int luftfeuchtigkeit)
    { 
        this.luftfeuchtigkeit = luftfeuchtigkeit;
    }

    /**
     * Diese Methode ermöglicht es die Luftfeuchtigkeit in einem Raum auszugeben.
     * 
     *  @return     luftfeuchtigkeit eines Raums
     */
    public int getLuftfeuchtigkeit()
    {
        return this.luftfeuchtigkeit;
    }

    /**
     * diese Methode aktualisiert die freie Fläche einer Wand, wenn ein Bild hinzugefügt wird
     */
    // SWITCH BENUTZEN, NUR BILD BERÜCKSICHTIGT?
    public void updateFreieFlaeche(String wand, int breiteBild)
    {
        if (wand == "sued")
        {
            if (freieFlaecheSued == laenge) {
                //Abzug der Bildbreite, Türbreite und 1m Puffer auf beiden Seiten
                freieFlaecheSued = freieFlaecheSued - breiteBild - tuerSued - 200;
            }
            else 
            {
                //Abzug der Bildbreite und 1m Puffer
                freieFlaecheSued = freieFlaecheSued - breiteBild - 100;
            }
        }
        if (wand == "west")
        {
            if (freieFlaecheWest == breite) {
                //Abzug der Bildbreite, Türbreite und 1m Puffer auf beiden Seiten
                freieFlaecheWest = freieFlaecheWest - breiteBild - tuerWest - 200;
            }
            else 
            {
                //Abzug der Bildbreite und 1m Puffer
                freieFlaecheWest = freieFlaecheWest - breiteBild - 100;
            }
        }
        if (wand == "nord")
        {
            if (freieFlaecheNord == laenge) {
                //Abzug der Bildbreite, Türbreite und 1m Puffer auf beiden Seiten
                freieFlaecheNord = freieFlaecheNord - breiteBild - tuerNord - 200;
            }
            else 
            {
                //Abzug der Bildbreite und 1m Puffer
                freieFlaecheNord = freieFlaecheNord - breiteBild - 100;
            }
        }
        if (wand == "ost")
        {
            if (freieFlaecheOst == breite) {
                //Abzug der Bildbreite, Türbreite und 1m Puffer auf beiden Seiten
                freieFlaecheOst = freieFlaecheOst - breiteBild - tuerOst - 200;
            }
            else 
            {
                //Abzug der Bildbreite und 1m Puffer
                freieFlaecheOst = freieFlaecheOst - breiteBild - 100;
            }
        }
    }

}

