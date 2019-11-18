package vsite.ivanBatinic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TekuciRacun extends Racun {

    double dozvMinus;
    final double zatKamata;

    TekuciRacun(String brR, Vlasnik v, double p, double kam, double minus, double zatKam)
    {
        super(brR, v, p, kam); dozvMinus=minus*-1; zatKamata=zatKam;
    }

    @Override
    public double getTrenStanje()
    {
        System.out.println(vlasnik.ispisPodataka());
        return trenStanje;
    }
    @Override
    public boolean isplata(Date d, Iznos iznos)
    {
        if(provjeriValutu(iznos.valuta)) {
            if (trenStanje-iznos.iznos < dozvMinus)
                return false;

            Promet promet = Promet.potPromet(d, iznos);
            p.add(promet);
            trenStanje -= iznos.iznos;
            return true;
        }
        return false;
    }
    @Override
    public boolean obracunKamata()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if(trenStanje<0)
        {
            isplata(date, Iznos.setIznos("HRK", trenStanje*zatKamata/100));
        }
        else
        {
            uplata(date, Iznos.setIznos("HRK",trenStanje*kamata/100));
        }
        return true;
    }
}
