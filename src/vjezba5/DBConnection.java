import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	public List<String> svePoruke()
	{  
		List<String> messages = new ArrayList<String>();
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/javavjezbe?&serverTimezone=UTC","java","java");  
		//here sonoo is database name, root is username and password  
		Statement stmt = con.createStatement();  
		ResultSet rs = stmt.executeQuery("select * from korisnik");
		
		while(rs.next()) { 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			messages.add(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return messages;
	}
	
	public void snimiPoruku(String user, String text)
	{
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/javavjezbe?&serverTimezone=UTC","java","java");  
		//here sonoo is database name, root is username and password  
		
		PreparedStatement stmt = con.prepareStatement("insert into korisnik (user, text) values(?,?)");
		stmt.setString(1, user);
		stmt.setString(2, text);
		stmt.execute();		
			
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}