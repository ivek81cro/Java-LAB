package vsite.ivanBatinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Racun {
    final String brojRn;
    final Vlasnik vlasnik;
    final double pocStanje;
    double trenStanje;
    List<Promet> p=new ArrayList<>();//ili array

    Racun(String brR, Vlasnik v, double p)
    {
        brojRn=brR; vlasnik=v; pocStanje=p; trenStanje=p;
    }
    public boolean uplata(Date d, Iznos iznos)
    {
        Promet promet= Promet.dugPromet(d,iznos);
        p.add(promet);
        trenStanje+=iznos.iznos;
        return true;

    }
    public boolean storUplata(Date d, Iznos iznos)
    {
        Promet promet= Promet.stDugPromet(d,iznos);
        p.add(promet);
        trenStanje-=iznos.iznos;
        return true;
    }
    public boolean isplata(Date d, Iznos iznos)
    {
        Promet promet= Promet.potPromet(d,iznos);
        p.add(promet);
        trenStanje-=iznos.iznos;
        return true;
    }
    public boolean storIsplata(Date d, Iznos iznos)
    {
        Promet promet= Promet.stPotPromet(d,iznos);
        p.add(promet);
        trenStanje+=iznos.iznos;
        return true;
    }
}
