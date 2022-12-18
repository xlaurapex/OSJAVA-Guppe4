
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
    private int x;
    int preis;
    int wert;
    /**
     * Konstruktor für Objekte der Klasse Kunstwerke
     */
    public Kunstwerk()
    {
        // Instanzvariable initialisieren
        x = 0;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int beispielMethode(int y)
    {
        // tragen Sie hier den Code ein
        return x + y;
    }
}
