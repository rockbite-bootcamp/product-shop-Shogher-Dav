import java.util.ArrayList;
import java.util.List;

public class Category {
	
	/*
	 * Category name
	 */
	
	private String name;
	
	/*
	 * list of Products the category have
	 */
	
	private List<Product> products = new ArrayList<>();
	
	public Category() {}
	

	public Category(String name, List<Product> products) {
		this.name = name;
		this.products = products;
	}

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	
	/*
	 * add  list of products to category
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	/*
	 * add a one product to category
	 */
	public void addProduct(Product product) {
		this.products.add(product);
	}


	@Override
	public String toString() {
		return "Category [name=" + name + ", products=" + products + "]";
	}
	


}
