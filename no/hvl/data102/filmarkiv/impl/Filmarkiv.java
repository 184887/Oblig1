//Todo 1: Implementere trimme metoder for å fjerne whitespace fra input
package no.hvl.data102.filmarkiv.impl;
public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    public Filmarkiv() {
        filmer = new Film[100];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for(Film film : filmer) {
            if(film.getFilmnr() == nr) {
                return film;
            } 
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        
        if (antall < filmer.length && soekTittel(nyFilm.getTittel()) == null) {
            filmer[antall] = nyFilm;
            antall++;
        } else{
            filmer = utvid();
            filmer[antall] = nyFilm;
            antall++;
        }
        
    }

    @Override
    public boolean slettFilm(int filmnr) {
        int i = 0; 
        for(Film film : filmer) {
            if(film.getFilmnr() == filmnr) {
                filmer[i] = null;
                return true;
            }
            i++;
        }

        return false; 
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        for(Film film : filmer) {
            if(film.getTittel().contains(delstreng)) {
                return new Film[]{film};
            }
        }

        return null;

    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        for(Film film : filmer) {
            if(film.getFilmskap().contains(delstreng)) {
                return new Film[]{film};
            }
        }

        return null;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int i = 0;
        for(Film film : filmer) {
            if(film.getSjanger().equals(sjanger)) {
                i++;
            }
        }
        return i;
    }

    @Override
    public int antall() {
        return antall;
    }

    public Film[] utvid(){
        Film[] nyFilmer = new Film[filmer.length * 2];
        for(int i = 0; i < filmer.length; i++) {
            nyFilmer[i] = filmer[i];
        }
        return nyFilmer;
    }
    }

    
