package no.hvl.data102.filmarkiv2.klient;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;



import javax.swing.JOptionPane;

public class Meny {

    private Filmarkiv filmarkiv;
    private Tekstgrensesnitt tekstgr;

    public Meny(Filmarkiv filmarkiv) {
        this.filmarkiv = filmarkiv;
        this.tekstgr = new Tekstgrensesnitt();
    }

    public void start() {
        filmarkiv.leggTilFilm(new Film(1, "produsent1", "tittel1", 2000, Sjanger.ACTION, "filmskap1"));
        filmarkiv.leggTilFilm(new Film(2, "produsent2", "tittel2", 2001, Sjanger.DRAMA, "filmskap2"));
        filmarkiv.leggTilFilm(new Film(3, "produsent3", "tittel3", 2002, Sjanger.DRAMA, "filmskap3"));
        filmarkiv.leggTilFilm(new Film(4, "produsent4", "tittel4", 2003, Sjanger.HORROR, "filmskap4"));
        filmarkiv.leggTilFilm(new Film(5, "test", "test", 2004, Sjanger.MUSICAL, "test"));



        String[] valg = {"Skriv ut alle", "Legg til film", "Slett film", "Søk etter tittel", "Søk etter produsent", "Skriv ut statistikk", "Avslutt"};
        String valgString = (String) JOptionPane.showInputDialog(
            null,
            "Velg en handling:",
            "Meny",
            JOptionPane.QUESTION_MESSAGE,
            null,
            valg,
            valg[0]
        );

        while (true) {
            switch (valgString) {
                case "Skriv ut alle":
                    filmarkiv.skrivUtAlleFilmer(filmarkiv);
                    break;
                case "Legg til film":
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    javax.swing.JOptionPane.showMessageDialog(null, "Film lagt til.");
                    break;
                case "Slett film":
                    int filmnr = Integer.parseInt(JOptionPane.showInputDialog("Filmnr: "));
                    filmarkiv.slettFilm(filmnr);
                    break;
                case "Søk etter tittel":
                    String delstreng = JOptionPane.showInputDialog("Skriv inn delstreng: ");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstreng);
                    break;
                case "Søk etter produsent":
                    String delstrengProdusent = JOptionPane.showInputDialog("Skriv inn delstreng: ");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, delstrengProdusent);
                    break;
                case "Skriv ut statistikk":
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case "Avslutt":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Ugyldig valg. Vennligst prøv igjen.");
                    break;
            }

            valgString = (String) JOptionPane.showInputDialog(
                null,
                "Velg en handling:",
                "Meny",
                JOptionPane.QUESTION_MESSAGE,
                null,
                valg,
                valg[0]
            );
        }
    }

    public static void main(String[] args) {
        Filmarkiv filmarkiv = new Filmarkiv();
        Meny meny = new Meny(filmarkiv);
        meny.start();
    }
}
