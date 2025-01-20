import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import no.hvl.data102.filmarkiv.Film;
import no.hvl.data102.filmarkiv.Sjanger;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivTest {

    @Test
    public void testFinnFilm() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(film, filmarkiv.finnFilm(1));
    }   

    @Test
    public void testLeggTilFilm() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(film, filmarkiv.finnFilm(1));
    }

    @Test

    public void testSlettFilm() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertTrue(filmarkiv.slettFilm(1));
    }

    @Test

    public void testSoekTittel() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(film, filmarkiv.soekTittel("tittel")[0]);
    }

    @Test

    public void testSoekProdusent() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(film, filmarkiv.soekProdusent("produsent")[0]);
    }

    @Test

    public void testAntall() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION));
    }

    @Test

    public void testAntall2() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(1, filmarkiv.antall());
    }

    @Test

    public void testUtvid() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(200, filmarkiv.utvid().length);
    }

    @Test

    public void testUtvid2() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        filmarkiv.leggTilFilm(film);
        assertEquals(1, filmarkiv.utvid().length);
    }

    @Test

    public void testUtvid3() {
        FilmarkivADT filmarkiv = new Filmarkiv();
        Film film = new Film(1, "produsent", "tittel", 2021, Sjanger.ACTION, "filmskap");
        for (int i = 0; i < 200; i++) {
            filmarkiv.leggTilFilm(film);
        }
        assertEquals(400, filmarkiv.utvid().length);
    }
    
}