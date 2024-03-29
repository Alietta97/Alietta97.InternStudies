package bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import property.DatabaseConnection;

@ManagedBean(name = "loginBean")
@javax.enterprise.context.RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	

	public static Statement stmt = null;

	public String login() {

		try {

			stmt = DatabaseConnection.connect().createStatement();

			String sql = "SELECT USER_NAME,USER_PASSWORD FROM USERS WHERE USER_NAME='" + this.user
					+ "' AND USER_PASSWORD='" + this.password + "'";
			stmt.executeQuery(sql);
			System.out.println();
			
			PreparedStatement state = DatabaseConnection.connect().prepareStatement(sql);
			state.execute();
			ResultSet rs = state.getResultSet();
			if(rs.first()==true) {
				System.out.println("Logging in...\n\n");
				return "ProductInsert";
				
			}else{
				return "warning";
			}
			
		
		} catch (SQLException se) {

			se.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (stmt != null)
					DatabaseConnection.disconnect();
				System.out.println("Connection lost...");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "warning";
	}
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
