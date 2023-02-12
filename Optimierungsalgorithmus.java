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
     * 
     */
    public static ArrayList<Kunstwerk> optimiere2(ArrayList<Raum> parameterRaeume, ArrayList<Kunstwerk> parameterKunstwerke, String parameterThema)
    {
        ArrayList<Kunstwerk> ReturnList = new ArrayList<Kunstwerk>();
        HashMap<Raum, ArrayList<Kunstwerk>> Ausstellung = new HashMap<Raum, ArrayList<Kunstwerk>>();
        for(Raum pRaum : parameterRaeume)
        {
            Ausstellung.put(pRaum, new ArrayList<Kunstwerk>());
            pRaum.setSchwerpunktThema(parameterThema);
        }

        return StarteOptimierung(Ausstellung,parameterKunstwerke,new ArrayList<Kunstwerk>(),parameterThema,0);
    }

    /**
     * 
     */
    public static ArrayList<Kunstwerk> StarteOptimierung(HashMap<Raum, ArrayList<Kunstwerk>> pAusstellung, ArrayList<Kunstwerk> parameterKunstwerke, ArrayList<Kunstwerk> pReturnList, String parameterThema,int pBesteLaenge)
    {
        //reject if 3 themen pro raum oder 50% der hauptthemen pro raum1
        //nur rejecten wenn kein add zustande gekommen ist
        //var tempRaeume = (ArrayList<Raum>)parameterRaeume.clone();

        if(!BacktrackingReject(pAusstellung,parameterThema))
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
                            StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                        }
                    }
                    if(pKunstwerk instanceof Kunstgegenstand)
                    {
                        // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                        // Passt das Thema zu den anderen Themen?
                        if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                        {
                            // Nord,West, Süd, ost
                            if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }
                        }                                                    
                    }
                    if(pKunstwerk instanceof Bild)
                    {
                        // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                        // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                        // Passt das Thema zu den anderen Themen?
                        if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                        {
                            // Nord,West, Süd, ost
                            if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100) >= 0)
                            {
                                value.add(pKunstwerk);
                                tempKunstwerke.remove(pKunstwerk);
                                pKunstwerk.setinRaum(zRaum);
                                pReturnList.add(pKunstwerk);
                                zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100);
                                // parameterKunstwerke = tempKunstwerke;
                                StarteOptimierung(pAusstellung,tempKunstwerke,pReturnList,parameterThema,pBesteLaenge+1);
                            }
                        }                                                    
                    }
                }                
            }
            // return null;
        }
        return BesteKunstwerk;
    }

    /**
     * Bla
     * @param
     * @return
     */
    public static boolean BacktrackingReject(HashMap<Raum, ArrayList<Kunstwerk>> pAusstellung, String pThema)
    {
        //Prüfe ob 50% sind..        
        double RaeumeMitMehrheit = 0;        
        for(HashMap.Entry<Raum, ArrayList<Kunstwerk>> pRaumMitKunstwerk : pAusstellung.entrySet()) 
        {            
            // double WerkeMitThema = 0;
            ArrayList<Kunstwerk> value = pRaumMitKunstwerk.getValue();
            HashMap<String,Integer> ZuordnungMehrheit = new HashMap<String,Integer>();
            HashMap.Entry<String, Integer> maxEntry = null;
            for(Kunstwerk pKunstwerk : value)
            {
                // if(ZuordnungMehrheit.containsKey(pKunstwerk.getThema()))
                // {
                // WerkeMitThema++;
                // }
                ZuordnungMehrheit.merge(pKunstwerk.getThema(), 1, Integer::sum);
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

        if((RaeumeMitMehrheit/pAusstellung.size()) >= 0.5)
        {
            return true;
        }
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
        //int AnzahlKunstwerke = parameterKunstwerke.size();
        int AnzahlKunstwerke = berechneInstaUndGegen(parameterKunstwerke);
        ArrayList<Kunstwerk> ReturnList = new ArrayList<Kunstwerk>();
        int AnzahlKunstinstallationen = 0;

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
        for(HashMap.Entry<Raum, ArrayList<Kunstwerk>> pRaumMitKunstwerk : Ausstellung.entrySet()) {
            Raum zRaum = pRaumMitKunstwerk.getKey();
            ArrayList<Kunstwerk> value = pRaumMitKunstwerk.getValue();
            for(Kunstwerk pKunstwerk: parameterKunstwerke)
            {
                if(pKunstwerk instanceof Kunstgegenstand)
                {
                    // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                    // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                    // Passt das Thema zu den anderen Themen?
                    if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                    {
                        // Nord,West, Süd, ost
                        if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200) >= 0)
                        {
                            value.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 200);
                            parameterKunstwerke = tempKunstwerke;
                            break;
                        }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200) >= 0)
                        {
                            value.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 200);
                            parameterKunstwerke = tempKunstwerke;
                            break;
                        }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200) >= 0)
                        {
                            value.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 200);
                            parameterKunstwerke = tempKunstwerke;
                            break;
                        }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200) >= 0)
                        {
                            value.add(pKunstwerk);
                            tempKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 200);
                            parameterKunstwerke = tempKunstwerke;
                            break;
                        }
                    }                                                    
                }
                if(pKunstwerk instanceof Bild)
                {
                    // nur an wände mit genug platz und 3 Themen + Schwerpunktthema
                    // ArrayList<Kunstwerk> temporaereKunstwerke = Ausstellung.get(pRaum);
                    // Passt das Thema zu den anderen Themen?
                    if((getThemenImRaum(value).size() < 3) || (getThemenImRaum(value).contains(pKunstwerk.getThema())))
                    {
                        // Nord,West, Süd, ost
                        if((zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100) >= 0)
                        {
                            value.add(pKunstwerk);
                            parameterKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheNord(zRaum.getFreieFlaecheNord() - pKunstwerk.getBreite() - 100);
                            break;
                        }else if ((zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100) >= 0)
                        {
                            value.add(pKunstwerk);
                            parameterKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheSued(zRaum.getFreieFlaecheSued() - pKunstwerk.getBreite() - 100);
                            break;
                        }else if((zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100) >= 0)
                        {
                            value.add(pKunstwerk);
                            parameterKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheWest(zRaum.getFreieFlaecheWest() - pKunstwerk.getBreite() - 100);
                            break;
                        }else if((zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100) >= 0)
                        {
                            value.add(pKunstwerk);
                            parameterKunstwerke.remove(pKunstwerk);
                            pKunstwerk.setinRaum(zRaum);
                            ReturnList.add(pKunstwerk);
                            zRaum.setFreieFlaecheOst(zRaum.getFreieFlaecheOst() - pKunstwerk.getBreite() - 100);
                            break;
                        }
                    }
                }

            }
        }
        // if(ReturnList.size() == AnzahlKunstwerke)
        // {
        // RaumOptimiert = true;
        // }

        return ReturnList;
    }

    /**
     * Bla
     * @param
     * @return
     */
    private double berechneThemaInAllenRaeumen()
    {
        return -1;
    }

    /**
     * Bla
     * @param
     * @return
     */
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

    /**
     * Bla
     * @param
     * @return
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
