package no.hvl.data102.filmarkiv2.test;

import no.hvl.data102.filmarkiv2.impl.Filmarkiv;
import no.hvl.data102.filmarkiv2.impl.Film;
import no.hvl.data102.filmarkiv2.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {
    private Filmarkiv filmarkiv;
    private Film film1;
    private Film film2;
    private Film film3;

    @BeforeEach
    public void setUp() {
        filmarkiv = new Filmarkiv();
        film1 = new Film(1, "produsent1", "tittel1", 2000, Sjanger.ACTION, "filmskap1");
        film2 = new Film(2, "produsent2", "tittel2", 2001, Sjanger.DRAMA, "filmskap2");
        film3 = new Film(3, "produsent3", "tittel3", 2002, Sjanger.HISTORY, "filmskap3");
    }

    

    @Test
    public void testLeggTilFilm() {
        filmarkiv.leggTilFilm(film1);
        assertEquals(film1, filmarkiv.finnFilm(1));
    }

    @Test
    public void testSlettFilm() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.slettFilm(1);
        assertNull(filmarkiv.finnFilm(1));
    }

    @Test
    public void testSoekTittel() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        assertEquals(film1, filmarkiv.soekTittel("tittel1")[0]);
        assertEquals(film2, filmarkiv.soekTittel("tittel2")[0]);
        assertEquals(film3, filmarkiv.soekTittel("tittel3")[0]);
    }


    @Test
    public void testSoekProdusent() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        assertEquals(film1, filmarkiv.soekProdusent("produsent1")[0]);
        assertEquals(film2, filmarkiv.soekProdusent("produsent2")[0]);
        assertEquals(film3, filmarkiv.soekProdusent("produsent3")[0]);
    }

    @Test
    public void testAntall() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        assertEquals(3, filmarkiv.antall());
    }

    @Test
    public void testAntallSjanger() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        assertEquals(1, filmarkiv.antallSjanger(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antallSjanger(Sjanger.DRAMA));
        assertEquals(1, filmarkiv.antallSjanger(Sjanger.HISTORY));
    }

 

    }