package vsite.ivanBatinic;

import java.util.Date;

public class Promet {

    private final String valuta;//get
    private final Date datum;//get
    private final double iznosDug;//get
    private final double iznosPot;//get
    private final boolean storno;//get

    /**
     *
     * @param v - String valuta
     * @param d - Date datum
     * @param izD - double iznos dugovne strane
     * @param izP - double iznos potrazne strane
     * @param st - boolean storno
     */
    private Promet(String v, Date d, double izD, double izP, boolean st)
    {
        valuta=v; datum=d; iznosDug=izD; iznosPot=izP; storno=st;
    }

    /**
     * Dohvat vrste valute
     * @return String valuta
     */
    public String getValuta(){return valuta;}

    /**
     * Dohvat datuma
     * @return Date datum
     */
    public Date getDatum(){return datum;}

    /**
     * Dohvat iznosa dugovne strane
     * @return double iznos
     */
    public double getIznosDug(){return iznosDug;}

    /**
     * Dohvat iznosa potrazne strane
     * @return double iznos
     */
    public double getIznosPot(){return iznosPot;}

    /**
     * Dosvat statusa storno
     * @return boolean
     */
    public boolean getStorno(){return storno;}

    /**
     * Potrazni promet po racunu
     * @param d - Date datum
     * @param iznos - double
     * @return Promet klasa
     */
    public static Promet potPromet(Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta, d,0, iznos.iznos,false);
    }

    /**
     * Storniranje stavke potraznog prometa promet po racunu
     * @param d - Date datum
     * @param iznos - double
     * @return Promet klasa
     */
    public static Promet stPotPromet(Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta, d,0, iznos.iznos*-1,true);
    }
    /**
     * Dugovni promet po racunu
     * @param d - Date datum
     * @param iznos - double
     * @return Promet klasa
     */
    public static Promet dugPromet( Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta,d,iznos.iznos, 0,false);
    }
    /**
     * Storniranje dugovnog prometa po racunu
     * @param d - Date datum
     * @param iznos - double
     * @return Promet klasa
     */
    public static Promet stDugPromet( Date d, Iznos iznos)
    {
        return new Promet(iznos.valuta,d,iznos.iznos*-1, 0,true);
    }

    /**
     * Ispis za klasu Promet
     * @return String promet
     */
    public String ispisPromet()
    {
        return "Valuta:" + valuta + " | Datum:" + datum + " | Dugovno:" + iznosDug +
                " | Potrazno:" + iznosPot + " | Storno:" + storno;
    }
}
