package vsite.ivanBatinic;

public class VlasnikPravna extends Vlasnik{

    VlasnikFizicka vlasnik;
    String naziv;

    VlasnikPravna(VlasnikFizicka v, String oib, String adresa, String naziv)
    {
        super(adresa,oib); vlasnik=v; this.naziv=naziv;
    }

    public String getNaziv(){return naziv;}
    public void setNaziv(String n){ naziv=n;}
    public String getAdresa(){return adresa;}
    public void setAdresa(String a){ adresa=a;}
    public String getOib(){return  oib;}
    @Override
    public String ispisPodataka()
    {
        return "Naziv:" + naziv + " OIB:" + oib + " Adresa:" + adresa +
                "\n Vlasnik: " + vlasnik.getIme() + ", " + vlasnik.getPrezime() +
                ", OIB: " + vlasnik.getOib();
    }
}
