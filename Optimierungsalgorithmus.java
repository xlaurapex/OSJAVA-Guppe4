import java.util.ArrayList;
import java.util.HashMap; 
/**
 * Beschreiben Sie hier die Klasse Optimierungsalgorithmus.
 * 
 * Diese Klasse Optimierungsalgorithmus ist dafür zuständig die Ausstellungen zu planen.
 * Dafür müssen die Kunstgegenständen mit allen vorgegebenen Bedingungen in den Räumen verteilt werden.
 * Dabei müssen die Maße der Räume und der Kunstgegenstände berücksichtigt werden sowie die Themen.
 * 
 * Alle Constraints/Bedindungen:
 * Thema das mindestens in 50% der Räumen vertreten ist
 * Höchstens 3 Themen pro Raum
 * Kostenobergrenze
 * Bild muss auf Wand passen
 * Bilder 1m Abstand voneinander
 * Kunstgegenstände 2m Abstand voneinander
 * Kunstinstallationen stehen alleine in einem Raum
 * @author Marcell Wach
 * @version 1.0
 */
public class Optimierungsalgorithmus
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;
    private ArrayList<Kunstwerk> Kunstwerke;
    private ArrayList<Raum> Raeume;
    private static HashMap<Raum,ArrayList<Kunstwerk>> Ausstellung; 

    /**
     * Konstruktor für Objekte der Klasse Optimierungsalgorithmus
     */
    public Optimierungsalgorithmus()
    {
        // Instanzvariable initialisieren
        x = 0;
    }

    /**
     * Es benötigt die Methode optimiere, um aus den Anforderungen ein Objekt der Klasse Ausstellung zu erzeugen
     * 
     * @param  r    eine Liste der Räume (aus der Raumverwaltung) muss eingegeben werden 
     * @param  k    eine Liste der Kunstwerke (aus der Kunstwerksverwaltung) muss eingegeben werden 
     * @param  thema    das vorgegebene Thema muss eingegeben werden 
     * 
     * @return        ein Objekt der Klasse Ausstellung wird zurückgegeben, welches die optimierte Zuordnung von Raum zu Kunstwerk beinhaltet
     * Liste mit Kunstwerken -> Kunstwerk hat eine RaumID
     */
    public static HashMap<Raum,ArrayList<Kunstwerk>> optimiere(ArrayList<Raum> r, ArrayList<Kunstwerk> k, String thema)
    {
        //Initialisiere die gebrauchten Datenstrukturen
        double ThemaInRaeumen = 0.00;
        Ausstellung = new HashMap<Raum, ArrayList<Kunstwerk>>();
        // Vergebe die ersten Werte
        for(Raum fr : r)
        {
            Ausstellung.put(fr, null);
        }
        // Berechne mögliche Arraygrößen für Räume
        // Prüfe ob die Contraints überhaupt eingehalten werden können
        // Schaue ob Kunst in Raum passt
        return null;
    }

    private double berechneThemaInAllenRaeumen()
    {
        return -1;
    }

    private String berechneThemaImRaum(ArrayList<Kunstwerk> pRaum){
        return null;
    }

    private boolean berechneRaumgroeßeAusreichend()
    {
        return false;
    }
}
