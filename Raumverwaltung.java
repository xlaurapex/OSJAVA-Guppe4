import java.util.ArrayList;

/**
 * Die Raumverwaltung erzeugt und verwaltet die Objekte der Klasse „Raum“ auf Basis der Planungsdatei der Räume für die jeweiligen Ausstellungszeiträume. 
 * Dadurch ist für jeden einzelnen Ausstellungszeitraum die Erstellung der dann gegebenen Räume und deren Di-mensionen möglich.
 * 
 * @author Johannes Riedmeier 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Raumverwaltung
{
    // es braucht auf jeden Fall eine Variable vom Typ ArrayList<Raum>, um eine Liste der Räume zu erzeugen
    
    private ArrayList<Raum> raeume;
    private Raum r;
    Datei d;
    /**
     * Konstruktor für Objekte der Klasse Raumverwaltung
     */
    public Raumverwaltung()
    {
        // Instanzvariable initialisieren
        raeume = new ArrayList<Raum>();
    }

    /**
     * Es braucht eine Methode, um an die bestehende Liste der Räume einen neuen Raum anzuhängen (z.B. aus der Eingabedatei)
     * 
     * @param  raum    es muss ein Objekt des Typs Raum übergeben werden, welcher an Liste angehangen wird
     * 
     */
    public void addRaum(Raum raum)
    {
        // tragen Sie hier den Code ein
        
    }
    
    /**
     * Es braucht eine Methode, um auf einen bestimmten Raum der Liste zugreifen zu können 
     * 
     * @param  id    die ID (lfd. Nummer) muss eingegeben werden
     * @return es wird ein Objekt Raum zurückgegeben
     */
    public Raum getRaumByID(int id)
    {
        Raum r = null; 
        // tragen Sie hier den Code ein
        return r;
    }
    
    /**
     * Es braucht eine Methode, um die gesamte Liste der Räume zurückzugeben
     * 
     * 
     * @return es wird ein Objekt Raum zurückgegeben
     */
    public ArrayList<Raum> getRaeume()
    {
        return raeume;
    }
}
