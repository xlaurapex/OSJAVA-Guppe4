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
    private static ArrayList<Kunstwerk> BesteKunstwerk = new ArrayList<Kunstwerk>();

    /**
     * Konstruktor für Objekte der Klasse Optimierungsalgorithmus
     */
    public Optimierungsalgorithmus()
    {
        // Instanzvariable initialisieren

    }

    /**
     * Statische Methode die aus der Main aufgerufen wird.
     * Die Methode deklariert und initialisiert wichtige Hilfsdatenstrukturen und starten anschließend den rekursiven Backtracking Algorithmus.
     * 
     * @param   parameterRaeume         Eine Liste aller zur Verfügung stehenden Räume
     * @param   parameterKunstwerke     Eine Liste aller Kunstwerke die für die nächste Ausstellung zur Verfügung stehen
     * @param   parameterThema          Das Hauptthema der nächsten Ausstellung
     * @param   pKostengrenze           Das maximale Budget der nächsten Ausstellung
     * 
     * @return ArrayList<Kunstwerk>     Die Liste mit den in der nächsten Ausstellung benutzten Kunstwerke.
     */
    public static ArrayList<Kunstwerk> optimiere2(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema, int pKostengrenze)
    {
        ArrayList<Kunstwerk> ReturnList = new ArrayList<Kunstwerk>();
        HashMap<Raum, ArrayList<Kunstwerk>> Ausstellung = new HashMap<Raum, ArrayList<Kunstwerk>>();
        for(Raum pRaum : parameterRaeume)
        {
            Ausstellung.put(pRaum, new ArrayList<Kunstwerk>());
            pRaum.setSchwerpunktThema(parameterThema);
        }

        return StarteOptimierung(Ausstellung,parameterKunstwerke,new ArrayList<Kunstwerk>(),parameterThema,0,pKostengrenze);
    }

    /**
     * Rekursiver Backtracking Algorithmus der versucht die Räume optimal unter Berücksichtigung aller vorgegebenen Bedingungen zu füllen
     * Die Methode ruft sich solange auf bis alle Möglichkeiten ausprobiert worden sind.
     * Jedes Mal wenn eine neue Kombination gefunden wird, in der mehr Kunstwerke in den Räumen verteilt werden können als vorher, wird diese in einer globalen Variable zwischengespeichert.
     * 
     * @param   pAusstellung            Hashmap die ausgibt welche Kunstwerke gerade in welchem Raum zu finden sind
     * @param   parameterKunstwerke     ArrayList die alle Kunstwerke enthält die noch nicht verteilt wurden
     * @param   pReturnList             ArrayList die alle Kunstwerke enthält die bereits verteilt worden sind
     * @param   parameterThema          Das Hauptthema der Ausstellung
     * @param   BesteLaenge             Die Anzahl der verteilten Kunstwerke im aktuellen Optimum
     * @param   pKostengrenze           Die maximalen Kosten für die Ausstellung
     * @return BesteKunstwerk           Globale Variable die im Verlauf des Backtracking optimiert wird
     */
    public static ArrayList<Kunstwerk> StarteOptimierung(HashMap<Raum, ArrayList<Kunstwerk>> pAusstellung, ArrayList<Kunstwerk> parameterKunstwerke, ArrayList<Kunstwerk> pReturnList, String parameterThema,int pBesteLaenge, int pKostengrenze)
    {
        //reject if 3 themen pro raum oder 50% der hauptthemen pro raum1
        //nur rejecten wenn kein add zustande gekommen ist
        //var tempRaeume = (ArrayList<Raum>)parameterRaeume.clone();

        if(!BacktrackingReject(pAusstellung,parameterThema,pKostengrenze))
        {
            return null;
        }
        var tempKunstwerke = (ArrayList<Kunstwerk>)parameterKunstwerke.clone();
        HashMap<Raum, ArrayList<Kunstwerk>> tempAusstellung = (HashMap<Raum, ArrayList<Kunstwerk>>)pAusstellung.clone();
        //merke die anzahl der verwendeten Kunstwerke, je mehr desto besser
        if(pReturnList.size() >= pBesteLaenge)
        {
            //neue beste Lösung zwischenspeichern
            pBesteLaenge = pReturnList.size();
            BesteKunstwerk = pReturnList;
        }

        for(HashMap.Entry<Raum, ArrayList<Kunstwerk>> pRaumMitKunstwerk : pAusstellung.entrySet()) {
            Raum zRaum = pRaumMitKunstwerk.getKey();
            ArrayList<Kunstwerk> value = pRaumMitKunstwerk.getValue();
            for(Kunstwerk pKunstwerk: parameterKunstwerke)
            {
                if(pKunstwerk.getHoehe() < zRaum.getHoehe())
                {
                    if(pKunstwerk instanceof Kunstinstallation)
                    {
                        if(value.size() == 0)
                        {
                            value.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            pReturnList.add(pKunstwerk);                            
                            zRaum.setFreieFlaecheNord(0);
                            zRaum.setFreieFlaecheSued(0);
                            zRaum.setFreieFlaecheOst(0);
                            zRaum.setFreieFlaecheWest(0);
                            StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                        }
                    }
                    if(pKunstwerk instanceof Kunstgegenstand)
                    {
                        // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                        // Passt das Thema zu den anderen Themen?
                        Kunstgegenstand pKunstgegenstand = (Kunstgegenstand)pKunstwerk;
                        if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                        {
                            // Nord,West, Süd, ost
                            if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstgegenstand);
                                tempKunstwerke.remove(pKunstgegenstand);
                                pKunstgegenstand.setinRaum(zRaum);
                                pKunstgegenstand.setXPlatzierung(zRaum.getFreieFlaecheNord() - pKunstgegenstand.getBreite());
                                pKunstgegenstand.setYPlatzierung(200);
                                pReturnList.add(pKunstgegenstand);
                                zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstgegenstand.getBreite() - 200);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstgegenstand);
                                tempKunstwerke.remove(pKunstgegenstand);
                                pKunstwerk.setinRaum(zRaum);
                                pKunstgegenstand.setXPlatzierung(zRaum.getFreieFlaecheSued() - pKunstgegenstand.getBreite());
                                pKunstgegenstand.setYPlatzierung(200);
                                pReturnList.add(pKunstgegenstand);
                                zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstgegenstand.getBreite() - 200);                                
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if((zRaum.getFreieFlaecheWest() - pKunstgegenstand.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstgegenstand);
                                tempKunstwerke.remove(pKunstgegenstand);
                                pKunstgegenstand.setinRaum(zRaum);
                                pKunstgegenstand.setXPlatzierung(zRaum.getFreieFlaecheWest() - pKunstgegenstand.getBreite());
                                pKunstgegenstand.setYPlatzierung(200);
                                pReturnList.add(pKunstgegenstand);
                                zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstgegenstand.getBreite() - 200);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstgegenstand);
                                tempKunstwerke.remove(pKunstgegenstand);
                                pKunstgegenstand.setinRaum(zRaum);
                                pKunstgegenstand.setXPlatzierung(zRaum.getFreieFlaecheOst() - pKunstgegenstand.getBreite());
                                pKunstgegenstand.setYPlatzierung(200);
                                pReturnList.add(pKunstgegenstand);
                                zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstgegenstand.getBreite() - 200);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }
                        }                                                    
                    }
                    if(pKunstwerk instanceof Bild)
                    {
                        // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                        // Passt das Thema zu den anderen Themen?
                        Bild pBild = (Bild)pKunstwerk;
                        if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                        {
                            // Nord,West, Süd, ost
                            if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pBild);
                                tempKunstwerke.remove(pBild);
                                pBild.setinRaum(zRaum);
                                pBild.setXAufhaengung(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite());
                                pBild.setYAufhaengung(100);
                                pReturnList.add(pBild);
                                zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pBild.setXAufhaengung(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite());
                                pBild.setYAufhaengung(100);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pBild.setXAufhaengung(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite());
                                pBild.setYAufhaengung(100);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pBild.setXAufhaengung(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite());
                                pBild.setYAufhaengung(100);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100);
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1,pKostengrenze);
                            }
                        }                                                    
                    }
                }                
            }
        }
        return BesteKunstwerk;
    }

    /**
     * Die Methode prüft mehrere Bedingungen die wichtig sind um die Kunstwerke optimal zu verteilen.
     * Es wird geprüft ob das Hauptthema in mindestens 50% der Räumen als Mehrheit vertreten ist
     * @param pAusstellung  Alle Räume mit ihren beinhalteten Kunstwerken
     * @param pThema        Das Hauptthema der Ausstellung
     * @param pKostengrenze Das Budget für die Ausstellung
     * @return boolean      True, wenn alle Bedingungen weiterhin gültig sind
     *                      False, falls eine oder beide Bedingungen gebrochen wurden
     */
    public static boolean BacktrackingReject(HashMap<Raum, ArrayList<Kunstwerk>> pAusstellung, String pThema, int pKostengrenze)
    {
        //Prüfe ob 50% sind..        
        double RaeumeMitMehrheit = 0;       
        double Kostengrenze = 0.00;
        for(HashMap.Entry<Raum, ArrayList<Kunstwerk>> pRaumMitKunstwerk : pAusstellung.entrySet()) 
        {            
            // double WerkeMitThema = 0;
            ArrayList<Kunstwerk> value = pRaumMitKunstwerk.getValue();
            HashMap<String,Integer> ZuordnungMehrheit = new HashMap<String,Integer>();
            HashMap.Entry<String, Integer> maxEntry = null;
            for(Kunstwerk pKunstwerk : value)
            {
                ZuordnungMehrheit.merge(pKunstwerk.getThema(), 1, Integer::sum);
                Kostengrenze = Kostengrenze + pKunstwerk.getKosten();
            }            
            for (HashMap.Entry<String, Integer> entry : ZuordnungMehrheit.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }
            if(maxEntry == null || maxEntry.getKey().toString().equals(pThema))
            {
                RaeumeMitMehrheit++;
            }
        }

        if(((RaeumeMitMehrheit/pAusstellung.size()) >= 0.5) && (Kostengrenze <= pKostengrenze))
        {
            return true;
        }
        return false;
    }

    /**
     * Die Methode soll zurückgeben welche Themen bereits in einem Raum vertreten sind
     * @param pKunstwerk    Alle Kunstwerke aus einem Raum
     * @return ReturnList   Alle Themen des Raumes in einer Liste des Typs String
     */
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
}
