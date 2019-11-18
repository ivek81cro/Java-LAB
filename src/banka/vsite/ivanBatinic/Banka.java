package vsite.ivanBatinic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Banka {

    public static void main(String[] args) throws ParseException {
        //Prvi dio

        Vlasnik v1=new Vlasnik("Ivo", "Ivić", "1234567890");
        Vlasnik v2=new Vlasnik("Marko", "Marić", "1234567890", "Maksimir 11");
        System.out.println(v2.ispisPodataka());

        Racun b1=new Racun("0001",v1,3200.00);
        Racun b2=new Racun("0002",v2,500.00);
        String datum="06/11/2019";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(datum);
        b1.uplata(date1,Iznos.setIznos("HRK",100));
        System.out.println(b1.getTrenStanje());
        b2.isplata(date1,Iznos.setIznos("HRK",90));
        b2.storIsplata(date1,Iznos.setIznos("HRK", 90));
        Racun b3=b1;
        b3.isplata(date1,Iznos.setIznos("HRK",100));
        System.out.println(b1.getTrenStanje());
        b2.uplata(date1,Iznos.setIznos("HRK",200));
        b3=new Racun("0003",v1,1500);
        b3.uplata(date1, Iznos.setIznos("HRK", 250));
        System.out.println(b1.getTrenStanje());
        System.out.println(b2.getTrenStanje());
        b1.printPromet();
        b2.printPromet();
        b3.printPromet();

        //Drugi dio

        Vlasnik v3=new Vlasnik("Ivo", "Ivić", "1234567890");
        VlasnikPravna v4 = new VlasnikPravna(v1,"09876543210","Ulica 15", "Firma d.d.");

        Racun b4;
        Racun b5;

        TekuciRacun t1= new TekuciRacun("0004",v3,0,4,100,14);
        b4=t1;

        OroceniRacun o1=new OroceniRacun("0005",v4,0,5);
        b5=o1;

        System.out.println(b4.getTrenStanje());
        System.out.println(b5.getTrenStanje());

        b4.uplata(date1,Iznos.setIznos("HRK",100));
        b5.uplata(date1,Iznos.setIznos("HRK",200));
        System.out.println(b4.getTrenStanje());
        System.out.println(b5.getTrenStanje());
        b4.obracunKamata();
        b5.obracunKamata();
        System.out.println(b4.getTrenStanje());
        System.out.println(b5.getTrenStanje());

        b4.isplata(date1,Iznos.setIznos("HRK",200));
        b5.isplata(date1,Iznos.setIznos("HRK",10));
        System.out.println(b4.getTrenStanje());
        System.out.println(b5.getTrenStanje());

        b4.obracunKamata();
        b5.obracunKamata();
        System.out.println(b4.getTrenStanje());
        System.out.println(b5.getTrenStanje());

        b4.printPromet();
        b5.printPromet();
    }
}
