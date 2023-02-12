import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Collections;


/**
 * Die Klasse Datei dient dem Einlesen und Ausgeben von Dateien und bietet Standardfunktionen zur Dateiverarbeitung. 
 * Diese wird durch die Klassen „Ausstellungsverwaltung“ (z.B. Erstellen des Ausstellungsführers), 
 * Raumverwaltung (z.B. Einlesen der Raumdatei) und Kunstwerksverwaltung (z.B. Einlesen der verfügbaren Kunstwerke) verwendet.
 * 
 * @author Laura Perlbach
 * @version 12.02.2023
 */
public class Datei
{
      
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
                System.out.println("Fehler beim Einlesen der Kunstwerke-Datei");
                System.out.println(e.getMessage());
                errorCode = 1;
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
                    errorCode = 2;
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
                        
                        //Erstellen eines neues Bildes mit den relevanten Parametern und Anhängen an die Kunstwerksliste
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
                        
                        //Erstellen eines neues Kunstgegenstand mit den relevanten Parametern und Anhängen an die Kunstwerksliste
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
                        
                        //Erstellen einer neuen Kunstinstallation mit den relevanten Parametern und Anhängen an die Kunstwerksliste
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
                System.out.println("Fehler beim Schließen der Kunstwerke-Datei");
                System.out.println(e.getMessage());
                errorCode = 3;
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
            System.out.println("Fehler beim Einlesen der Raum-Datei");
            System.out.println(e.getMessage());
            errorCode = 4;
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
            System.out.println("Fehler beim Schließen der Raum-Datei");
            System.out.println(e.getMessage());
            errorCode = 5;
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
        //Sortieren der Ausstellung 
        ausstellung.sortNachMuseum();
        //Get der Liste der Ausstellung
        ArrayList<Kunstwerk> a = ausstellung.getAusstellung();
              
        //Anlegen einer neuen Outputdatei
        this.out_datei = new File(out_datei);
        try{openOutFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Öffnen der Datei");
            System.out.println(e.getMessage());
            errorCode = 6;
        }
        
        //Erzeuge Überschriften
        writeLine("Laufende Nummer: Bezeichnung, Name des Museums, Anschrift des Museums, Kosten");
        for(Kunstwerk kw: a)
        {
            //schreibe einzelne Objekte in die Ausgabedatei
            // !! bisher noch nicht sortiert nach Museum
            writeLine(kw.getLaufendeNummer() + ": " + kw.getBezeichnung() + ", " + kw.getNameMuseums() + ", " + kw.getAnschriftMuseums() + ", " + kw.getKosten());
        }
        //Ausgeben der Gesamtkosten
        writeLine("Gesamtkosten:" + ausstellung.getGesamtKosten());
        
        //Schließen der Ausgabedatei
        closeOutFile();

                
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
        //Sortieren der Ausstellung 
        ausstellung.sortNachRaum();
        //Get der Liste der Ausstellung
        ArrayList<Kunstwerk> a = ausstellung.getAusstellung();
        Raum aktRaum = a.get(0).getInRaum();
                       
        //Anlegen einer neuen Outputdatei
        this.out_datei = new File("output/ausstellungsplan.html");
        try{openOutFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Öffnen der Datei");
            System.out.println(e.getMessage());
            errorCode = 7;
        }
        
        //Erzeuge HTML-Template Beginn
        writeLine("<!DOCTYPE html>");
        writeLine("<html>");
        writeLine("<head>");
        writeLine("<meta charset=\"UTF-8\">");
        writeLine("<title>Ausstellungplan</title>");
        writeLine("</head>");
        writeLine("<body>");
        //Erzeuge Datei-Inhalt
        writeLine("<h1>VAWi-Museum - Ausstellungsplan</h1>");
        writeLine("Im folgenden wird werden die einzelnen Ausstellungsstücke nach den Räumen sortiert aufgelistet und die notwendigen Raum-Paramter angegeben");
        
        //Daten des ersten Raums in die Datei schreiben
        writeLine("<h2>Raum: "+aktRaum.getBezeichnung()+"</h2>");
        writeLine("Temperatur       : "+aktRaum.getTemperatur());
        writeLine("Luftfeuchtigkeit : "+aktRaum.getLuftfeuchtigkeit());
        writeLine("");
        
        //alle Kunstwerke des ersten Raums auflisten (bei jedem Kunstwerk Raum mit akt. Raum vergleichen)
        //Kunstwerke bereits nach Raum sortiert
        for(Kunstwerk kw: a)
        {
            //wenn neuer Raum, Raumdetails listen
            if (aktRaum != kw.getInRaum()){
                aktRaum = kw.getInRaum();
                writeLine("<h2>Raum: "+aktRaum.getBezeichnung()+"</h2>");
                writeLine("Temperatur       : "+aktRaum.getTemperatur());
                writeLine("Luftfeuchtigkeit : "+aktRaum.getLuftfeuchtigkeit());
                writeLine("");
                
            } 
            //schreibe einzelne Objekte in die Ausgabedatei
            if (kw instanceof Bild){
                Bild bild = (Bild) kw;
                writeLine("<h4>Bild: "+bild.getBezeichnung()+"</h4>");
                writeLine("Wand: "+bild.getWand());
                writeLine("Aufhängung in Zentimetern von der linken Wandseite: "+bild.getXAufhaengung());
                writeLine("");
            }
            
            if (kw instanceof Kunstgegenstand){
                Kunstgegenstand kg = (Kunstgegenstand) kw;
                writeLine("<h4>Kunstgegenstand: "+kg.getBezeichnung()+"</h4>");
                writeLine("Platzierung horizontal im Raum in cm ausgehend von der Nordwest-Ecke: "+kg.getXPlatzierung());
                writeLine("Platzierung vertikal im Raum in cm ausgehend von der Nordwest-Ecke: "+kg.getYPlatzierung());
                writeLine("");
            }
            
            if (kw instanceof Kunstinstallation){
                writeLine("<h4>Kunstinstallation: "+kw.getBezeichnung()+"</h4>");
                writeLine("");
            }
            
        }
        
