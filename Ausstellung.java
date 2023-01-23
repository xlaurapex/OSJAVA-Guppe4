import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

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
    private int gesamtKosten;
    
    /**
     * Konstruktor für Objekte der Klasse Ausstellung
     * @param Übergeben wird die Zuordnung von Kunstwerk zu Raum, 
     * welche im Optimierungsalgorithmus erstellt wird
     */
    public Ausstellung(ArrayList<Kunstwerk> ausstellung)
    {

        this.ausstellung = ausstellung;
        for(Kunstwerk kw: ausstellung)
        {
            this.gesamtKosten = this.gesamtKosten + kw.getKosten();
        }

    }

    /**
     * Um die Ausstellung aus anderen Klassen aufrufen zu können, wird eine get-Methode definiert
     * 
     * @return       die Ausstellung
     */
    public ArrayList<Kunstwerk> getAusstellung()
    {
        // tragen Sie hier den Code ein
        return ausstellung;
    }
    
        public void addKunstwerk()
    {
        //ein Kunstwerk mit Zuordnung der Ausstellung hinzufügen
        //Attribute bei Kunstwerk setzen
        //freiFläche Räume anpassen
        
    }
    
        public void removeKunstwerk()
    {
        //ein Kunstwerk mit Zuordnung aus der Ausstellung entfernen
        //Kunstwerk clearen
        //freieFläche Räume anpassen
    }
    
    /**
     * Um die Gesamtkosten de rAusstellung aus anderen Klassen aufrufen zu können, wird eine get-Methode definiert
     * 
     * @return       Summe der Kosten der Ausstellung
     */
    public int getGesamtKosten()
    {
        return gesamtKosten;
    }
    
    /**
     * Sortieren der Ausstellungsliste nach Museum
     * 
     * @return       Summe der Kosten der Ausstellung
     */
    public void sortNachMuseum()
    {
        Collections.sort(ausstellung, Comparator.comparing(Kunstwerk::getNameMuseums));
    }
    
        /**
     * Sortieren der Ausstellungsliste nach Museum
     * 
     * @return       Summe der Kosten der Ausstellung
     */
    public void sortNachRaum()
    {
        //Collections.sort(ausstellung, Comparator.comparing(Kunstwerk::getInRaum));
    }
}
