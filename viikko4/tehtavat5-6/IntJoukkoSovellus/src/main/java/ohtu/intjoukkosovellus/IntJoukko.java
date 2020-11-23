package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,       // aloitustalukon koko
            TAULUKON_OLETUSINKREMENTTI = 5;         // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int taulukonInkrementti;                // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;                           // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;                       // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustaLukujono(KAPASITEETTI);
        alustaOlioMuuttujat(TAULUKON_OLETUSINKREMENTTI);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaLukujono(KAPASITEETTI);
        alustaOlioMuuttujat(TAULUKON_OLETUSINKREMENTTI);

    }

    public IntJoukko(int kapasiteetti, int taulukonInkrementti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (taulukonInkrementti < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        alustaLukujono(kapasiteetti);
        alustaOlioMuuttujat(taulukonInkrementti);

    }

    public boolean lisaa(int luku) {
        if (!kuuluuJoukkoon(luku)) {
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % alkiot.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = etsiLuku(luku);

        if (indeksi != -1) {
            alkiot[indeksi] = 0;
            siirraAlkiotAskeleenVasemmalle(indeksi);
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int alkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuloste += alkiot[i];
            if (i < alkioidenLkm - 1) {
                tuloste += ", ";
            }
        }
        tuloste += "}";
        return tuloste;

    }

    public int[] toIntArray() {
        int[] uusi = new int[alkioidenLkm];
        for (int i = 0; i < uusi.length; i++) {
            uusi[i] = alkiot[i];
        }
        return uusi;
    }

    public static IntJoukko yhdiste(IntJoukko joukkoA, IntJoukko joukkoB) {
        IntJoukko yhdiste = new IntJoukko();
        for (int i = 0; i < joukkoA.alkioidenLkm; i++) {
            yhdiste.lisaa(joukkoA.alkiot[i]);
            yhdiste.lisaa(joukkoB.alkiot[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko joukkoA, IntJoukko joukkoB) {
        IntJoukko leikkaus = new IntJoukko();
        for (int i = 0; i < joukkoA.alkioidenLkm; i++) {
            for (int j = 0; j < joukkoB.alkioidenLkm; j++) {
                if (joukkoA.alkiot[i] == joukkoB.alkiot[j]) {
                    leikkaus.lisaa(joukkoB.alkiot[j]);
                }
            }
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko joukkoA, IntJoukko joukkoB) {
        IntJoukko erotus = new IntJoukko();
        for (int i = 0; i < joukkoA.alkioidenLkm; i++) {
            erotus.lisaa(joukkoA.alkiot[i]);
        }
        for (int i = 0; i < joukkoB.alkioidenLkm; i++) {
            erotus.poista(joukkoB.alkiot[i]);
        }
        return erotus;
    }

    // Apumetodeja
    private void alustaLukujono(int kapasiteetti) {
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
    }

    private void alustaOlioMuuttujat(int kasvatuskoko) {
        alkioidenLkm = 0;
        this.taulukonInkrementti = kasvatuskoko;
    }

    private void kasvataTaulukkoa() {
        int[] uusi = new int[alkioidenLkm + taulukonInkrementti];
        kopioiTaulukko(alkiot, uusi);
        alkiot = uusi;

    }

    private int etsiLuku(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return i; //siis luku löytyy tuosta kohdasta :D
            }
        }
        return -1;
    }

    private void siirraAlkiotAskeleenVasemmalle(int indeksista) {
        for (int j = indeksista; j < alkioidenLkm - 1; j++) {
            alkiot[j] = alkiot[j + 1];
        }
    }

}
