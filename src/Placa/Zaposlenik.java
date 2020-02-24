package vsite.placa.java;

public class Zaposlenik {
	
	private String oib;
	private String ime;
	private String prezime;
	private String adresa;
	private String grad;
	private double koeficijent=0;
	private double olaksica;
	private double prirez;
	
	public String getOib()	{ return oib; }
	public String getIme()	{ return ime; }
	public String getPrezime()	{ return prezime; }
	public String getAdresa()	{ return adresa; }
	public String getGrad()	{ return grad; }
	public double getKoeficijent()	{ return koeficijent; }
	public double getOlaksica()	{ return olaksica; }
	public double getPrirez()	{ return prirez; }
	
	public void setOib(String val) { oib=val; }
	public void setIme(String val) { ime=val; }
	public void setPrezme(String val) { prezime=val; }
	public void setAdresa(String val) { adresa=val; }
	public void setGrad(String val) { grad=val; }
	public void setKoeficijent(double val)	{ koeficijent=val; }
	public void setOlaksica(double val)	{ olaksica=val; }
	public void setPrirez(double val)	{ prirez=val; }
	
	public Zaposlenik() {}
	
	public Zaposlenik(String o, String i, String p, String a, String g, double ol, double pr)
	{
		oib=o; ime=i; adresa=a; prezime=p; grad=g; olaksica=ol; prirez=pr;
	}
	
	public boolean Kontrola() 
	{
		if(oib.length()<11) { return false; }
		if(ime.length()<2) { return false; }
		if(prezime.length()<2) { return false; }
		if(adresa.length()<2) { return false; }
		if(grad.length()<2) { return false; }
		return true;
	}

}
