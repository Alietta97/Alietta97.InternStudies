package property;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import bean.Items;


@ManagedBean(name="koli")
@RequestScoped

public class Koli extends Items implements Serializable {
	private static final long serialVersionUID = 1L;
	private String product_kind = "koli";
	private int product_spot = 10;
	private int product_quantity = 5000;

	public Koli() {
		super();
	}

	public Koli(String product_name) {
		super(product_name);
	}

	/*
	 * public String toString() { return "ürün_id => " + product_id +
	 * " ürün_adi => " + product_name + " product_spot => " + product_spot +
	 * " product_quantity => " + product_quantity + super.toString(); }
	 * 
	 */

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getProduct_spot() {
		return product_spot;
	}

	public void setProduct_spot(int product_spot) {
		this.product_spot = product_spot;
	}

	public String getProduct_kind() {
		return product_kind;
	}

	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}

}
