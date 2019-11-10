package vsite.ivanBatinic;

public class Iznos {
    final String valuta;
    final double iznos;

    private Iznos(String v, double i) {
        valuta = v;
        iznos = i;
    }

    public static Iznos setIznos(String val, double izn)
    {
        return new Iznos(val,izn);
    }
}


