package vsite.ivanBatinic;

public abstract class Vlasnik {

    final String oib;
    String adresa;

    Vlasnik(String a, String o)
    {
        adresa=a; oib=o;
    }

    public abstract String ispisPodataka();
}
