//Todo 1: Implementere trimme metoder for å fjerne whitespace fra input
package no.hvl.data102.filmarkiv2.impl;
import no.hvl.data102.filmarkiv.adt.*;
public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall = 0;

    @Override
    public int antall() {
        return antall;
    }

    public void skrivUtAlleFilmer(Filmarkiv arkiv) {
        for (Film film : arkiv.filmer){
            if (film == null) {
                break;
            }
            System.out.println(film.getFilmnr() + " " + film.getProdusent() + " " + film.getTittel() + " " + film.getLanseringsAar() + " " + film.getSjanger() + " " + film.getFilmskap());
        }

    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
        nytab[i] = tab[i];
        i++;
        }
        return nytab;
        }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvid();
        }
        filmer[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getFilmnr() == filmnr) {
                filmer[i] = filmer[antall - 1];
                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        trimTab(filmer, antall);
        return false;
    }

    @Override
    public Film finnFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getFilmnr() == filmnr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public Film[] utvid() {
        Film[] nyFilmer = new Film[filmer.length * 2];
        for (int i = 0; i < filmer.length; i++) {
            nyFilmer[i] = filmer[i];
        }
        trimTab(nyFilmer, antall);
        filmer = nyFilmer;        

        return filmer;
        
    }

    public Filmarkiv() {
        filmer = new Film[5];
        antall = 0;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        if (delstreng == null) {
            throw new IllegalArgumentException("Ingen treff");
        }

        
        int antallTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getTittel() != null && 
                filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                antallTreff++;
            }
        }

        
    
    
        Film[] resultat = new Film[antallTreff];
        int ind = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getTittel() != null && 
                filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat[ind] = filmer[i];
                ind++;
            }
        }
        return resultat;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        if (delstreng == null) {
            return new Film[0];
        }
        
        int antallTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getFilmskap() != null && 
                filmer[i].getFilmskap().toLowerCase().contains(delstreng.toLowerCase())) {
                antallTreff++;
            }
        }
        
 
        Film[] resultat = new Film[antallTreff];
        int ind = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getFilmskap() != null && 
                filmer[i].getFilmskap().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat[ind] = filmer[i];
                ind++;
            }
        }
        return resultat;
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        if (sjanger == null) {
            return 0;
        }
        
        int antall = 0;
        for (int i = 0; i < this.antall; i++) {
            if (filmer[i] != null && sjanger.equals(filmer[i].getSjanger())) {
                antall++;
            }
        }
        return antall;
    }  

    public int antall(Sjanger sjanger) {
        int count = 0;
        for (Film film : filmer) {
            if (film.getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void leggTilFilm(no.hvl.data102.filmarkiv.impl.Film nyFilm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leggTilFilm'");
    }

    @Override
    public int antallSjanger(no.hvl.data102.filmarkiv.impl.Sjanger sjanger) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'antallSjanger'");
    }
}
