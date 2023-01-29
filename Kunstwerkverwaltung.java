import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Die Kunstwerkverwaltung enthält die jeweils verfügbaren Kunstwerke der anderen Museen, welche für Ausstellungen genutzt werden können. Die Klasse 
 * „Ausstellungsverwaltung“ greift auf diese verfügbaren Kunstwerke zu, um die entsprechenden Kunstwerke für eine Ausstellung einplanen zu können.
 * 
 * @author Darya Bialova
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kunstwerkverwaltung {

    private ArrayList<Kunstwerk> ListeKunstwerk;
    private String[] KunstwerkTyp = {"Bild", "Kunstgegenstand", "Kunstinstallation"};


    public Kunstwerkverwaltung(ArrayList<Kunstwerk> ListeKunstwerk) {
        this.ListeKunstwerk = ListeKunstwerk;
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
     * Gibt ein Kunstwerk basierend auf LaufendeNummer zurück
     * 
     * @param  id    die ID (lfd. Nummer) muss eingegeben werden
     * @return es wird ein Objekt Kunstwerk zurückgegeben
     */
    public Kunstwerk getKunstwerkByID(int id)
    {
        for(Kunstwerk k : ListeKunstwerk) {
            if(k.getLaufendeNummer() == (id)) {
                return k;
            }}

        return null;
    }

    /**
     * Gibt eine Liste von freien (nicht ausgestellten) Kunstwerke zurück
     * 
     * @return es wird eine ArrayList von Kunstwerke zurückgegeben
     */
    public ArrayList<Kunstwerk> getFreiesKunstwerk()
    {
        ArrayList<Kunstwerk> filteredList = (ArrayList<Kunstwerk>) ListeKunstwerk.stream().filter(k -> k.getWirdAusgestellt() == false).collect(Collectors.toList());

        return filteredList;
    }

        /**
     * Gibt das attraktivste Kunstwerk zurück
     * 
     * @param  listKW ArrayList von Kunstwerke
     * @return das attraktivste Kunstwerk
     */
    public Kunstwerk getAttraktivsteKunstwerk(ArrayList<Kunstwerk> listKW)
    {
        Collections.sort(listKW, Comparator.comparing(Kunstwerk::getAttraktivitaet));
      
        return listKW.get(listKW.size()-1);
    }

         /**
     * Gibt das attraktivste Kunstwerk von bestimmten Typ zurück
     * 
     * @param  listKW     ArrayList von Kunstwerke
     * @param  kunstTyp    Kunstwerktyp als String aus der Liste {"Bild", "Kunstgegenstand", "Kunstinstallation"}
     * @return es wird ein Objekt Kunstwerk zurückgegeben
     */
    public Kunstwerk getAttraktivsteKunstwerk(ArrayList<Kunstwerk> listKW, String kunstTyp)
    {
        if(kunstTyp != null && Arrays.asList(KunstwerkTyp).contains(kunstTyp)) {
            ArrayList<Kunstwerk> filteredListeKunstwerk = filterByKunstwerkTyp(listKW, kunstTyp);
            
            return getAttraktivsteKunstwerk(filteredListeKunstwerk);
        }
    
        return null;
    }
    
        /**
     * Filter die Kunstwerke in der Liste bei Typ.
     * 
     * @param  listKW     ArrayList von Kunstwerke
     * @param  kunstTyp    Kunstwerktyp als String aus der Liste {"Bild", "Kunstgegenstand", "Kunstinstallation"}
     * @return es wird ein Objekt Kunstwerk zurückgegeben
     */
    public ArrayList<Kunstwerk> filterByKunstwerkTyp(ArrayList<Kunstwerk> listKW, String kunstTyp) {

        if(kunstTyp != null && Arrays.asList(KunstwerkTyp).contains(kunstTyp)) {
        ArrayList<Kunstwerk> filteredList = (ArrayList<Kunstwerk>) listKW.stream().filter(k -> k.getClass().getSimpleName() == kunstTyp).collect(Collectors.toList());
        return filteredList;
        };

        return null;
    }


}