        //Erzeuge HTML-Template Ende
        writeLine("</body>");
        writeLine("</html>");
        
        //Schließen der Ausgabedatei
        closeOutFile();
    
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
        
        //Sortieren der Ausstellung 
        ausstellung.sortNachRaum();
        //Get der Liste der Ausstellung
        ArrayList<Kunstwerk> a = ausstellung.getAusstellung();
        Raum aktRaum = null;

        //Anlegen einer neuen Outputdatei
        this.out_datei = new File("output/museumsfuehrer.html");
        try{openOutFile();}
        catch (IOException e)
        {
            System.out.println("Fehler beim Öffnen der Datei");
            System.out.println(e.getMessage());
            errorCode = 8;
        }
        
        //Erzeuge HTML-Template Beginn
        writeLine("<!DOCTYPE html>");
        writeLine("<html>");
        writeLine("<head>");
        writeLine("<meta charset=\"UTF-8\">");
        writeLine("<title>Museumsführer</title>");
        writeLine("</head>");
        writeLine("<body>");
        //Erzeuge Datei-Inhalt
        writeLine("<h1>VAWi-Museum - Museumsführer</h1>");
        writeLine("Herzlich Willkommen im VAWi-Museum und der aktuellen Ausstellung zum Schwerpunktthema " + ausstellung.getThema() +".");
        writeLine("");
        writeLine("Lassen Sie sich von unseren Kunstwerken in eine andere Welt entführen.");
        
        for(Kunstwerk kw: a)
        {
            //wenn neuer Raum, Raumdetails listen
            if (aktRaum != kw.getInRaum()){
                aktRaum = kw.getInRaum();
                writeLine("<h2>Raum: "+aktRaum.getBezeichnung()+"</h2>");
                writeLine("<h3>Austellungsstücke</h3>");
            } 
            //schreibe einzelne Objekte in die Ausgabedatei
            //Objekte wer in eine HTML-Tabelle geschrieben
            writeLine("<table>");
            if (kw instanceof Bild){
                writeLine("<tr><td>Art:</td> <td>Bild</td> </tr>");
            }
            
            if (kw instanceof Kunstgegenstand){
                writeLine("<tr><td>Art:</td> <td>Kunstgegenstand</td> </tr>");     
            }
            
            if (kw instanceof Kunstinstallation){
                writeLine("<tr><td>Art:</td> <td>Kunstinstallation</td> </tr>"); 
            }
            
            writeLine("<tr><td>Bezeichnung:</td><td>" + kw.getBezeichnung() +"</td> </tr>");
            writeLine("<tr><td>Künstler:</td> <td>" + kw.getKuenstlername() +"</td> </tr>");
            writeLine("<tr><td>Jahresangabe:</td> <td>" + kw.getJahresangabe() +"</td> </tr>");
            writeLine("<tr><td>Thema: </td> <td>" + kw.getThema() +"</td> </tr>");
            writeLine("</table>");
            writeLine("<br/>");
        }
        
        //Erzeuge HTML-Template Ende
        writeLine("</body>");
        writeLine("</html>");
        
        //Schließen der Ausgabedatei
        closeOutFile();
                
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
        try{
        String zw_in = dEin.readLine();
        if (zw_in == null){
            eof=true;
            return zw_in;
        }
        else{
            errorCode =0;
            return zw_in;
        }}
        catch (Exception e){
            System.out.println("Die angegebene Datei existiert nicht bzw. es ist ein Fehler beim Lesen aufgetreten.");
            System.out.println(e.getMessage());
            errorCode = 9;
            return null;
            
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
    
    public int errorMessage()
    {
        switch (errorCode){
            case 0: System.out.println ("Glückwunsch: Es sind keine Fehler aufgetreten!"); break;
            case 1: System.out.println ("Error Code 1: Es ist ein Fehler beim Einlesen der Kunstwerke-Datei aufgetreten!");break;
            case 2: System.out.println ("Error Code 2: Es ist ein Fehler beim Einlesen einer Zeile der Kunstwerke-Datei aufgetreten!");break;
            case 3: System.out.println ("Error Code 3: Es ist ein Fehler beim Schließen der Kunstwerke-Datei aufgetreten!");break;
            case 4: System.out.println ("Error Code 4: Es ist ein Fehler beim Einlesen der Raum-Datei aufgetreten!");break;
            case 5: System.out.println ("Error Code 5: Es ist ein Fehler beim Schließen der Raum-Datei aufgetreten");break;
            case 6: System.out.println ("Error Code 6: Es ist ein Fehler beim Öffnen/Erstellen der Ausgabedatei \"Leihdatei\" aufgetreten!");break;
            case 7: System.out.println ("Error Code 7: Es ist ein Fehler beim Öffnen/Erstellen der Ausgabedatei \"Ausstellungsplan\" aufgetreten!");break;
            case 8: System.out.println ("Error Code 8: Es ist ein Fehler beim Öffnen/Erstellen der Ausgabedatei \"Museumsführer\" aufgetreten!");break;
            case 9: System.out.println ("Error Code 9: Es ist ein Fehler beim Lesen einer Zeile aufgetreten!");break;
        }
        return errorCode;
    }
    
}
