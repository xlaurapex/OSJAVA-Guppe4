import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;


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
    
    private File in_datei;
    private File out_datei;
    private Kunstwerkverwaltung kVerw;
    private Raumverwaltung rVerw;
    
    // Enthält, wenn eine Eingabedatei ihr Ende erreicht true, ansonsten enthält eof immer false.
    // Um dies sicherzustellen kann nicht von ausserhalb auf dieses Attribut zugegriffen werden, 
    // sondern ein Zugriff muss über die Methode eof erfolgen.
    private boolean eof;
    // Objekt einer Java-Klasse zum Schreiben von Zeichenketten
    private PrintWriter dAus;
    // Objekt einer Java-Klasse zum Lesen von Zeichenketten
    private BufferedReader dEin;
    
    
    /**
    * Enthält nach dem Aufruf einer Methode einen Fehlercode.
    * 0 bedeutet, dass kein Fehler aufgetreten ist und über die 
    * Methode errorMessage kann man eine Beschreibung eines 
    * Fehlercodes erfragen.
    */
    public int errorCode;
    

    /**
     * Konstruktor für Objekte der Klasse Datei
     * test
     */
    public Datei()
    {
        //nichts tun
        
    }
    

        /**
         * mit der Methode verarbeiteKunstwerkeDatei() werden die Eingabedateien für Kunstwerke eingelesen, 
         * verarbeitet und entsprechende Objekte der Klassen "Bild","Kunstgegenstand" und "Kunstinstallation" erzeugt 
         * 
         * @param  in_datei    als Eingabeparameter für die Methode ist der Dateipfad erforderlich, wo die einzulesende Datei zu finden ist
         * @return        die Methode gibt ein Objekt Kunstwerkverwaltung zurück mit den eingelesenen Kunstwerken
         * @author  Laura Perlbach
         */
        public Kunstwerkverwaltung verarbeiteKunstwerkeDatei(String in_datei)
        {
            //Erstelle neue Kunstwerkverwaltung
            kVerw = new Kunstwerkverwaltung();

            // Anlegen eines Strings, der innnerhalb diese Methode benoetigt wird
            String zwStr ="";
            // Anlegen eines Strings, der innnerhalb diese Methode benoetigt wird, um den Kunstwerkstyp zu unterscheiden
            String zwTyp;
            //Speichern des Eingabedateipfads
            this.in_datei = new File(in_datei);
            
            Kunstwerk k;
            
            //Öffnen der Eingabedatei
            try{openInFile();}
            catch (IOException e)
            {
                System.out.println("Fehler beim Einlesen der Datei");
                System.out.println(e.getMessage());
            }
            
            //Verarbeiten der Datei bis Ende erreicht
            while (!eof){
                //Ergänzen eines Zählers
                int count = 1;
                
                //Einlesen der aktuellen Zeile der Datei
                try{zwStr = readLine();}
                catch (IOException e)
                {
                    System.out.println("Fehler beim Einlesen der "+ count + ". Zeile");
                    System.out.println(e.getMessage());
                 }
                
                if(!eof){
                    //Erhöhen des Zeilenzählers
                    count++;
    
                    //Ermitteln der Position des Trennzeichens ","
                    int posKomma = zwStr.indexOf(",");
                    zwTyp = zwStr.substring(posKomma+1,posKomma+2);
                    
                    //Lesen und setzen der Attribute, die für alle Kunstwerke identisch sind
                    //setzen der laufenden Nummer 
                    int lfdNr = Integer.parseInt(zwStr.substring(0,posKomma));
                    //Verkürzen des eingelesenen Strings um die laufende Nummer und den Typ des Kunstwerks
                    zwStr = zwStr.substring(posKomma+3);
                    posKomma = zwStr.indexOf(",");
                    //setzen der Bezeichnung 
                    String bez = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um die Bezeichnung
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen des Künstlers 
                    String kuenstler = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um den Künstlernamen
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen der Jahresangabe
                    String jahr = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um den die Jahresangabe
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen das Thema
                    String thema = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um das Thema
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen die Attraktivität
                    int attr = Integer.parseInt(zwStr.substring(0,posKomma));
                    //Verkürzen des eingelesenen Strings um die Attraktivität
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen der Kosten
                    int kosten = Integer.parseInt(zwStr.substring(0,posKomma));
                    //Verkürzen des eingelesenen Strings um die Kosten
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen des Museumsnamen
                    String nMuseum = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um den Museumsnamen
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen des Museums (Adresse)
                    String aMuseum = zwStr.substring(0,posKomma);
                    //Verkürzen des eingelesenen Strings um die Museumsadresse
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen der Hoehe
                    int hoehe = Integer.parseInt(zwStr.substring(0,posKomma));
                    //Verkürzen des eingelesenen Strings um die Höhe
                    zwStr = zwStr.substring(posKomma+1);
                    
                    posKomma = zwStr.indexOf(",");
                    //setzen der Hoehe
                    int breite = Integer.parseInt(zwStr.substring(0,posKomma));
                    //Verkürzen des eingelesenen Strings um die Höhe
                    zwStr = zwStr.substring(posKomma+1);
                    posKomma = zwStr.indexOf(",");
                    
                    if(zwTyp.equals("B"))
                    {
                        double minT = Double.parseDouble(zwStr.substring(0,posKomma));
                        //Verkürzen des eingelesenen Strings um die Minimaltemperatur
                        zwStr = zwStr.substring(posKomma+1);
                        posKomma = zwStr.indexOf(",");
                        double maxT = Double.parseDouble(zwStr.substring(0,posKomma));
                        //Verkürzen des eingelesenen Strings um die Maximaltemperatur
                        zwStr = zwStr.substring(posKomma+1);
                        posKomma = zwStr.indexOf(",");
                        double minLF = Double.parseDouble(zwStr.substring(0,posKomma));
                        //Verkürzen des eingelesenen Strings um die Minimalen Lufttemperatur
                        zwStr = zwStr.substring(posKomma+1);
                        posKomma = zwStr.indexOf(",");
                        double maxLF = Double.parseDouble(zwStr.substring(0,posKomma));
                        
                        k = new Bild(lfdNr, bez, kuenstler, jahr, thema, attr, kosten, nMuseum, aMuseum, hoehe, breite, minT, maxT, minLF, maxLF);
                        kVerw.addKunstwerk(k);
                        System.out.println(k.toString());
                         
                    }
                    else if(zwTyp.equals("G"))
                    {
                        int laenge = Integer.parseInt(zwStr.substring(0,posKomma));
                        //Verkürzen des eingelesenen Strings um die Minimaltemperatur
                        zwStr = zwStr.substring(posKomma+1);
                        posKomma = zwStr.indexOf(",");
                        double gewicht = Double.parseDouble(zwStr.substring(0,posKomma));
                        
                        k = new Kunstgegenstand(lfdNr, bez, kuenstler, jahr, thema, attr, kosten, nMuseum, aMuseum, hoehe, breite, laenge, gewicht);
                        kVerw.addKunstwerk(k);
                        System.out.println(k.toString());
                        
                    }
                    else if(zwTyp.equals("I"))
                    {
                        int laenge = Integer.parseInt(zwStr.substring(0,posKomma));
                        //Verkürzen des eingelesenen Strings um die Minimaltemperatur
                        zwStr = zwStr.substring(posKomma+1);
                        posKomma = zwStr.indexOf(",");
                        double gewicht = Double.parseDouble(zwStr.substring(0,posKomma));
                        
                        k = new Kunstinstallation(lfdNr, bez, kuenstler, jahr, thema, attr, kosten, nMuseum, aMuseum, hoehe, breite, laenge, gewicht);
                        kVerw.addKunstwerk(k);
                        System.out.println(k.toString());
                    }
                    else
                    {
                        System.out.println("Fehler beim Einlesen der " + count + ". Zeile. Unbekannte Art des Kunstwerks");
                     }

                }
            
                
            }
            
            //Schließen der Eingabedatei
            try{closeInFile();}
            catch (IOException e)
            {
                System.out.println("Fehler beim Schließen der Datei");
                System.out.println(e.getMessage());
            }
            
            return kVerw;
    }
    
    /**
     * mit der Methode verarbeiteRaumDatei() werden die Eingabedateien für Räume eingelesen, 
     * verarbeitet und entsprechende Objekte der Klasse "Raum" angelegt
     * 
     * @param  in_datei    als Eingabeparameter für die Methode ist der Dateipfad erforderlich, wo die einzulesende Datei zu finden ist
     * @return        die Methode gibt ein Objekt Raumverwaltung zurück mit den eingelesenen Räumen
     * 
     * @author  Laura Perlbach
     */
    public Raumverwaltung verarbeiteRaumDatei(String in_datei) 
    {
        //Erstelle neue Raumverwaltung
        rVerw = new Raumverwaltung();

        // Anlegen eines Strings, der innnerhalb diese Methode benoetigt wird
        String zwStr ="";
        //Speichern des Eingabedateipfads
        this.in_datei = new File(in_datei);
        
               
        //Öffnen der Eingabedatei
        try{openInFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Einlesen der Datei");
            System.out.println(e.getMessage());
        }
        
        //Verarbeiten der Datei bis Ende erreicht
        while (!eof){
            //Ergänzen eines Zählers
            int count = 1;
            
            //Einlesen der aktuellen Zeile der Datei
            try{zwStr = readLine();}
            catch (IOException e)
            {
            System.out.println("Fehler beim Einlesen der "+ count + ". Zeile");
            System.out.println(e.getMessage());
            }
            
            if(!eof){
                //Erhöhen des Zeilenzählers
                count++;

                //Ermitteln der Position des Trennzeichens ","
                int posKomma = zwStr.indexOf(",");
                //setzen der laufenden Nummer 
                int lfdNr = Integer.parseInt(zwStr.substring(0,posKomma));
                //Verkürzen des eingelesenen Strings um die laufende Nummer
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Bezeichnung
                String bezeichnung = zwStr.substring(0,posKomma);
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Länge
                int laenge = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Breite
                int breite = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Höhe
                int hoehe = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Türbreite Nord
                int tNord = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Türbreite Ost
                int tOst = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);
                
                posKomma = zwStr.indexOf(",");
                //Setzen der Türbreite Süd
                int tSued = Integer.parseInt(zwStr.substring(0,posKomma));
                zwStr = zwStr.substring(posKomma+1);

                //Setzen der Türbreite West
                int tWest = Integer.parseInt(zwStr);
                
                //Erzeuge neuen Raum
                rVerw.addRaum(new Raum(lfdNr, bezeichnung, laenge, breite, hoehe, tNord, tOst, tSued, tWest));
            }
        
            
        }
        
        
        //Schließen der Eingabedatei
        try{closeInFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Schließen der Datei");
            System.out.println(e.getMessage());
        }
        
              
        return rVerw;

    }
    
    /**
     * mit der Methode erzeugeLeihDatei() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen zum Partner-
     * museum, Kosten und der Kunstwerke gespeichert
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @param out_datei Angabe eines Datei-Pfads, wo die Datei abgelegt werden soll
     * 
     * @return        die Methode gibt je nach Erfolg true oder false zurück
     * @author  Laura Perlbach
     */
    public boolean erzeugeLeihDatei(Ausstellung ausstellung, String out_datei)
    {
        //Get der HashMap der Ausstellung
        ArrayList<Kunstwerk> a = ausstellung.getAusstellung();
        
        //Anlegen einer neuen Outputdatei
        this.out_datei = new File(out_datei);
        try{openOutFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Öffnen der Datei");
            System.out.println(e.getMessage());
        }
        
        //Erzeuge Überschriften
        writeLine("Laufende Nummer: Bezeichnung, Name des Museums, Anschrift des Museums, Kosten");
        for(Kunstwerk kw: a)
        {
            //schreibe einzelne Objekte in die Ausgabedatei
            // !! bisher noch nicht sortiert nach Museum
            writeLine(kw.getLaufendeNummer() + ": " + kw.getBezeichnung() + ", " + kw.getNameMuseums() + ", " + kw.getAnschriftMuseums() + ", " + kw.getKosten());
        }
        
        //Schließen der Ausgabedatei
        closeOutFile();

        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Leih-Quelle
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return true;
    }
    
    /**
     * mit der Methode erzeugeZuordnungsdatei() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen
     * der einzelnen Kunstwerke und der Räume, in denen diese ausgestellt werden, sowie die notwendigen Informationen zur Platzierung und 
     * Klimatisierung der Räume
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @return        die Methode gibt je nach Erfolg true oder false zurück
     * @author  Laura Perlbach
     */
    public boolean erzeugeZuordnungsDatei(Ausstellung ausstellung)
    {
        int error = 0;
        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Ausstellungsraum
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return true;
    }
    
    /**
     * mit der Methode erzeugeMuseumsführer() wird die aus dem Optimierungsalgorithmus erzeugte Ausstellung in einer Datei mit den Informationen
     * der einzelnen Kunstwerke und der Räume in einer Aufbereitungsform eines Museumsführers mit den wichtigsten Kunstwerken je Raum
     * 
     * @param  ausstellung der Parameter ausstellung beschreibt die Liste der ausgestellten Kunstwerke inklusive Raumzuordnung,
     * welche die fertige Planung darstellt. 
     * @return        die Methode gibt je nach Erfolg true oder false zurück
     * @author  Laura Perlbach
     */
    public boolean erzeugeMuseumsführer(Ausstellung ausstellung)
    {
        int error = 0;
        
        //die Eingabewerte sind eine Liste der Objekte Kunstwerke (bzw. der Unterklassen)
        //Sortieren der Objekte nach Leih-Quelle
        //diese werden einzeln mit den relevanten Informationen in eine Datei geschrieben
                
        return true;
    }
    
    /**
     * Öffnet eine Eingabedatei namens dName.
     * 
     * @exception IOException Wenn die Datei nicht geöffnet werden konnte.
     */
    private void openInFile() throws IOException
    {
        errorCode =0;
        eof = false;
        dEin = new BufferedReader(new FileReader(in_datei));
    }
    
    /**
     * Schließt eine Eingabedatei.
     * 
     * @exception IOException Wenn beim Versuch die Datei zu schließen ein Fehler aufgetreten ist.
     */
    private void closeInFile()  throws IOException
    {
        errorCode =0;
        eof = false;
        dEin.close();
    }
    
    /**
     * Liest eine Zeile aus einer Eingabedatei.
     * 
     * @return ausgelesene Zeile.
     * @exception IOException Wenn beim Zugriff auf die Datei ein Fehler aufgetreten ist
     */
    private String readLine() throws IOException
    {
        String zw_in = dEin.readLine();
        if (zw_in == null){
            eof=true;
            return zw_in;
        }
        else{
            errorCode =0;
            return zw_in;
        }
    }
    
    /**
     * Öffnet eine Ausgabedatei namens dName.
     * 
     * @exception IOException Wenn die Datei nicht gelesen werden kann
     */
    public void openOutFile() throws IOException
    {
        eof=false;
        errorCode=0;
        dAus = new PrintWriter(new BufferedWriter(new FileWriter(out_datei)));
    }
    
        /**
     * Schließt eine Ausgabedatei.
     * 
     */
    public void closeOutFile()
    {
        errorCode =0;
        dAus.close();
    }
    
    /**
     * Schreibt einen String als Zeile in eine Datei.
     * 
     * @param  in_str Zeichenkette die in die Datei geschrieben 
     *                  werden soll.
     */
    public void writeLine(String in_str)
    {
        eof=false;
        errorCode =0;
        dAus.write(in_str+"\n");

    }
}
