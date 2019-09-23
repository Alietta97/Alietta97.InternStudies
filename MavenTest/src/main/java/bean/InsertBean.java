package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;


import property.DatabaseConnection;

@ManagedBean(name = "insertBean")
@javax.enterprise.context.RequestScoped
public class InsertBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Statement stmt = null;

	public void init() {
		UpdateBean.update();
	}

	public static String add(Items item) {

		try {

			stmt = DatabaseConnection.connect().createStatement();

			// insert into storage
			// (product_name,product_quantity,product_spot)values('koli',1000,5);

			String sql = "INSERT INTO STORAGE(PRODUCT_NAME,PRODUCT_KIND,PRODUCT_QUANTITY,PRODUCT_SPOT) " + "VALUES ('"
					+ item.getProduct_name() + "','" + item.getProduct_kind() + "','" + item.getProduct_quantity()
					+ "','" + item.getProduct_spot() + "')";

			stmt.executeUpdate(sql);

			System.out.println("Kayit ekleme basarili...\n");

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
		return "a";
	}

}
