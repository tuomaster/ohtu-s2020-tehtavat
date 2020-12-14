package ohtu.kivipaperisakset;

// "Muistava tekoäly"
import java.util.HashMap;
import java.util.Map;

public class TekoalyParannettu {

    private String[] muisti;
    private int vapaaMuistiIndeksi;

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    public void asetaSiirto(String siirto) {
        // jos muisti täyttyy, unohdetaan viimeinen alkio
        if (vapaaMuistiIndeksi == muisti.length) {
            siirraAlkoitaVasemmalle();
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    public String annaSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            return "k";
        }

        Map<String, Integer> siirrot = laskeSiirrot();
        int k = siirrot.getOrDefault("k", 0);
        int p = siirrot.getOrDefault("p", 0);
        int s = siirrot.getOrDefault("s", 0);

        // Tehdään siirron valinta esimerkiksi seuraavasti;
        // - jos kiviä eniten, annetaan aina paperi
        // - jos papereita eniten, annetaan aina sakset
        // muulloin annetaan aina kivi
        if (k > p && k > s) {
            return "p";
        } else if (p > k && p > s) {
            return "s";
        } else {
            return "k";
        }

        // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
        // Johdatus Tekoälyyn kurssilla!
    }

    private void siirraAlkoitaVasemmalle() {
        for (int i = 1; i < muisti.length; i++) {
            muisti[i - 1] = muisti[i];
        }

        vapaaMuistiIndeksi--;
    }

    private HashMap<String, Integer> laskeSiirrot() {
        HashMap<String, Integer> siirrot = new HashMap<>();
        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];
        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (viimeisinSiirto.equals(muisti[i])) {
                String seuraava = muisti[i + 1];

                if ("k".equals(seuraava)) {
                    siirrot.put("k", siirrot.getOrDefault("k", 0) + 1);
                } else if ("p".equals(seuraava)) {
                    siirrot.put("p", siirrot.getOrDefault("p", 0) + 1);
                } else {
                    siirrot.put("s", siirrot.getOrDefault("s", 0) + 1);
                }
            }
        }
        
        return siirrot;
    }
}
