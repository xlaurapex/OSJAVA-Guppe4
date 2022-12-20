import java.util.ArrayList;

/**
 * Die Kunstwerkverwaltung enthält die jeweils verfügbaren Kunstwerke der anderen Museen, welche für Ausstellungen genutzt werden können. Die Klasse 
 * „Ausstellungsverwaltung“ greift auf diese verfügbaren Kunstwerke zu, um die entsprechenden Kunstwerke für eine Ausstellung einplanen zu können.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kunstwerkverwaltung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Kunstwerk> kunstwerke;
    private Kunstwerk k;
    Datei d;
    /**
     * Konstruktor für Objekte der Klasse Kunstwerkverwaltung
     */
    public Kunstwerkverwaltung()
    {
        // Instanzvariable initialisieren
        kunstwerke = new ArrayList<Kunstwerk>();
    }

    /**
     * Es braucht eine Methode, um die gesamte Liste der Kunstwerke zurückzugeben
     * 
     * @return es wird ein Objekt Kunstwerk zurückgegeben
     */
    public ArrayList<Kunstwerk> getKunstwerke()
    {
         // tragen Sie hier den Code ein
        return kunstwerke;
    }
}
