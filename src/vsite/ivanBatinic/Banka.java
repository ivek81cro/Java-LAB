package vsite.ivanBatinic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Banka {

    public static void main(String[] args) throws ParseException {
        Vlasnik v1=new Vlasnik("Ivo", "Ivić", "1234567890");
        Vlasnik v2=new Vlasnik("Ivo", "Ivić", "1234567890", "Maksimir 11");
        v2.ispisPodataka();

        Racun b1=new Racun("0001",v1,3200.00);
        Racun b2=new Racun("0002",v1,500.00);
        String datum="06/11/2019";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(datum);
        b1.uplata(date1,Iznos.setIznos("HRK",100));
        b2.isplata(date1,Iznos.setIznos("HRK",90));
        Racun b3=b1;
        b3.isplata(date1,Iznos.setIznos("HRK",100));
        b2.uplata(date1,Iznos.setIznos("HRK",200));
        b3=new Racun("0003",v1,1500);
        b3.uplata(date1,Iznos.setIznos("HRK",250));
        System.out.println(b1.trenStanje);
        System.out.println(b2.trenStanje);
        System.out.println(b3.trenStanje);
    }
}