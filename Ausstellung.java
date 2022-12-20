import java.util.ArrayList;

/**
 * Eine Ausstellung enthält jeweils die in dieser Ausstellung präsentierten Kunstwerke und die Aufteilung der Kunstwerke in die einzelnen Räume. Eine 
 * Ausstellung nutzt daher die Ge-gebenheiten der Räume und beinhaltet Objekte der Klassen „Bild“, 
 * „Kunstgegenstand“ und „Kunstinstallation“. Zudem erzeugt die Klasse „Ausstellung“ anschließend die Dateien Mu-seumsführer, Leihübersicht und Raumplan.
 * 
 * @author Laura Perlbach
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ausstellung
{
    // Instanzvariablen 
    // noch unsicher in welcher Form die Zuordnung gespeichert werden soll
    // a) zusätzliche Attribute der Klasse Kunstwerk (wirdAusgestellt + ausstellungsraum)
    // b) mehrdimensionales Array mit Kunstwerk + Raumzuordnung
    
    private ArrayList<Kunstwerk> ausstellung;    
    Datei d;
    /**
     * Konstruktor für Objekte der Klasse Ausstellung
     */
    public Ausstellung(ArrayList<Kunstwerk> kunstwerke)
    {
        // Instanzvariable initialisieren
        ausstellung = new ArrayList<Kunstwerk>();
        
        /*for()
        {
            //jedes Objekt aus kunstwerke
            //prüfen, ob wirdAusgestellt
            //append an ausstellung
        }*/
    }

    /**
     * Um die Ausstellung aus anderen Klassen aufrufen zu können, wird eine get-Methode definiert
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return       die Ausstellung
     */
    public ArrayList<Kunstwerk> getAustellung()
    {
        // tragen Sie hier den Code ein
        return ausstellung;
    }
}
