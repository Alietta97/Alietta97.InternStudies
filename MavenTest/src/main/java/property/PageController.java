package property;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="pageController")
@RequestScoped

public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String deneme;

	public PageController() {

	}

	public String processWellcomepage() {
		return "wellcomepage";
	}

	public String processProductInsert() {
		return "ProductInsert";
	}

	public String processDataTable() {
		return "DataTable";
	}
	
	public String processWarning() {
		return "warning";
	}

	public String getDeneme() {
		return deneme;
	}

	public void setDeneme(String deneme) {
		this.deneme = deneme;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}