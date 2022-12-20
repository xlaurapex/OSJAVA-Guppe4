import java.util.ArrayList;

/**
 * Die Klasse Datei dient dem Einlesen und Ausgeben von Dateien und bietet Standardfunk-tionen zur Dateiverarbeitung. 
 * Diese wird durch die Klassen „Ausstellungsverwaltung“ (z.B. Erstellen des Ausstellungsführers), 
 * Raumverwaltung (z.B. Einlesen der Raumdatei) und Kunstwerksverwaltung (z.B. Einlesen der verfügbaren Kunstwerke) verwendet.
 * 
 * @author Laura Perlbach
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Datei
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String dateipfad;

    /**
     * Konstruktor für Objekte der Klasse Datei
     * test
     */
    public Datei()
    {
        //nichts zu tun
        
    }
    

    /**
     * mit der Methode verarbeiteKunstwerkeDatei() werden die Eingabedateien für Kunstwerke eingelesen, 
     * verarbeitet und entsprechende Objekte der Klassen "Bild","Kunstgegenstand" und "Kunstinstallation" erzeugt 
     * 
     * @param  dateipfad    als Eingabeparameter für die Methode ist der Dateipfad erforderlich, wo die einzulesende Datei zu finden ist
     * @return        die Methode besitzt keinen Rückgabewert, da lediglich Objekte der Klassen "Bild","Kunstgegenstand" und 
     * "Kunstinstallation" erzeugt und in der Museumsverwaltung gespeichert werden
     * @author  Laura Perlbach
     */
    public void verarbeiteKunstwerkeDatei(String dateipfad)
    {
        //möglicherweise auch direkt ArrayList als Rückgabe sinnvoll
        
        //Einlesen der Datei für die Raumdatei
        //Trennen der einzelnen Datensätze
        //Für jeden Datensatz prüfen, ob Art des Kunstwerks "B", "I" oder "G". 
        //Entsprechende Anlage von Bildern, Kunstgegenständen und Kunstinstallationen in der Kunstwerksverwaltung und Anhängen in der ?Liste?
    }
    
    /**
     * mit der Methode verarbeiteRaumDatei() werden die Eingabedateien für Räume eingelesen, 
     * verarbeitet und entsprechende Objekte der Klasse "Raum" 
     * 
     * @param  dateipfad    als Eingabeparameter für die Methode ist der Dateipfad erforderlich, wo die einzulesende Datei zu finden ist
     * @return        die Methode besitzt keinen Rückgabewert, da lediglich Objekte der Klassen "Bild","Kunstgegenstand" und 
     * "Kunstinstallation" erzeugt und in der Museumsverwaltung gespeichert werden
     * @author  Laura Perlbach
     */
    public void verarbeiteRaumDatei(String dateipfad)
    {
        //möglicherweise auch direkt ArrayList als Rückgabe sinnvoll
        
        //Einlesen der Datei für die Raumdatei
        //Trennen der einzelnen Datensätze
        //Für jeden Datensatz Anlage eines Objekts der Klasse Raum (+zugehörige Objekte der Klasse Wand) 
        //Anhängen der Objekte in der ?Liste? zur Raumverwaltung
    }
    
    /**
     * mit der Methode erzeugeLeihDatei() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen zum Partner-
     * museum, Kosten und der Kunstwerke gespeichert
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @return        die Methode gibt einen Integer wieder, welcher den Fehlercode der Verarbeitung beschreibt
     * @author  Laura Perlbach
     */
    public int erzeugeLeihDatei(ArrayList ausstellung)
    {
        int error = 0;
        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Leih-Quelle
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return error;
    }
    
    /**
     * mit der Methode erzeugeZuordnungsdatei() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen
     * der einzelnen Kunstwerke und der Räume, in denen diese ausgestellt werden, sowie die notwendigen Informationen zur Platzierung und 
     * Klimatisierung der Räume
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @return        die Methode gibt einen Integer wieder, welcher den Fehlercode der Verarbeitung beschreibt
     * @author  Laura Perlbach
     */
    public int erzeugeZuordnungsDatei(ArrayList ausstellung)
    {
        int error = 0;
        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Ausstellungsraum
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return error;
    }
    
    /**
     * mit der Methode erzeugeMuseumsführer() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen
     * der einzelnen Kunstwerke und der Räume in einer Aufbereitungsform eines Museumsführers mit den wichtigsten Kunstwerken je Raum
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @return        die Methode gibt einen Integer wieder, welcher den Fehlercode der Verarbeitung beschreibt
     * @author  Laura Perlbach
     */
    public int erzeugeMuseumsführer(ArrayList ausstellung)
    {
        int error = 0;
        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Leih-Quelle
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return error;
    }
}
