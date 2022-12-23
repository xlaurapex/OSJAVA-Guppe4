import java.util.ArrayList;

/**
 * Die Kunstwerkverwaltung enthält die jeweils verfügbaren Kunstwerke der anderen Museen, welche für Ausstellungen genutzt werden können. Die Klasse 
 * „Ausstellungsverwaltung“ greift auf diese verfügbaren Kunstwerke zu, um die entsprechenden Kunstwerke für eine Ausstellung einplanen zu können.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kunstwerkverwaltung {

    private ArrayList<Kunstwerk> ListeKunstwerk;

    public Kunstwerkverwaltung() {
        ListeKunstwerk = new ArrayList<Kunstwerk>();
    }

    /**
     * Gibt die Liste der Kunstwerken zurück
     *
     * @return List<Kunstwerk>
     */
    public ArrayList<Kunstwerk> getKunstwerke() {
        return ListeKunstwerk;
    }
    
    /**
     * Fügt Kunstwerk der liste hinzu
     * @param k Übergabe eines Objekts der Klasse Kunstwerk (bzw. Unterklasse)
     * 
     */
    public void addKunstwerk(Kunstwerk k) {
        ListeKunstwerk.add(k);
    }
    
        /**
     * Es braucht eine Methode, um auf ein bestimmtes Kunstwerk der Liste zugreifen zu können 
     * 
     * @param  id    die ID (lfd. Nummer) muss eingegeben werden
     * @return es wird ein Objekt Kunstwerk zurückgegeben
     */
    public Kunstwerk getKunstwerkByID(int id)
    {
        Kunstwerk r = null; 
        // tragen Sie hier den Code ein
        return r;
    }

}
