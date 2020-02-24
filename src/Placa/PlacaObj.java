package vsite.placa.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlacaObj {

	private double bod;
	private double odbitak;
	private double mio1;
	private double mio2;
	private double osnovicaUzdrzavanje;
	private double dijete1;
	private double dijete2;
	private double dijete3;
	private double uzdrzavaniClan;
	private double porez1;
	private double porez2;
	private double zdravstveno;
	
	public PlacaObj() {}
	
	public PlacaObj(double b, double od, double ou, double d1, double d2, double d3, double uc, double p1, double p2, double zd) 
	{
		bod=b; odbitak=od; osnovicaUzdrzavanje=ou; dijete1=d1; dijete2=d2; dijete3=d3; 
		uzdrzavaniClan=uc; porez1=p1; porez2=p2; zdravstveno=zd;
	}
	
	public double getBod() {return bod;}
	public double getOdbitak() {return odbitak;}
	public double getMio1() {return mio1;}
	public double getMio2() {return mio2;}
	public double getOsnovicaUzdrzavanje() {return osnovicaUzdrzavanje;}
	public double getDijete1() {return dijete1;}
	public double getDijete2() {return dijete2;}
	public double getDijete3() {return dijete3;}
	public double getuzdrzavaniClan() {return uzdrzavaniClan;}
	public double getPorez1() {return porez1;}
	public double getPorez2() {return porez2;}
	public double getZdravstveno() {return zdravstveno;}
	
	public void setBod(double v) { bod=v;}
	public void setOdbitak(double v) { odbitak=v;}
	public void setMio1(double v) {mio1=v;}
	public void setMio2(double v) {mio2=v;}
	public void setOsnovicaUzdrzavanje(double v) { osnovicaUzdrzavanje=v;}
	public void setDijete1(double v) { dijete1=v;}
	public void setDijete2(double v) { dijete2=v;}
	public void setDijete3(double v) { dijete3=v;}
	public void setuzdrzavaniClan(double v) { uzdrzavaniClan=v;}
	public void setPorez1(double v) { porez1=v;}
	public void setPorez2(double v) { porez2=v;}
	public void setZdravstveno(double v) { zdravstveno=v;}
	
	public void DohvatiPostavke()
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM postavke;");          
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
            	bod=rs.getDouble("iznosboda");
            	odbitak=rs.getDouble("odbitak");
            	osnovicaUzdrzavanje=rs.getDouble("osnovicauzdrzavanje");
            	dijete1=rs.getDouble("dijete1");
            	dijete2=rs.getDouble("dijete2");
            	dijete3=rs.getDouble("dijete3");
            	uzdrzavaniClan=rs.getDouble("uzdrzavaniclan");
            	porez1=rs.getDouble("porez1");
            	porez2=rs.getDouble("porez2");
            	zdravstveno=rs.getDouble("dopzdravstvo");
            	mio1=rs.getDouble("mio1");
            	mio2=rs.getDouble("mio2");            	
            }
            con.close();
        } 
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
        }
	}
	
	public boolean SpremiPostavke()
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/obracun?serverTimezone=UTC", "java", "java");
            PreparedStatement pstm = con.prepareStatement("UPDATE postavke SET odbitak=?, osnovicauzdrzavanje=?, dijete1=?, dijete2=?, dijete3=?,"
            		+ "uzdrzavaniclan=?, porez1=?, porez2=?, dopzdravstvo=?, iznosboda=?, mio1=?, mio2=? WHERE id=0;");
            pstm.setDouble(1,odbitak);
            pstm.setDouble(2,osnovicaUzdrzavanje);
            pstm.setDouble(3,dijete1);
            pstm.setDouble(4,dijete2);
            pstm.setDouble(5,dijete3);
            pstm.setDouble(6,uzdrzavaniClan);
            if(porez1>1)
            	porez1=porez1/100.0;
            pstm.setDouble(7,porez1);
            if(porez2>1)
            	porez2=porez2/100.0;
            pstm.setDouble(8,porez2);
            if(zdravstveno>1)
            	zdravstveno=zdravstveno/100.0;
            pstm.setDouble(9,zdravstveno);
            pstm.setDouble(10,bod);
            if(mio1>1)
            	mio1=mio1/100.0;
            pstm.setDouble(11,mio1);
            if(mio2>1)
            	mio2=mio2/100.0;
            pstm.setDouble(12,mio2);
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
}
