package bean;


public abstract class Items {

	protected String product_kind;
	protected String product_name;
	protected int product_spot ;
	protected int product_quantity ;
	protected final boolean check;

	protected Items() {
		check = true;
	}

	protected Items(String product_name) {
		this.product_name = product_name;
		check = true;

	}

	@Override
	public String toString() {

		return " --> (Item)";
	}

	// Getter&setter


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getProduct_spot() {
		return product_spot;
	}

	public void setProduct_spot(int product_spot) {
		this.product_spot = product_spot;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public boolean isCheck() {
		return check;
	}

	public String getProduct_kind() {
		return product_kind;
	}

	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}
	
	

}
