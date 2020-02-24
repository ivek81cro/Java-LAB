package vsite.placa.java;

public class Obracun {
	
	private int id;
	private double bruto;
	private double sati;
	private double prekovremeno=0;
	private double mio1;
	private double mio2;
	private double odbitak;
	private double osnovica;
	private double porez1=0;
	private double porez2=0;
	private double porezUkupno=0;
	private double prirez=0;
	private double porezPrirez=0;
	private double neoporezivo=0;
	private double doprinosZdravstvo;
	private double netto;
	private double iznos;	

	public int getId() {return id;}
	public double getBruto() {return bruto;}
	public double getSati() {return sati;}
	public double getPrekovremeno() {return prekovremeno;}
	public double getMio1() {return mio1;}
	public double getMio2() {return mio2;}
	public double getOdbitak() {return odbitak;}
	public double getOsnovica() {return osnovica;}
	public double getPorez1() {return porez1;}
	public double getPorez2() {return porez2;}
	public double getPorezUkupno() {return porezUkupno;}
	public double getPrirez() {return prirez;}
	public double getPorezPrirez() {return porezPrirez;}
	public double getNeoporezivo() {return neoporezivo;}
	public double getDoprinosZdravstvo() {return doprinosZdravstvo;}
	public double getNetto() {return netto;}
	public double getIznos() {return iznos;}
	
	public void Obracunaj(int idZ, double satiR, double prekov, double neoporez) {

		DbConnection dc = new DbConnection();
		PlacaObj placa = new PlacaObj();
		placa.DohvatiPostavke();
		Zaposlenik z = new Zaposlenik();
		z = dc.DohvatiZaposlenikKoeficijent(idZ);
		id=idZ;
		neoporezivo = neoporez;
		bruto= Math.round(placa.getBod() * z.getKoeficijent()*100.0)/100.0;
		iznos = bruto;
		netto= neoporezivo;
		sati = satiR-prekov;
		if(prekov>0) 
		{
			prekovremeno = Math.round(prekov * (bruto/sati)*1.2 * 100.0) / 100.0;
			bruto += prekovremeno;
		}
		iznos -= mio1 = Math.round(bruto*placa.getMio1()* 100.0) / 100.0;
		iznos -= mio2 = Math.round(bruto*placa.getMio2()* 100.0) / 100.0;
		double osnOdbitak = placa.getOdbitak();
		odbitak = Math.round((osnOdbitak + 2400.0 * z.getOlaksica()) * 100.0) / 100.0;
		netto += odbitak;
		if(odbitak < iznos) 
		{
			iznos -= odbitak;
			iznos -= porez1 = Math.round(iznos * placa.getPorez1()* 100.0) / 100.0;
			
			if(iznos>30000.01)
				iznos -= porez2 = Math.round(iznos * placa.getPorez2()* 100.0) / 100.0;
			porezUkupno = porez1+porez2;
			iznos -= prirez = Math.round(porezUkupno * z.getPrirez()* 100.0) / 100.0;
		}
		netto += Math.round(iznos * 100.0) / 100.0;
		porezPrirez = porezUkupno + prirez;
		doprinosZdravstvo = Math.round(bruto * placa.getZdravstveno()* 100.0) / 100.0;
	}

}
