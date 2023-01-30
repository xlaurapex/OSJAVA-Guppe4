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
    public static HashMap<Raum,ArrayList<Kunstwerk>> optimiere(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema)
    {
        //Prüfe ob es mehr Kunstinstallationen als Räume gibt
        for(Kunstwerk pk : parameterKunstwerke)
        {
            int AnzahlKunstinstallationen = 0;
            if(pk instanceof Kunstinstallation)
            {
                AnzahlKunstinstallationen++;
                if(AnzahlKunstinstallationen > parameterRaeume.size())
                {
                    return null;
                }
            }
        }
        //Initialisiere die gebrauchten Datenstrukturen
        double ThemaInRaeumen = 0.00;
        boolean RaumOptimiert = false;
        Ausstellung = new HashMap<Raum, ArrayList<Kunstwerk>>();
        // Speichere alle Räume und ordne den ersten Räumen alle Kunstinstallationen zu
        while(true != RaumOptimiert)
        {
            for(Raum fr : parameterRaeume)
            {
                Ausstellung.put(fr, null);
                for(Kunstwerk pk : parameterKunstwerke)
                {        
                    // fr get anzahl themen
                    // get freie flächen
                    // thema in allen räumchen berechnen
                    if(pk instanceof Kunstinstallation)
                    {
                        // nur in leere räume
                        ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(fr);
                        temporaereKunstwerke.add(pk);
                        parameterKunstwerke.remove(pk);
                        break;
                    }
                    if(pk instanceof Kunstgegenstand)
                    {
                        //nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(fr);
                        temporaereKunstwerke.add(pk);
                        parameterKunstwerke.remove(pk);

                    }
                    if(pk instanceof Bild)
                    {
                        //nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(fr);
                        temporaereKunstwerke.add(pk);
                        parameterKunstwerke.remove(pk);
                        break;
                    }
                }            
            }
        }
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
