package no.hvl.data102.filmarkiv2.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

    public Film lesFilm(){

        int filmnr = -1;
boolean validInput = false;
        while (!validInput) {
            try {
                filmnr = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Filmnr: "));
                validInput = true; 
            } catch (NumberFormatException e) {
               
                javax.swing.JOptionPane.showMessageDialog(null, "Ugyldig filmnr. Prøv igjen.");
            }
        }
    String produsent = javax.swing.JOptionPane.showInputDialog("Produsent: ");
    String tittel = javax.swing.JOptionPane.showInputDialog("Tittel: ");
    int lanseringsAar = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Lanseringsår: "));
    String[] sjangerValg = new String[Sjanger.values().length];
    for (int i = 0; i < Sjanger.values().length; i++) {
        sjangerValg[i] = Sjanger.values()[i].name();
    }

    String sjanger = (String) javax.swing.JOptionPane.showInputDialog(
        null,
        "Velg sjanger:",
        "Sjanger",
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null,
        sjangerValg,
        sjangerValg[0]
    );
    String filmskap = javax.swing.JOptionPane.showInputDialog("Filmskap: ");
    return new Film(filmnr, produsent, tittel, lanseringsAar, Sjanger.valueOf(sjanger), filmskap);
    }

    public void skrivUtFilm(Film film) {
    javax.swing.JOptionPane.showMessageDialog(null, film.toString());
    }
   
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
    StringBuilder sb = new StringBuilder();
    sb.append("Filmer med delstrengen " + delstreng + " i tittelen:\n");
    for (Film film : arkiv.soekTittel(delstreng)) {
        if (film != null && film.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
            sb.append(film.toString() + "\n");
        }
    }
    javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
}
  
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        StringBuilder sb = new StringBuilder();
        sb.append("Filmer med delstrengen " + delstreng + " i produsent:\n");
        for (Film film : arkiv.soekTittel(delstreng)) {
            if (film != null && film.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                sb.append(film.toString() + "\n");
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        StringBuilder sb = new StringBuilder();
        sb.append("Totalt antall filmer: " + arkiv.antall() + "\n");

        for(Sjanger sjanger : Sjanger.values()) {
            sb.append(sjanger + ": " + arkiv.antallSjanger(sjanger) + "\n"); 
        }

        javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
        

    }


    }

