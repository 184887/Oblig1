package no.hvl.data102.filmarkiv2.impl;
import no.hvl.data102.filmarkiv2.adt.*;


public class Filmarkiv implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    @Override
    public Film finnFilm(int nr) {       
        LinearNode<Film> denne = start;
        Film film = null;
        while (denne != null) {
            if (denne.getData().getFilmnr() == nr) {
                film = denne.getData();
                break;
            }
            denne = denne.getNeste();
        }
        return film;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.setNeste(start);
        start = nyNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> denne = start;
        LinearNode<Film> forrige = null;
        boolean slettet = false;
        while (denne != null) {
            if (denne.getData().getFilmnr() == filmnr) {
                if (forrige == null) {
                    start = denne.getNeste();
                } else {
                    forrige.setNeste(denne.getNeste());
                }
                antall--;
                slettet = true;
                break;
            }
            forrige = denne;
            denne = denne.getNeste();
        }
        return slettet;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        if (delstreng == null) {
            throw new IllegalArgumentException("Ingen treff");
        }
        LinearNode<Film> denne = start;
        Film[] filmer = new Film[antall];
        int antallFunnet = 0;
        while (denne != null) {
            if (denne.getData().getTittel() != null && 
                denne.getData().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[antallFunnet++] = denne.getData();
            }
            denne = denne.getNeste();
        }
        return trimTab(filmer, antallFunnet);
    }
    

    @Override
    public Film[] soekProdusent(String delstreng) {
        if (delstreng == null) {
            throw new IllegalArgumentException("Ingen treff");
        }
        LinearNode<Film> denne = start;
        Film[] filmer = new Film[antall];
        int antallFunnet = 0;
        while (denne != null) {
            if (denne.getData().getProdusent() != null && 
                denne.getData().getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[antallFunnet++] = denne.getData();
            }
            denne = denne.getNeste();
        }
        return trimTab(filmer, antallFunnet);
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> denne = start;
        if (start == null) {
            return 0;
        }
        while (denne != null) {
            if (denne.getData().getSjanger() == sjanger) {
                count++;
            }
            denne = denne.getNeste();
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
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

   
}