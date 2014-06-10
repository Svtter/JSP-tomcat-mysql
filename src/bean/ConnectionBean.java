package bean;

import java.sql.*;

public class ConnectionBean {
	private Connection con;
	public ConnectionBean() {
		try{
			con = GetConnection.getConnection();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	//向数据库添加信息
	public boolean addUser(String name, String password){
		try{
			PreparedStatement pstmt = con.prepareStatement("insert into ur(name, passwd) values(?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.execute();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public ResultSet getUser(String name){
		try {
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select * from ur where name='"+name+"'");
			return result;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public String checkUser(String name, String passwd){
		String checkUser=null;
		try{
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select * from ur where name='"+name+"'");
			if(result.next()==false){
				checkUser = "No user";
			}
			else{
				if(result.getString("passwd").equals(passwd)){
					checkUser = "Success";
				}
				else{
					checkUser = "Wrong passwd";
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return checkUser;
	}
}

