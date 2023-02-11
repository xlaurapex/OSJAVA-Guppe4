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
    private ArrayList<Raum> BesteRaeume;

    /**
     * Konstruktor für Objekte der Klasse Optimierungsalgorithmus
     */
    public Optimierungsalgorithmus()
    {
        // Instanzvariable initialisieren

    }

    public static ArrayList<Kunstwerk> optimiere2(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema)
    {
        ArrayList<Kunstwerk> ReturnList = new ArrayList<Kunstwerk>();
        for(Raum pRaum : parameterRaeume)
        {
            pRaum.setSchwerpunktThema(parameterThema);
        }

        return StarteOptimierung(parameterRaeume,parameterKunstwerke,parameterThema,ReturnList,0);
    }

    public static ArrayList<Kunstwerk> StarteOptimierung(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema,ArrayList<Kunstwerk> pReturnList, int pBesteLaenge)
    {
        //reject if 3 themen pro raum oder 50% der hauptthemen pro raum
        if(BacktrackingReject())
        {
            return null;
        }
        //merke die anzahl der verwendeten Kunstwerke, je mehr desto besser
        if(pReturnList.size() > pBesteLaenge)
        {
            //neue beste Lösung zwischenspeichern
            pBesteLaenge = pReturnList.size();
        }

        for(var a : parameterKunstwerke)
        {
            //Ein Kunstwerk mehr einfügen
            StarteOptimierung(parameterRaeume,parameterKunstwerke,parameterThema,pReturnList,pBesteLaenge);
        }
        return pReturnList;
    }

    public static boolean BacktrackingReject()
    {
        return false;
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
    public static ArrayList<Kunstwerk> optimiere(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema)
    {
        //Prüfe ob es mehr Kunstinstallationen als Räume gibt
        //int AnzahlKunstwerke = parameterKunstwerke.size();
        int AnzahlKunstwerke = berechneInstaUndGegen(parameterKunstwerke);
        ArrayList<Kunstwerk> ReturnList = new ArrayList<Kunstwerk>();
        int AnzahlKunstinstallationen = 0;
        for(Kunstwerk pKunstwerk : parameterKunstwerke)
        {            
            if(pKunstwerk instanceof Kunstinstallation)
            {
                AnzahlKunstinstallationen++;
                if(AnzahlKunstinstallationen > parameterRaeume.size())
                {
                    return null;
                }
            }
        }
        //Initialisiere die gebrauchten Datenstrukturen
        double ThemaInRaeumen = 0.00; // Noch nicht umgesetzt
        boolean RaumOptimiert = false;
        var Ausstellung = new HashMap<Raum, ArrayList<Kunstwerk>>();
        // Speichere alle Räume und ordne den ersten Räumen alle Kunstinstallationen zu
        var tempRaeume = (ArrayList<Raum>)parameterRaeume.clone();
        var tempKunstwerke = (ArrayList<Kunstwerk>)parameterKunstwerke.clone();

        for(Raum pRaum : parameterRaeume)
        {
            Ausstellung.put(pRaum, new ArrayList<Kunstwerk>());
            tempRaeume.remove(pRaum);
            for(Kunstwerk pKunstwerk : parameterKunstwerke)
            {        
                //hoehe vergleichen? pKunstwerkunstwerkunstwerkunstwerk.getHoehe >= pRaum.getHoehe
                // thema in allen räumchen berechnen
                if(pKunstwerk.getHoehe() <= pRaum.getHoehe())
                {
                    if(pKunstwerk instanceof Kunstinstallation)
                    {
                        // nur in leere räume
                        ArrayList<Kunstwerk> AndereKunstwerkeImRaum = Ausstellung.get(pRaum);
                        //Raum leer?
                        if(AndereKunstwerkeImRaum.size() == 0)
                        {
                            AndereKunstwerkeImRaum.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(pRaum);
                            ReturnList.add(pKunstwerk);
                            break;
                        }                        
                    }
                }
                parameterKunstwerke = tempKunstwerke;
            }
            parameterRaeume = tempRaeume;
        }

        // while(true != RaumOptimiert)
        // {
        // for(HashMap.Entry<Raum, ArrayList<Kunstwerk>> pRaumMitKunstwerk : Ausstellung.entrySet()) {
        // Raum zRaum = pRaumMitKunstwerk.getKey();
        // ArrayList<Kunstwerk> value = pRaumMitKunstwerk.getValue();
        // for(Kunstwerk pKunstwerk: parameterKunstwerke)
        // {
        // if(pKunstwerk instanceof Kunstgegenstand)
        // {
        // // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
        // // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
        // // Passt das Thema zu den anderen Themen?
        // if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
        // {
        // // Nord,West, Süd, ost
        // if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200) >= 0)
        // {
        // value.add(pKunstwerk);
        // tempKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200);
        // parameterKunstwerke = tempKunstwerke;
        // break;
        // }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200) >= 0)
        // {
        // value.add(pKunstwerk);
        // tempKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200);
        // parameterKunstwerke = tempKunstwerke;
        // break;
        // }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200) >= 0)
        // {
        // value.add(pKunstwerk);
        // tempKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200);
        // parameterKunstwerke = tempKunstwerke;
        // break;
        // }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200) >= 0)
        // {
        // value.add(pKunstwerk);
        // tempKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200);
        // parameterKunstwerke = tempKunstwerke;
        // break;
        // }
        // }                                                    
        // }
        // if(pKunstwerk instanceof Bild)
        // {
        // // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
        // // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
        // // Passt das Thema zu den anderen Themen?
        // if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
        // {
        // // Nord,West, Süd, ost
        // if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100) >= 0)
        // {
        // value.add(pKunstwerk);
        // parameterKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100);
        // break;
        // }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100) >= 0)
        // {
        // value.add(pKunstwerk);
        // parameterKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100);
        // break;
        // }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100) >= 0)
        // {
        // value.add(pKunstwerk);
        // parameterKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100);
        // break;
        // }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100) >= 0)
        // {
        // value.add(pKunstwerk);
        // parameterKunstwerke.remove(pKunstwerk);
        // pKunstwerk.setinRaum(zRaum);
        // ReturnList.add(pKunstwerk);
        // zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100);
        // break;
        // }
        // }
        // }

        // }
        // }
        // if(ReturnList.size() == AnzahlKunstwerke)
        // {
        // RaumOptimiert = true;
        // }

        return ReturnList;
    }

    private double berechneThemaInAllenRaeumen()
    {
        return -1;
    }

    private static int berechneInstaUndGegen(ArrayList<Kunstwerk> pKunstwerke)
    {
        int Return = 0;
        for( var zKunstwerk : pKunstwerke )
        {
            if((zKunstwerk instanceof Kunstinstallation) || (zKunstwerk instanceof Kunstgegenstand))
            {
                Return++;
            }
        }
        return Return;
    }

    private static ArrayList<String> getThemenImRaum(ArrayList<Kunstwerk> pKunstwerk)
    {
        ArrayList<String> ReturnList = new ArrayList<String>();
        for(Kunstwerk kw : pKunstwerk)
        {
            if(!ReturnList.contains(kw.getThema()))
            {
                ReturnList.add(kw.getThema());
            }
        }
        return ReturnList;
    }

    private String berechneThemaImRaum(ArrayList<Kunstwerk> pRaum){
        return null;
    }

    private boolean berechneRaumgroeßeAusreichend()
    {
        return false;
    }
}
