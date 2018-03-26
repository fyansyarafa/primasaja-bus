import java.sql.*;
import javax.swing.*;
public class sqliteConnectionper {
	Connection conn=null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Documents\\tubesai\\aii.sqlite");
			//JOptionPane.showMessageDialog(null, "Sukses");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}



}
