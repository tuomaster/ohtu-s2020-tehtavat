
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Nollaa extends Komento{
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenTuos = lueTuloskentta();
        sovellus.nollaa();
        paivitaKentat();
        paivitaNapit();
    }

    @Override
    public void peru() {
        
    }
    
}
