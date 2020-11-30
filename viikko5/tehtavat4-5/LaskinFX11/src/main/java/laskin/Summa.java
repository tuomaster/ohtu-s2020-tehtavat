package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        syote = lueSyote();
        sovellus.plus(syote);
        paivitaKentat();
        paivitaNapit();
    }
    
    @Override
    public void peru() {
        sovellus.miinus(syote);
        paivitaKentat();
        paivitaNapit();
        deaktivoiUndoNappi();
    }

}
