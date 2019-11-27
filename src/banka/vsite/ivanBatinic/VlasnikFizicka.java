package vsite.ivanBatinic;

import java.sql.Time;

public class VlasnikFizicka extends Vlasnik {

    String ime;//get,set
    String prezime;//get,set

    /**
     *
     * @param i - ime
     * @param p - prezime
     * @param o - OIB
     * @param a - adresa
     */
    VlasnikFizicka(String i, String p, String o, String a)
    {
        super(a,o); ime=i; prezime=p;
    }
    VlasnikFizicka(String i, String p, String o)
    {
        super(null,o); ime=i; prezime=p;
    }

    /**
     * Vraca ime vlasnika
     * @return String ime
     */
    public String getIme(){return ime;}

    /**
     * Postavljanje imena vlasnika
     * @param i - String ime
     */
    public void setIme(String i){ ime=i;}

    /**
     * Vraca prezime vlaasnika
     * @return String prezime
     */
    public String getPrezime(){return prezime;}

    /**
     * Postavljanje prezimena vlasnika
     * @param p - String prezime
     */
    public void setPrezime(String p){ prezime=p;}

    /**
     * Dohvat OIB-a vlasnika
     * @return String oib
     */
    public String getOib(){return  oib;}

    /**
     * Ispis podataka vlasnika
     * @return String podaci iz klase Vlasnik
     */
    @Override
    public String ispisPodataka()
    {
        return "Ime:" + ime + " Prezime:"+ prezime+ " OIB:" + oib + " Adresa:" + adresa;
    }

}
