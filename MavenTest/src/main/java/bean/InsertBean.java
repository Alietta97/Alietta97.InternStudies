package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import property.DatabaseConnection;

@ManagedBean(name = "insertBean")
@SessionScoped
public class InsertBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Statement stmt = null;
	public static String messages = "baþarýsýz";

	public static String add(Items item) {

		try {

			stmt = DatabaseConnection.connect().createStatement();

			String sqltest="SELECT * FROM STORAGE WHERE PRODUCT_NAME = '"+item.getProduct_name()+"' AND PRODUCT_KIND= '"+ item.getProduct_kind()+"' ";
			String sqlupt="UPDATE STORAGE SET PRODUCT_QUANTITY= '"+(item.getProduct_quantity()+UpdateBean.getter().get(0).getQuantity())+"'";
			 if(stmt.executeQuery(sqltest).first()) {
				 stmt.execute(sqlupt);
				 messages="Bu ürün kayýtlýdýr. Belirttiðiniz miktar mevcut ürüne eklendi!";
				 message(messages);
			 }else {
				 
				 String sql = "INSERT INTO STORAGE(PRODUCT_NAME,PRODUCT_KIND,PRODUCT_QUANTITY,PRODUCT_SPOT) " + "VALUES ('"
							+ item.getProduct_name() + "','" + item.getProduct_kind() + "','" + item.getProduct_quantity()
							+ "','" + item.getProduct_spot() + "')";

					stmt.executeUpdate(sql);
					System.out.println("Kayit ekleme basarili...\n");
					messages = "kayit ekleme basarili...";
					message(messages);
			 }
				
			// insert into storage
			// (product_name,product_quantity,product_spot)values('koli',1000,5);

			
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

	public static void message(String m) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Insert", m));
	}

}
