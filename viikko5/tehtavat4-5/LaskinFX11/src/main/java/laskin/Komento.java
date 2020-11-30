package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button plus;
    protected Button miinus;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int syote;
    protected int edellinenTulos;

    public Komento(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public abstract void suorita();

    public abstract void peru();

    protected int lueSyote() {
        return lueKentanArvo(syotekentta);
    }

    protected int lueTuloskentta() {
        return lueKentanArvo(tuloskentta);
    }

    protected int lueKentanArvo(TextField kentta) {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(kentta.getText());
        } catch (Exception e) {

        }

        return arvo;
    }

    protected void paivitaKentat() {
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    protected void paivitaNapit() {
        int laskunTulos = sovellus.tulos();

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    protected void deaktivoiUndoNappi() {
        undo.disableProperty().set(true);
    }
}
