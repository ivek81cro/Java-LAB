package vsite.ivanBatinic;

import java.util.Date;

public class Promet {

    private final String valuta;//get
    private final Date datum;//get
    private final double iznosDug;//get
    private final double iznosPot;//get
    private final boolean storno;//get

    private Promet(String v, Date d, double izD, double izP, boolean st)
    {
        valuta=v; datum=d; iznosDug=izD; iznosPot=izP; storno=st;
    }

    public String getValuta(){return valuta;}
    public Date getDatum(){return datum;}
    public double getIznosDug(){return iznosDug;}
    public double getIznosPot(){return iznosPot;}
    public boolean getStorno(){return storno;}

    public static Promet potPromet(Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta, d,0, iznos.iznos,false);
    }
    public static Promet stPotPromet(Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta, d,0, iznos.iznos*-1,true);
    }

    public static Promet dugPromet( Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta,d,iznos.iznos, 0,false);
    }
    public static Promet stDugPromet( Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta,d,iznos.iznos*-1, 0,true);
    }
}
