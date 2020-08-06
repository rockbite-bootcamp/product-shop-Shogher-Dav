import java.util.ArrayList;
import java.util.List;

public class Product {
	/*
	 * the unique identifier of product
	 */
	
	private int  id;
	
	/*
	 * Cost of product 
	 */
	private List<ThingType>  cost;
	
	/*
	 * Payload of Product, every product has a payload which user get after purchase the product 
	 */
	
	private List<ThingType> payload;
	

	public Product(int id, List<ThingType> cost, List<ThingType> payload) {
		this.id = id;
		this.cost = cost;
		this.payload = payload;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public List<ThingType> getCost() {
		return cost;
	}
	
	/*
	 * add  cost for THIS product
	 */
	public void addCost(ThingType cost) {
		this.cost = new ArrayList<>();
		this.cost.add(cost);		
	}

	public List<ThingType> getPayload() {
		return payload;
	}

	public void setPayload(List<ThingType> payload) {
		this.payload = payload;
	}






	@Override
	public String toString() {
		return "Product [id=" + id + ", cost=" + cost + ", payload=" + payload + "]";
	}
	
	
	
	

}
 