package vsite.ivanBatinic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OroceniRacun extends Racun {

    OroceniRacun(String brR, Vlasnik v, double p, double kam){super(brR, v, p, kam);}
    OroceniRacun(String brR, VlasnikPravna v, double p, double kam){super(brR, v, p, kam);}
    @Override
    public boolean isplata(Date d, Iznos iznos)
    {
        return false;
    }
    @Override
    public double getTrenStanje()
    {
        return trenStanje;
    }
    @Override
    public boolean obracunKamata()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        uplata(date, Iznos.setIznos("HRK",  trenStanje*kamata/100));

        return true;
    }
}
