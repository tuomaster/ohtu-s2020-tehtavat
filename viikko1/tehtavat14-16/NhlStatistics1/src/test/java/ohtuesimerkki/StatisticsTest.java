package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuomaste
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Koivu", "MTL", 15, 61));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Barkov", "FLA", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            players.add(new Player("Jagr", "PIT", 44, 56));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void statisticsPalauttaaOikeanPelaajan() {
        assertEquals("Koivu", stats.search("Koivu").getName());
    }
    
    @Test
    public void statisticPalauttaaNullKunPelaajaaEiLoydy() {
        assertEquals(null, stats.search("Puljujarvi"));
    }
    
    @Test
    public void statisticsLoytaaKaikkiSamanJoukkueenPelaajat() {
        /*
        List<Player> joukkueenPelaajat = stats.team("PIT");
        for(Player p:joukkueenPelaajat) {
            assertEquals("PIT", p.getTeam());
        }
        */
        assertEquals(2, stats.team("PIT").size());
    }
    
    @Test
    public void statisticsPalauttaaKovimmatPistemiehetOikein() {
        List<Player> pistemiehet = stats.topScorers(2);
        assertEquals("Gretzky", pistemiehet.get(0).getName());
        assertEquals("Jagr", pistemiehet.get(1).getName());
        
    }

    //
    // @Test
    // public void hello() {}
}
