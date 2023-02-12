
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
    String anschriftMuseums, int hoehe, int breite) {
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
        //this.wirdAusgestellt = wirdAusgestellt;
        this.inRaum = null;
    }

    /**
     * Da das Attribut laufendeNummer als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */

    public int getLaufendeNummer() {
        return laufendeNummer;}

    /**
     * Da das Attribut laufendeNummer als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setLaufendeNummer(int laufendeNummer) {
        this.laufendeNummer = laufendeNummer;}

    /**
     * Da das Attribut Bezeichnung als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */

    public String getBezeichnung() {
        return bezeichnung;}

    /**
     * Da das Attribut Bezeichnung als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;}

    /**
     * Da das Attribut Kuenstlername als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public String getKuenstlername() {
        return kuenstlername;}

    /**
     * Da das Attribut Kuenstlername als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setKuenstlername(String kuenstlername) {
        this.kuenstlername = kuenstlername;}

    /**
     * Da das Attribut Jahresangabe als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public String getJahresangabe() {
        return jahresangabe;}

    /**
     * Da das Attribut Jahresangabe als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setJahresangabe(String jahresangabe) {
        this.jahresangabe = jahresangabe;}

    /**
     * Da das Attribut Thema als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public String getThema() {
        return thema;}

    /**
     * Da das Attribut Thema als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setThema(String thema) {
        this.thema = thema;}

    /**
     * Da das Attribut Attraktivitaet als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public double getAttraktivitaet() {
        return attraktivitaet;}

    /**
     * Da das Attribut Attraktivitaet als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setAttraktivitaet(double attraktivitaet) {
        this.attraktivitaet = attraktivitaet;}

    /**
     * Da das Attribut Kosten als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getKosten() {
        return kosten;}

    /**
     * Da das Attribut Kosten als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setKosten(int kosten) {
        this.kosten = kosten;}

    /**
     * Da das Attribut NameMuseums als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public String getNameMuseums() {
        return nameMuseums;}

    /**
     * Da das Attribut NameMuseums als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setNameMuseums(String nameMuseums) {
        this.nameMuseums = nameMuseums;}

    /**
     * Da das Attribut AnschriftMuseums als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public String getAnschriftMuseums() {
        return anschriftMuseums;}

    /**
     * Da das Attribut AnschriftMuseums als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setAnschriftMuseums(String anschriftMuseums) {
        this.anschriftMuseums = anschriftMuseums;}

    /**
     * Da das Attribut Hoehe als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getHoehe() {
        return hoehe;}

    /**
     * Da das Attribut Hoehe als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;}

    /**
     * Da das Attribut Breite als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public int getBreite() {
        return breite;}

    /**
     * Da das Attribut Breite als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setBreite(int breite) {
        this.breite = breite;
    }

    /**
     * Da das Attribut WirdAusgestellt als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public boolean getWirdAusgestellt() {
        return wirdAusgestellt;}

    /**
     * Da das Attribut WirdAusgestellt als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
    
    public void setWirdAusgestellt(boolean wirdAusgestellt) {
        this.wirdAusgestellt = wirdAusgestellt;
    }

    /**
     * Da das Attribut InRaum als private deklariert wurde, brauchen wir Getter Methode, um die Objektvariable abzurufen
     */
    
    public Raum getInRaum() {
        return inRaum;}


    /**
     * Da das Attribut InRaum als private deklariert wurde, brauchen wir Setter Methode, die die Veränderung der Objektvariablen ermöglicht
     */
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
