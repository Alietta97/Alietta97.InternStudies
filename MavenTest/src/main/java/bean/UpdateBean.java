package bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import property.DatabaseConnection;
import property.Liste;

@ManagedBean(name = "updateBean")
@RequestScoped
public class UpdateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Statement stmt = null;

	private static List<Liste> list = new ArrayList<Liste>();

	public static void update() {
		
		try {

			stmt = DatabaseConnection.connect().createStatement();
			
			String sql = "SELECT * FROM STORAGE";
			PreparedStatement state = DatabaseConnection.connect().prepareStatement(sql);
			state.executeQuery();
			ResultSet rs = state.getResultSet();
			while (rs.next()) {
				list.add(new Liste(rs.getLong("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getString("PRODUCT_KIND"),
						rs.getInt("PRODUCT_QUANTITY"), rs.getInt("PRODUCT_SPOT")));				
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

			} catch (Exception se) {
				se.printStackTrace();
			}
		}

	}
	

	public List<Liste> getList() {
		return list;
	}
	
	public static List<Liste> getter() {
		return list;
	}

	public void setList(List<Liste> list) {
		UpdateBean.list = list;
	}

}
