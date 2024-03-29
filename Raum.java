
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
    public Raum(int lfdNr, String bezeichnung, int laenge, int breite, int hoehe, int tNord, int tOst, int tSued, int tWest)
    {
        this.lfdNr = lfdNr;
        this.bezeichnung = bezeichnung;
        this.freieFlaecheNord = laenge - tNord;
        this.freieFlaecheSued = laenge - tSued;
        this.freieFlaecheWest = breite - tWest;
        this.freieFlaecheOst = breite - tOst;
        this.hoehe = hoehe;
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
     * Diese Methode ermöglicht das Setzen einer Bezeichnung in einem Raum.
     * 
     * @param     bezeichung für einen Raum
     */

    public void setHoehe(int pHoehe)
    {
        this.hoehe = pHoehe;

    }

    /** 
     * Diese Methode ermöglicht die Ausgabe einer Bezeichnung eines Objekts der Kalsse
     * Raum.
     * 
     * @return        beichnung eines Raums
     */
    public int getHoehe()
    {
        return this.hoehe;
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
     * Diese Methode ermöglicht das Setzen einer Luftfeuchtigkeit in einem Raum.
     * 
     * @param  luftfeuchtigkeit    Luftfeuchtigkeit in einem Raum
     */
    public void setFreieFlaecheNord(int pFlaeche)
    { 
        this.freieFlaecheNord = pFlaeche;
    }

    /**
     * Diese Methode ermöglicht es die Luftfeuchtigkeit in einem Raum auszugeben.
     * 
     *  @return     luftfeuchtigkeit eines Raums
     */
    public int getFreieFlaecheNord()
    {
        return this.freieFlaecheNord;
    }

    /**
     * Diese Methode ermöglicht das Setzen einer Luftfeuchtigkeit in einem Raum.
     * 
     * @param  luftfeuchtigkeit    Luftfeuchtigkeit in einem Raum
     */
    public void setFreieFlaecheSued(int pFlaeche)
    { 
        this.freieFlaecheSued = pFlaeche;
    }

    /**
     * Diese Methode ermöglicht es die Luftfeuchtigkeit in einem Raum auszugeben.
     * 
     *  @return     luftfeuchtigkeit eines Raums
     */
    public int getFreieFlaecheSued()
    {
        return this.freieFlaecheSued;
    }

    /**
     * Diese Methode ermöglicht das Setzen einer Luftfeuchtigkeit in einem Raum.
     * 
     * @param  luftfeuchtigkeit    Luftfeuchtigkeit in einem Raum
     */
    public void setFreieFlaecheWest(int pFlaeche)
    { 
        this.freieFlaecheWest = pFlaeche;
    }

    /**
     * Diese Methode ermöglicht es die Luftfeuchtigkeit in einem Raum auszugeben.
     * 
     *  @return     luftfeuchtigkeit eines Raums
     */
    public int getFreieFlaecheWest()
    {
        return this.freieFlaecheWest;
    }

    /**
     * Diese Methode ermöglicht das Setzen einer Luftfeuchtigkeit in einem Raum.
     * 
     * @param  luftfeuchtigkeit    Luftfeuchtigkeit in einem Raum
     */
    public void setFreieFlaecheOst(int pFlaeche)
    { 
        this.freieFlaecheOst = pFlaeche;
    }

    /**
     * Diese Methode ermöglicht es die Luftfeuchtigkeit in einem Raum auszugeben.
     * 
     *  @return     luftfeuchtigkeit eines Raums
     */
    public int getFreieFlaecheOst()
    {
        return this.freieFlaecheOst;
    }

    /**
     * diese Methode aktualisiert die freie Fläche einer Wand, wenn ein Bild hinzugefügt wird
     */
    // SWITCH BENUTZEN, NUR BILD BERÜCKSICHTIGT?
    public void updateFreieFlaeche(String wand, int breiteBild, int Puffer)
    {
        if (wand == "sued")
        {
            //Abzug der Bildbreite und Puffer
            this.setFreieFlaecheSued(getFreieFlaecheSued() - breiteBild - Puffer);
        }
        if (wand == "west")
        {
            //Abzug der Bildbreite und Puffer
            this.setFreieFlaecheWest(getFreieFlaecheWest() - breiteBild - Puffer);

        }
        if (wand == "nord")
        {
            //Abzug der Bildbreite und Puffer
            this.setFreieFlaecheNord(getFreieFlaecheNord() - breiteBild - Puffer);

        }
        if (wand == "ost")
        {
            //Abzug der Bildbreite und Puffer
            this.setFreieFlaecheOst(getFreieFlaecheOst() - breiteBild - Puffer);
        }
    }

}

