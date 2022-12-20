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
    }

    /**
     * Lade eine Liste der Kunstwerken aus einer CSV Datei in ListeKunstwerk
     *
     * @param pfad ist der Pfad zur CSV Datei
     */
    public void ladeKunstwerke(String pfad) {
    }

    /**
     * Gibt die Liste der Kunstwerken zurück
     *
     * @return List<Kunstwerk>
     */
    public ArrayList<Kunstwerk> getKunstwerke() {
        return ListeKunstwerk;
    }
}
