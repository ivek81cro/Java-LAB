package vsite.ivanBatinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class Racun {
    final String brojRn;
    final Vlasnik vlasnik;
    final double pocStanje;
    private double trenStanje;//get
    private List<Promet> p=new ArrayList<>();//ili array

    /**
     *
     * @param brR - String broj racuna
     * @param v - Klasa Vlasnik
     * @param p - double Poetno stanje
     */
    Racun(String brR, Vlasnik v, double p)
    {
        brojRn=brR; vlasnik=v; pocStanje=p; trenStanje=p;
    }

    /**
     * Provjera valute ("HRK")
     * @param valuta String
     * @return boolean
     */
    public boolean provjeriValutu(String valuta)
    {
        return valuta.equals("HRK");
    }

    /**
     * Uplata na racun
     * @param d - Date datum
     * @param iznos - double iznos
     * @return boolean
     */
    public boolean uplata(Date d, Iznos iznos)
    {
        if(provjeriValutu(iznos.valuta) && iznos.iznos > 0) {
            Promet promet = Promet.dugPromet(d, iznos);
            p.add(promet);
            trenStanje += iznos.iznos;
            return true;
        }
        return false;
    }

    /**
     * Storniranje uplate
     * @param d - Date datum
     * @param iznos - double iznos
     * @return boolean
     */
    public boolean storUplata(Date d, Iznos iznos)
    {
        if(provjeriValutu(iznos.valuta))
        {
            if(iznos.iznos > trenStanje)
                return false;

            Promet promet = Promet.stDugPromet(d, iznos);
            p.add(promet);
            trenStanje -= iznos.iznos;
            return true;
        }
        return false;
    }

    /**
     * Isplata sa racuna
     * @param d - Date datum
     * @param iznos - double Iznos
     * @return boolean
     */
    public boolean isplata(Date d, Iznos iznos)
    {
        if(provjeriValutu(iznos.valuta)) {
            if (iznos.iznos > trenStanje)
                return false;

            Promet promet = Promet.potPromet(d, iznos);
            p.add(promet);
            trenStanje -= iznos.iznos;
            return true;
        }
        return false;
    }

    /**
     * Storniranje isplate
     * @param d - Date datum
     * @param iznos - double iznos
     * @return boolean
     */
    public boolean storIsplata(Date d, Iznos iznos)
    {
        if(provjeriValutu(iznos.valuta)) {
            Promet promet = Promet.stPotPromet(d, iznos);
            p.add(promet);
            trenStanje += iznos.iznos;
            return true;
        }
        return false;
    }

    /**
     * Dohvat trenutnog stanja racuna
     * @return double stanje racuna
     */
    public double getTrenStanje()
    {
        return trenStanje;
    }

    /**
     * Ispis prometa po racunu sa kontrolom
     */
    public void printPromet()
    {
        System.out.println("\n" + vlasnik.ispisPodataka() + " | Početno stanje:" + pocStanje);
        Iterator<Promet> promet = p.iterator();
        while (promet.hasNext())
        {
            System.out.println(promet.next().ispisPromet());
        }
        System.out.println("Trenutno stanje:" + trenStanje);
        System.out.println("Kontrola-->" + kontrola());
    }

    /**
     * Kontrola prometa po racunu sa trenutnim stanjem
     * @return boolean
     */
    private boolean kontrola()
    {
        double pot=0, dug=0;
        for(Promet stavka : p)
        {
            if(stavka.getIznosDug()!=0)
            {
                dug+= stavka.getIznosDug();
            }
            if(stavka.getIznosPot()!=0)
            {
                pot+= stavka.getIznosPot();
            }
        }

        if(trenStanje==pocStanje+(dug-pot))
            return true;

        return false;
    }
}
