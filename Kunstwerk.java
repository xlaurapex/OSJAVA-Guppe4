
/**
 * Die Klasse Kunstwerk ist eine abstrakte Klasse, woraus sich die Klassen „Bild“, „Kunstge-genstand“ und 
 * „Kunstinstallation“ als Child-Klassen ableiten. Es können keine Objekte der Klasse „Kunstwerk“ erzeugt werden.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Kunstwerk 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int laufendeNummer;
    private String bezeichnung;
    private String kuenstlername;
    private String jahresangabe;
    private String thema;
    private double attraktivitaet;
    private int kosten;
    private String nameMuseums;
    private String anschriftMuseums;
    private int hoehe;
    private int breite;
    //neue Attribute
    private boolean wirdAusgestellt;
    private Raum inRaum;

    
    
    /**
 * Kontruktor für Objekte der abstrakten Klasse Kunstwerk
 */     
    
    public Kunstwerk (int laufendeNummer, String bezeichnung,
                String kuenstlername, String jahresangabe,
                String thema, double attraktivitaet,
                int kosten, String nameMuseums,
                String anschriftMuseums, int hoehe, int breite, boolean wirdAusgestellt,
                Raum inRaum) {
        this.laufendeNummer = laufendeNummer;
        this.bezeichnung = bezeichnung;
        this.kuenstlername = kuenstlername;
        this.jahresangabe = jahresangabe;
        this.thema = thema;
        this.attraktivitaet = attraktivitaet;
        this.kosten = kosten;
        this.nameMuseums = nameMuseums;
        this.anschriftMuseums = anschriftMuseums;
        this.hoehe = hoehe;
        this.breite = breite;
        this.wirdAusgestellt = wirdAusgestellt;
        this.inRaum = inRaum;
    }

    /**
 * Getters and setters - da wir alle Attributen als private deklariert haben, brauchen wir jetzt getters und setters, um den Zugang zu den Attributen zu gewärhleisten
 */

public int getLaufendeNummer() {
    return laufendeNummer;}

public void setLaufendeNummer(int laufendeNummer) {
    this.laufendeNummer = laufendeNummer;}

public String getBezeichnung() {
    return bezeichnung;}

public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;}

public String getKuenstlername() {
    return kuenstlername;}

public void setKuenstlername(String kuenstlername) {
    this.kuenstlername = kuenstlername;}

public String getJahresangabe() {
    return jahresangabe;}

public void setJahresangabe(String jahresangabe) {
    this.jahresangabe = jahresangabe;}

public String getThema() {
    return thema;}

public void setThema(String thema) {
    this.thema = thema;}

public double getAttraktivitaet() {
    return attraktivitaet;}

public void setAttraktivitaet(double attraktivitaet) {
    this.attraktivitaet = attraktivitaet;}

public int getKosten() {
    return kosten;}

public void setKosten(int kosten) {
    this.kosten = kosten;}

public String getNameMuseums() {
    return nameMuseums;}

public void setNameMuseums(String nameMuseums) {
    this.nameMuseums = nameMuseums;}

public String getAnschriftMuseums() {
    return anschriftMuseums;}

public void setAnschriftMuseums(String anschriftMuseums) {
    this.anschriftMuseums = anschriftMuseums;}

public int getHoehe() {
    return hoehe;}

public void setHoehe(int hoehe) {
    this.hoehe = hoehe;}

public int getBreite() {
    return breite;}

public void setBreite(int breite) {
    this.breite = breite;
}

public boolean getWirdAusgestellt() {
    return wirdAusgestellt;}

public void setWirdAusgestellt(boolean wirdAusgestellt) {
    this.wirdAusgestellt = wirdAusgestellt;
}

public Raum getInRaum() {
    return inRaum;}

public void setinRaum(Raum inRaum) {
    this.inRaum = inRaum;
}

    /**
 * Representiert die Klasse als String
 */
    public String toString() {
        return "laufendeNummer=" + laufendeNummer +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", kuenstlername='" + kuenstlername + '\'' +
                ", jahresangabe=" + jahresangabe +
                ", thema='" + thema + '\'' +
                ", attraktivitaet=" + attraktivitaet +
                ", kosten=" + kosten +
                ", nameMuseums='" + nameMuseums + '\'' +
                ", anschriftMuseums='" + anschriftMuseums + '\'' +
                ", hoehe=" + hoehe +
                ", breite=" + breite +
                '}';
    }
    
    /**
 * Zuordnung des Kunstwerks zu einem Raum in der Ausstellung aufheben (Zurücksetzen der zugehörigen Attribute)
 */
    public void clearZuordnung()
    {
        wirdAusgestellt = false;
        inRaum = null; 
    }
    

    }

