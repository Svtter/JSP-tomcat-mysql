package bean;
import java.io.*;
import java.util.Properties;
import java.sql.*;
public class GetConnection {
	private static Properties p;
	static{
		try{
			p = new Properties();
			InputStream is = GetConnection.class.getResourceAsStream("property.conf");
			p.load(is);
			is.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String key){
		return p.getProperty(key);
	}
	static String driver = GetConnection.getProperty("driver");
	static String url = GetConnection.getProperty("url");
	static  String name = GetConnection.getProperty("user");
	static String pass = GetConnection.getProperty("password");
	static{
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, pass);
	}
}
