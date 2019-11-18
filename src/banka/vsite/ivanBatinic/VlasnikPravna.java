package vsite.ivanBatinic;

public class VlasnikPravna {

    Vlasnik vlasnik;
    final String oib;
    String adresa;
    String naziv;

    VlasnikPravna(Vlasnik v, String oib, String adresa, String naziv)
    {
        vlasnik=v; this.oib=oib; this.adresa=adresa; this.naziv=naziv;
    }

    public String getNaziv(){return naziv;}
    public void setNaziv(String n){ naziv=n;}
    public String getAdresa(){return adresa;}
    public void setAdresa(String a){ adresa=a;}
    public String getOib(){return  oib;}

    public String ispisPodataka()
    {
        return "Naziv:" + naziv + " OIB:" + oib + " Adresa:" + adresa +
                "\n Vlasnik: " + vlasnik.getIme() + ", " + vlasnik.getPrezime() +
                ", OIB: " + vlasnik.getOib();
    }
}
