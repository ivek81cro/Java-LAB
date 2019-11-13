package vsite.ivanBatinic;

public class Iznos {
    final String valuta;
    final double iznos;

    /**
     *
     * @param v - String valuta
     * @param i - double iznos
     */
    private Iznos(String v, double i) {
        valuta = v;
        iznos = i;
    }

    /**
     * Direktan unos iznosa
     * @param val - String valuta
     * @param izn - double iznos
     * @return Iznos klasa
     */
    public static Iznos setIznos(String val, double izn)
    {
        return new Iznos(val,izn);
    }
}


