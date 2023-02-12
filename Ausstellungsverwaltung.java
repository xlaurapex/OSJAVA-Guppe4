import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Die Klasse Ausstellungsverwaltung Die Klasse „Ausstellungsverwaltung“ stellt die Kernaufgabe des Systems dar. 
 * Sie dient dazu aus den Gegebenheiten der Raum- und Kunstwerksverwaltung die optimale Ausstel-lungskombination zu ermitteln. 
 * Diese Klasse beinhaltet somit den größten Anteil der Pro-zessabwicklung. 
 * Durch die Klasse „Ausstellungsverwaltung“ werden Objekte der Klasse „Ausstellung“ erzeugt. 
 * Über die Klassen „Raumverwaltung“ und „Kunstwerksverwaltung“ werden Input-Daten der Räume und verfügbaren Kunstwerke geliefert.
 * 
 * 
 * 
 * @author Marcell Wach, Laura Perlbach, Johannes Riedmeier, Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ausstellungsverwaltung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    Ausstellung a;
    public Kunstwerkverwaltung kwv;
    Raumverwaltung rvw;
    //Optimierungsalgorithmus y;
    /**
     * Konstruktor für Objekte der Klasse Museumsverwaltung
     */
    public Ausstellungsverwaltung()
    {
        // Instanzvariable initialisieren

    }

    /**
     * die Main-Methode beschreibt den zentralen Logik-Ablauf der Museumsverwaltung und steuert 
     * damit den Ablauf und Aufruf der verschiedenen Klassen von der Eingabe der Eingabe-Dateien bis hin zur Ausgabe der Augabedateien
     * 
     * 
     * 
     */
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        // Abfragen der Eingabedateien
        System.out.println("Bitte geben Sie die Input-Datei für die Räume ein (Format: raeume.csv)");
        String raumdatei = in.next();
        Datei d = new Datei();
        //Test-/Defaultpfad
        //Raumverwaltung rv = d.verarbeiteRaumDatei("raeume.csv");
        Raumverwaltung rv = d.verarbeiteRaumDatei(raumdatei);
        //Test-/Defaultpfad
        System.out.println("Bitte geben Sie die Input-Datei für die Kunstwerke ein (Format: kunstwerke.csv)");
        String kunstwerksdatei = in.next();
        //Kunstwerkverwaltung kv = d.verarbeiteKunstwerkeDatei("kunstwerke.csv");
        Kunstwerkverwaltung kv = d.verarbeiteKunstwerkeDatei(kunstwerksdatei);
        // dadurch Erstellung der Raüme und Kunstwerke

        // Eingabe des Wunschthemas für die Ausstellung (und Kostenobergrenze)
        System.out.println("Bitte geben Sie Ihr Wunschthema für die bevorstehende Ausstellung ein! (Format: Rokoko)");
        String thema = in.next();

        System.out.println("Bitte geben Sie Ihre Kostenobergrenze für die bevorstehende Ausstellung ein! (Format: 15000)");
        String kostengrenze = in.next();
        // Starten des Optimierungsalgorithmus (mit Eingabe der Liste der Kunstwerke, der Liste der Räume und der Themenwahl)

        // dadurch Erzeugung der Ausstellung (Zuordnung Raum und Kunstwerke)

        // Ausstellung erzeugt Ausgabedateien

        //Test-Erzeugung einer Ausstellung (kommt eigentlich aus Optimierungsalgorithmus)
        // Raum r1 = new Raum(1, "Raum1", 1000,100,300, 0,0,0,200);
        // Raum r2 = new Raum(1, "Raum1", 1000,100,300, 0,0,0,200);
        // Bild b1 = new Bild(1, "Bild1", "künstler","2000er","thema", 50, 5000,"nMuseum", "aMuseum", 20, 40, 5,30,50,60);
        // b1.setWirdAusgestellt(true);
        // b1.setinRaum(r1);
        // b1.setXAufhaengung(100);
        // b1.setYAufhaengung(100);
        // Kunstgegenstand g1 = new Kunstgegenstand(2, "Kunstgegenstand2", "künstler2","2002er","thema2", 52, 5002,"aMuseum2", "aMuseum2",22, 42, 150,60);
        // g1.setWirdAusgestellt(true);
        // g1.setinRaum(r1);
        // g1.setXPlatzierung(100);
        // g1.setYPlatzierung(100);

        // ArrayList<Kunstwerk> a = new ArrayList<Kunstwerk>();
        // a.add(b1);
        // a.add(g1);

        // Ausstellung ausstellung = new Ausstellung(a, "Rokoko");

        //TESTING!!!!!!!!!!!!!!
        ArrayList<Kunstwerk> ZugeordneteKunstwerke = Optimierungsalgorithmus.optimiere2(rv.getRaeume(), kv.getKunstwerke(),thema,Integer.parseInt(kostengrenze));
        Ausstellung ausstellung = new Ausstellung(ZugeordneteKunstwerke, thema);
        d.erzeugeZuordnungsDatei(ausstellung);
        d.erzeugeLeihDatei(ausstellung, "output/Leihdatei.txt");
        d.erzeugeMuseumsführer(ausstellung);
        //TESTING!!!!!!!!!!!!!!
        d.errorMessage();
        System.out.println("Vielen Dank! Bitte finden Sie Ihre Ausgabedateien im Output-Ordner.");
    }
}

