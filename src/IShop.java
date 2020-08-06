import java.util.List;

public interface IShop {
	
	/*
	 *  Get product in a specific category
	 */
	public List<Product> getProductsByCategory(Category category);
	
	/*
	 * Purchase product
	 */
	
	public void purchaseProduct(Product product, User user);
	
	
	/*
	 * show users data 
	 */
	
	public void printUsers(User user);
	
	
	
	

}
