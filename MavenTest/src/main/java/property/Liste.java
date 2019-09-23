package property;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="liste")
@RequestScoped
public class Liste {
	private Long id;
	private String name;
	private String kind;
	private int quantity;
	private int spot;
	
	public Liste() {
		
	}
	
	public Liste(Long id,String name,String kind,int quantity,int spot) {
		this.id=id;
		this.name=name;
		this.kind=kind;
		this.quantity=quantity;
		this.spot=spot;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSpot() {
		return spot;
	}
	public void setSpot(int spot) {
		this.spot = spot;
	}
	
	

}
