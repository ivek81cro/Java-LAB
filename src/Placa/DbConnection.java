package vsite.placa.java;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DbConnection {
	
	public DefaultTableModel prikazSve()
	{
		String colNames[]= {"Id","OIB","Ime","Prezime", "Adresa", "Grad", "Prirez", "Olakšica"};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM zaposlenici");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            	String id = rs.getString("id");
            	String oib = rs.getString("oib");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String adresa = rs.getString("adresa");
                String grad = rs.getString("grad");
                String prirez = rs.getString("prirez");
                String olaksica = rs.getString("olaksica");

                // create a single array of one row's worth of data
                String[] data = { id, oib, ime, prezime, adresa, grad, prirez, olaksica } ;

                // and add this row of data into the table model
                model.addRow(data);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return model;
	}
	
	public ArrayList<String> prikazImena()
	{
		ArrayList<String> imena = new ArrayList<String>();
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
			PreparedStatement pstm = con.prepareStatement("SELECT id, ime, prezime FROM zaposlenici;");

			ResultSet rs = pstm.executeQuery(); 

			while (rs.next()) { 
				String ime = rs.getString("id") + ". " + rs.getString("ime") + " " + rs.getString("prezime"); 
				// add group names to the array list
				imena.add(ime);
			} 

		rs.close();
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return imena;
	}
	
	public boolean UnesiZaposlenika(Zaposlenik z)
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("INSERT INTO zaposlenici (oib,ime,prezime,adresa,grad, olaksica, prirez) VALUES(?,?,?,?,?,?,?)");
            pstm.setString(1, z.getOib());
            pstm.setString(2, z.getIme());
            pstm.setString(3, z.getPrezime());
            pstm.setString(4, z.getAdresa());
            pstm.setString(5, z.getGrad());
            pstm.setDouble(6, z.getOlaksica());
            pstm.setDouble(7, z.getPrirez());
            
            pstm.execute();
            
            pstm = con.prepareStatement("SELECT id FROM zaposlenici WHERE oib=?;");
            pstm.setString(1, z.getOib());
            ResultSet rs = pstm.executeQuery();
            int id=0;
            while(rs.next())
            	id = rs.getInt("id");
            
            pstm = con.prepareStatement("INSERT INTO neoporezivo (idZaposlenik) VALUES(?);");
            pstm.setInt(1, id);
            pstm.execute();     
            
            pstm = con.prepareStatement("INSERT INTO obracun (idZaposlenik) VALUES(?);");
            pstm.setInt(1, id);
            pstm.execute();
            con.close();
        } 
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            return false;
        }
		return true;
	}
	
	public boolean BrisiZaposlenika(int id)
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("DELETE FROM zaposlenici WHERE id=?");
            pstm.setInt(1, id);            
            pstm.execute();
            pstm = con.prepareStatement("DELETE FROM neoporezivo WHERE idZaposlenik=?");
            pstm.setInt(1, id);            
            pstm.execute();
            
            pstm = con.prepareStatement("DELETE FROM obracun WHERE idZaposlenik=?");
            pstm.setInt(1, id);            
            pstm.execute();
            
            pstm = con.prepareStatement("DELETE FROM radnomjesto WHERE idZaposlenik=?");
            pstm.setInt(1, id);            
            pstm.execute();
            
            con.close();
        } 
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            return false;
        }
		return true;
	}
	
	public DefaultTableModel SvaRadnaMjesta()
	{
		String colNames[]= {"Id", "Naziv","Koeficijent"};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM sistematizacija");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            	String id = rs.getString("id");
            	String naziv = rs.getString("naziv");
                String koeficijent = rs.getString("koeficijent");

                // create a single array of one row's worth of data
                String[] data = { id, naziv, koeficijent } ;

                // and add this row of data into the table model
                model.addRow(data);                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return model;
	}
	
	public ArrayList<String> prikazRadnamj()
	{
		ArrayList<String> mj = new ArrayList<String>();
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
			PreparedStatement pstm = con.prepareStatement("SELECT id, naziv, koeficijent FROM sistematizacija;");

			ResultSet rs = pstm.executeQuery(); 

			while (rs.next()) { 
				String mjesto = rs.getString("id") + ". " + rs.getString("naziv") + " " + rs.getString("koeficijent"); 
				// add group names to the array list
				mj.add(mjesto);
			} 

		rs.close();
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return mj;
	}
	
	public boolean UnosRadnogmjesta(RadnoMjesto r)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO sistematizacija (naziv,koeficijent) VALUES(?,?)");
			pstm.setString(1, r.getNaziv());
			pstm.setDouble(2, r.getKoeficijent());
        
			pstm.execute();
			con.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean BrisiRadnoMjesto(int id)
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("DELETE FROM sistematizacija WHERE id=?");
            pstm.setInt(1, id);            
            pstm.execute();
            con.close();
        } 
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            return false;
        }
		return true;
	}

	public DefaultTableModel prikazSistematizacije()
	{
		String colNames[]= {"Id","Ime","Prezime", "Radno mjesto", "Koeficjent"};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("SELECT z.id, ime, prezime, naziv, koeficijent "
            		+ "FROM radnomjesto r, zaposlenici z, sistematizacija s where z.id=idZaposlenik AND s.id=idRadnomjesto;");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            	String id = rs.getString("id");
            	String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String naziv = rs.getString("naziv");
                String koef = rs.getString("koeficijent");

                // create a single array of one row's worth of data
                String[] data = { id, ime, prezime, naziv, koef } ;

                // and add this row of data into the table model
                model.addRow(data);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return model;
	}
	
	public boolean OdrediRadnoMjesto(int idZap, int idRadnoMjesto)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
			PreparedStatement pstm = con.prepareStatement("SELECT idZaposlenik from radnomjesto WHERE idZaposlenik=?");
			pstm.setInt(1, idZap);
			ResultSet rs = pstm.executeQuery();
			if(!rs.next())
			{
				PreparedStatement pstm2 = con.prepareStatement("INSERT INTO radnomjesto VALUES(?,?);");
				pstm2.setInt(1, idZap);
				pstm2.setInt(2, idRadnoMjesto);
				pstm2.execute();
			}
			else
			{
				PreparedStatement pstm3 = con.prepareStatement("UPDATE radnomjesto SET idRadnomjesto=? WHERE idZaposlenik=?;");
				pstm3.setInt(2, idZap);
				pstm3.setInt(1, idRadnoMjesto);
				pstm3.execute();
			}
			con.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public DefaultTableModel prikazObracuna()
	{
		String colNames[]= {"Id","Ime","Prezime", "Radno mjesto", "Koeficjent", "Sati", "Prekovremeno", "Bruto", "Mio1", "Mio2", 
				"Odbitak", "Osnovica", "Porez1", "Porez2", "Prirez", "Neoporezivo", "Doprinos HZZO", "Netto"};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            
            PreparedStatement pstm = con.prepareStatement("SELECT z.id, ime, prezime, naziv, koeficijent, sati, prekovremeno, bruto, " + 
            		" mio1, mio2, odbitak, osnovica, porez1, porez2, porezUkupno, o.prirez, porezPrirez, neoporezivo, doprinosZdravstvo, neto" + 
            		" FROM radnomjesto r, zaposlenici z, sistematizacija s, obracun o where z.id=r.idZaposlenik AND s.id=idRadnomjesto AND z.id=o.idZaposlenik;");
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            	String id = rs.getString("id");
            	String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String naziv = rs.getString("naziv");
                String koef = rs.getString("koeficijent");
                Double satiZ = rs.getDouble("sati");
                String sati = satiZ.toString();
                String prekovremeno = rs.getString("prekovremeno");
                String bruto = rs.getString("bruto");
                String mio1 = rs.getString("mio1");
                String mio2 = rs.getString("mio2");
                String odbitak = rs.getString("odbitak");
                String osnovica = rs.getString("osnovica");
                String por1 = rs.getString("porez1");
                String por2 = rs.getString("porez2");
                String prir = rs.getString("prirez");
                String neop = rs.getString("neoporezivo");
                String doprinosZ = rs.getString("doprinosZdravstvo");
                String netto = rs.getString("neto");

                // create a single array of one row's worth of data
                String[] data = { id, ime, prezime, naziv, koef, sati, prekovremeno, bruto, mio1, mio2, odbitak, osnovica, por1, por2, prir, neop, doprinosZ, netto } ;

                // and add this row of data into the table model
                model.addRow(data);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return model;
	}
	
	public Zaposlenik DohvatiZaposlenikKoeficijent(int id) {
		Zaposlenik z = new Zaposlenik();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC",
					"java", "java");
			PreparedStatement pstm = con.prepareStatement("SELECT oib, ime, prezime, adresa, grad, koeficijent, olaksica, prirez FROM "
					+ "zaposlenici z, sistematizacija s, radnomjesto r WHERE z.id=? AND r.idZaposlenik=? AND s.id=r.idRadnomjesto;");
			pstm.setInt(1, id);
			pstm.setInt(2, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				z.setOib(rs.getString("oib"));
				z.setIme(rs.getString("ime"));
				z.setPrezme(rs.getString("prezime"));
				z.setAdresa(rs.getString("adresa"));
				z.setGrad(rs.getString("grad"));
				z.setKoeficijent(rs.getDouble("koeficijent"));
				z.setOlaksica(rs.getDouble("olaksica"));
				z.setPrirez(rs.getDouble("prirez"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return z;
	}
	
	public DefaultTableModel prikazNeoporezivo()
	{
		String colNames[]= {"Zaposlenik","Putni","Nagrada","Obrok","Vrtiæ"};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("SELECT ime, prezime, putni, nagrada, obrok, vrtic FROM zaposlenici z, neoporezivo n"
            		+ " WHERE n.idZaposlenik=z.id;");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            	String id = rs.getString("ime") + " " + rs.getString("prezime");
            	String putni = rs.getString("putni");
                String nagrada = rs.getString("nagrada");
                String obrok = rs.getString("obrok");
                String vrtic = rs.getString("vrtic");

                // create a single array of one row's worth of data
                String[] data = { id, putni, nagrada, obrok, vrtic } ;

                // and add this row of data into the table model
                model.addRow(data);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return model;
	}
	
	public void spremiNeoporezivoZaposlenik(int idZ, String neop, double iznos)
	{		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC","java", "java");
			PreparedStatement pstm = con.prepareStatement("UPDATE neoporezivo SET "+neop+"=? WHERE idZaposlenik=?;");
			pstm.setDouble(1, iznos);
			pstm.setInt(2, idZ);
			pstm.execute();
			
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());			
		}
	}
	
	public double dohvatiNeoporezivoDjelatnika(int idZ)
	{
		double neoporezivo=0;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC",
					"java", "java");
			PreparedStatement pstm = con.prepareStatement("SELECT putni + vrtic + obrok + nagrada as neop FROM neoporezivo WHERE idZaposlenik=?;");
			pstm.setInt(1, idZ);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				neoporezivo=rs.getDouble("neop");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return neoporezivo;
	}

	public boolean upisiObracun(Obracun o, int idZ)
	{		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC",
					"java", "java");
			PreparedStatement pstm = con.prepareStatement("UPDATE obracun SET sati=?, prekovremeno=?, bruto=?, mio1=?, mio2=?, odbitak=?,"
					+ " osnovica=?, porez1=?, porez2=?, porezUkupno=?, prirez=?, porezPrirez=?, neoporezivo=?, doprinosZdravstvo=?, neto=? WHERE idZaposlenik=?");
			pstm.setDouble(1, o.getSati());
			pstm.setDouble(2, o.getPrekovremeno());
			pstm.setDouble(3, o.getBruto());
			pstm.setDouble(4, o.getMio1());
			pstm.setDouble(5, o.getMio2());
			pstm.setDouble(6, o.getOdbitak());
			pstm.setDouble(7, o.getOsnovica());
			pstm.setDouble(8, o.getPorez1());
			pstm.setDouble(9, o.getPorez2());
			pstm.setDouble(10, o.getPorezUkupno());
			pstm.setDouble(11, o.getPrirez());
			pstm.setDouble(12, o.getPorezPrirez());
			pstm.setDouble(13, o.getNeoporezivo());
			pstm.setDouble(14, o.getDoprinosZdravstvo());
			pstm.setDouble(15, o.getNetto());
			pstm.setDouble(16, o.getId());

			pstm.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
