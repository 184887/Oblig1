package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
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
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antall(Sjanger.DRAMA));
        assertEquals(1, filmarkiv.antall(Sjanger.HISTORY));
    }

    @Test
    public void testAntallSjangerNull() {
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        assertEquals(0, filmarkiv.antall(Sjanger.HORROR));
    }

    @Test
    public void testAntallSjangerFlere() {
        Film film4 = new Film(4, "produsent4", "tittel4", 2003, Sjanger.ACTION, "filmskap4");
        Film film5 = new Film(5, "produsent5", "tittel5", 2004, Sjanger.ACTION, "filmskap5");
        Film film6 = new Film(6, "produsent6", "tittel6", 2005, Sjanger.ACTION, "filmskap6");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        assertEquals(4, filmarkiv.antall(Sjanger.ACTION));
    }

    @Test
    public void testAntallSjangerFlereNull() {
        Film film4 = new Film(4, "produsent4", "tittel4", 2003, Sjanger.ACTION, "filmskap4");
        Film film5 = new Film(5, "produsent5", "tittel5", 2004, Sjanger.ACTION, "filmskap5");
        Film film6 = new Film(6, "produsent6", "tittel6", 2005, Sjanger.ACTION, "filmskap6");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        assertEquals(0, filmarkiv.antall(Sjanger.HORROR));
    }

    @Test
    public void testAntallSjangerFlereFlere() {
        Film film4 = new Film(4, "produsent4", "tittel4", 2003, Sjanger.ACTION, "filmskap4");
        Film film5 = new Film(5, "produsent5", "tittel5", 2004, Sjanger.ACTION, "filmskap5");
        Film film6 = new Film(6, "produsent6", "tittel6", 2005, Sjanger.ACTION, "filmskap6");
        Film film7 = new Film(7, "produsent7", "tittel7", 2006, Sjanger.ACTION, "filmskap7");
        Film film8 = new Film(8, "produsent8", "tittel8", 2007, Sjanger.ACTION, "filmskap8");
        Film film9 = new Film(9, "produsent9", "tittel9", 2008, Sjanger.ACTION, "filmskap9");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        filmarkiv.leggTilFilm(film7);
        filmarkiv.leggTilFilm(film8);
        filmarkiv.leggTilFilm(film9);
        assertEquals(7, filmarkiv.antall(Sjanger.ACTION));
    }

    @Test
    public void testAntallSjangerFlereFlereNull() {
        Film film4 = new Film(4, "produsent4", "tittel4", 2003, Sjanger.ACTION, "filmskap4");
        Film film5 = new Film(5, "produsent5", "tittel5", 2004, Sjanger.ACTION, "filmskap5");
        Film film6 = new Film(6, "produsent6", "tittel6", 2005, Sjanger.ACTION, "filmskap6");
        Film film7 = new Film(7, "produsent7", "tittel7", 2006, Sjanger.ACTION, "filmskap7");
        Film film8 = new Film(8, "produsent8", "tittel8", 2007, Sjanger.ACTION, "filmskap8");
        Film film9 = new Film(9, "produsent9", "tittel9", 2008, Sjanger.ACTION, "filmskap9");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        filmarkiv.leggTilFilm(film7);
        filmarkiv.leggTilFilm(film8);
        filmarkiv.leggTilFilm(film9);
        assertEquals(0, filmarkiv.antall(Sjanger.HORROR));
    }

    @Test
    public void testAntallSjangerFlereFlereFlere() {
        Film film4 = new Film(4, "produsent4", "tittel4", 2003, Sjanger.ACTION, "filmskap4");
        Film film5 = new Film(5, "produsent5", "tittel5", 2004, Sjanger.ACTION, "filmskap5");
        Film film6 = new Film(6, "produsent6", "tittel6", 2005, Sjanger.ACTION, "filmskap6");
        Film film7 = new Film(7, "produsent7", "tittel7", 2006, Sjanger.ACTION, "filmskap7");
        Film film8 = new Film(8, "produsent8", "tittel8", 2007, Sjanger.ACTION, "filmskap8");
        Film film9 = new Film(9, "produsent9", "tittel9", 2008, Sjanger.ACTION, "filmskap9");
        Film film10 = new Film(10, "produsent10", "tittel10", 2009, Sjanger.ACTION, "filmskap10");
        Film film11 = new Film(11, "produsent11", "tittel11", 2010, Sjanger.ACTION, "filmskap11");
        Film film12 = new Film(12, "produsent12", "tittel12", 2011, Sjanger.ACTION, "filmskap12");
        Film film13 = new Film(13, "produsent13", "tittel13", 2012, Sjanger.ACTION, "filmskap13");
        Film film14 = new Film(14, "produsent14", "tittel14", 2013, Sjanger.ACTION, "filmskap14");
        Film film15 = new Film(15, "produsent15", "tittel15", 2014, Sjanger.ACTION, "filmskap15");
        Film film16 = new Film(16, "produsent16", "tittel16", 2015, Sjanger.ACTION, "filmskap16");
        Film film17 = new Film(17, "produsent17", "tittel17", 2016, Sjanger.ACTION, "filmskap17");

            filmarkiv.leggTilFilm(film4);
            filmarkiv.leggTilFilm(film5);
            filmarkiv.leggTilFilm(film6);
            filmarkiv.leggTilFilm(film7);
            filmarkiv.leggTilFilm(film8);
            filmarkiv.leggTilFilm(film9);
            filmarkiv.leggTilFilm(film10);
            filmarkiv.leggTilFilm(film11);
            filmarkiv.leggTilFilm(film12);
            filmarkiv.leggTilFilm(film13);
            filmarkiv.leggTilFilm(film14);
            filmarkiv.leggTilFilm(film15);
            filmarkiv.leggTilFilm(film16);
            filmarkiv.leggTilFilm(film17);
            assertEquals(17, filmarkiv.antall(Sjanger.ACTION));
        }
    }