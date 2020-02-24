package vsite.placa.java;

public class RadnoMjesto {

	private String naziv;
	private double koeficijent;
	
	public String getNaziv()	{ return naziv; }
	public double getKoeficijent()	{ return koeficijent; }
	
	public void setNaziv(String val) { naziv=val; }
	public void setKoeficijent(double val) { koeficijent=val; }
	
	public RadnoMjesto() {}
	
	public RadnoMjesto(String n, double k)
	{
		naziv=n; koeficijent=k;
	}
	
	public boolean Kontrola()
	{
		if(naziv.length()<2) {return false;}
		if(koeficijent<0) {return false;}
		return true;
	}
}
