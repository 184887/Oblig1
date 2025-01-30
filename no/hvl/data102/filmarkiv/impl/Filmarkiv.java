package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.*;
public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall; 

    public Filmarkiv(int film){
        this.filmer = new Film[film]; 
        antall = 0; 
    }
  
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


    private Film[] soek(String delstreng, java.util.function.Function<Film, String> getFiled ){
        if (delstreng == null) {
            throw new IllegalArgumentException("Ingen treff");
        }
        int antallTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && getFiled.apply(filmer[i]) != null && 
            getFiled.apply(filmer[i]).toLowerCase().contains(delstreng.toLowerCase())) {
                antallTreff++;
            }
        }
        Film[] resultat = new Film[antallTreff];
        int ind = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && getFiled.apply(filmer[i]) != null && 
            getFiled.apply(filmer[i]).toLowerCase().contains(delstreng.toLowerCase())) {
                resultat[ind] = filmer[i];
                ind++;
            }
        }
        return resultat;
    }
    @Override
    public Film[] soekTittel(String delstreng) {
        return soek(delstreng, Film::getTittel);
    }
     

    @Override
    public Film[] soekProdusent(String delstreng) {
        return soek(delstreng, Film::getProdusent);
    }
    

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int count = 0;
        for (Film film : filmer) {
            if (film != null && film.getSjanger().equals(sjanger)) {
                count++;
            }
 
    }  
    return count; 
    }
}
