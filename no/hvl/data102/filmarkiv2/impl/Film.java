package no.hvl.data102.filmarkiv2.impl;
public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int lanseringsAar;
    private Sjanger sjanger;
    private String filmskap;


    

    public Film(int filmnr, String produsent, String tittel, int lanseringsAar, Sjanger sjanger, String filmskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lanseringsAar = lanseringsAar;
        this.sjanger = sjanger;
        this.filmskap = filmskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLanseringsAar() {
        return lanseringsAar;
    }

    public void setLanseringsAar(int lanseringsAar) {
        this.lanseringsAar = lanseringsAar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmskap() {
        return filmskap;
    }

    public void setFilmskap(String filmskap) {
        this.filmskap = filmskap;
    }

    @Override
    public String toString() {
        return "Film filmnr: " +  filmnr + " Produsent: " + produsent + " Tittel: " + tittel + " Lanseringsår: " + lanseringsAar + " Sjanger: " + sjanger + " Filmskap: " + filmskap;
    }

    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + filmnr;
        result = prime * result + ((produsent == null) ? 0 : produsent.hashCode());
        result = prime * result + ((tittel == null) ? 0 : tittel.hashCode());
        result = prime * result + lanseringsAar;
        result = prime * result + ((sjanger == null) ? 0 : sjanger.hashCode());
        result = prime * result + ((filmskap == null) ? 0 : filmskap.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (filmnr != other.filmnr)
            return false;
        if (produsent == null) {
            if (other.produsent != null)
                return false;
        } else if (!produsent.equals(other.produsent))
            return false;
        if (tittel == null) {
            if (other.tittel != null)
                return false;
        } else if (!tittel.equals(other.tittel))
            return false;
        if (lanseringsAar != other.lanseringsAar)
            return false;
        if (sjanger != other.sjanger)
            return false;
        if (filmskap == null) {
            if (other.filmskap != null)
                return false;
        } else if (!filmskap.equals(other.filmskap))
            return false;
        return true; 
    }
}
