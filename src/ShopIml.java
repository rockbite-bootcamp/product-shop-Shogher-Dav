import java.util.List;

public class ShopIml implements IShop{
	

	@Override
	public List<Product> getProductsByCategory(Category category) {
		List<Product> products = category.getProducts();	
		return products;
	}

	@Override
	public void purchaseProduct(Product product, User user) {
		
		int cost = product.getCost().size();
		
	try {	
		for(int i=0; i< cost; i++) {
			 user.getThings().remove(i);
		}
		user.getThings().addAll(product.getPayload());
	
	} catch(Exception err) {
		System.out.print("Can't buy this product please try another one");
		
	}
	
	}

	@Override
	public void printUsers(User user) {
		System.out.println("User id--> " + user.getId() + "  the size of owned thigs ---> " + user.getThings().size());			
	}
	
	

}
