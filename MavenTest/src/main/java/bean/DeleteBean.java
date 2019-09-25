package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import property.DatabaseConnection;

@ManagedBean(name = "deleteBean")
@SessionScoped
public class DeleteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	public static Statement stmt = null;
	public static String messages="Database cleaning process failed!";
	
	public static void delete() {
		try {
			stmt = DatabaseConnection.connect().createStatement();
			
			String sql ="TRUNCATE TABLE STORAGE";
		
			stmt.executeUpdate(sql);
			System.out.println("cleaning complete...\n");
			messages="cleaning complete...";
			message(messages);
			
		}catch (SQLException se) {

			se.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (stmt != null)
					DatabaseConnection.disconnect();
				System.out.println("Connection lost...");

			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		
	}
	public static void message(String m) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Insert", m) );
    }

}
