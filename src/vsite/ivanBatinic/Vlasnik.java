package vsite.ivanBatinic;

import java.sql.Time;

public class Vlasnik {

    String ime;//get,set
    String prezime;//get,set
    final String oib;//get
    String adresa;//get,set

    Vlasnik(String i, String p, String o, String a)
    {
        ime=i; prezime=p; oib=o; adresa=a;
    }
    Vlasnik(String i, String p, String o)
    {
        ime=i; prezime=p; oib=o; adresa=null;
    }

    public String getIme(){return ime;}
    public void setIme(String i){ ime=i;}
    public String getPrezime(){return prezime;}
    public void setPrezime(String p){ prezime=p;}
    public String getOib(){return  oib;}

    public void ispisPodataka()
    {
        System.out.println("Ime:" + ime + " Prezime:"+ prezime+ " OIB:" + oib + " Adresa:" + adresa);
    }

}
