import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		/*
		 * Create things which will be added to products for cost and payload and to user 
		 */
		ThingType building = new ThingType("building");
		
		/*
		 * Cost List of products
		 */
		List<ThingType> buildingsCost = new ArrayList<>();
		/*
		 * Payload lists of products
		 */
		List<ThingType> buildingsPayload = new ArrayList<>();
		
		
		/*
		 * Adding things to cost list
		 */
		for( int i=0; i< 10; i++) {
			buildingsCost.add(building);
		}
		/*
		 * Adding things to payload list
		 */
		
		for( int i=0; i< 5; i++) {
			buildingsPayload.add(building);
		}
		
		
		/*
		 * Create product
		 */
		Product buildingProduct = new Product(1, buildingsCost, buildingsPayload);

		/*
		 * Create category and add product to category
		 */
		Category buildingsCategory = new Category();
		
		buildingsCategory.addProduct(buildingProduct);

		/*
		 * Create shop
		 */
		ShopIml shop = new ShopIml();
		
		/*
		 * Get product from specific category
		 */
		List<Product> products = shop.getProductsByCategory(buildingsCategory);
		for(Product product : products ) {
			System.out.println(product);
		}
		
		/*
		 * Create user, add arrayList of things for user
		 */
		
		User user = new User(1, "firstUser");
		List<ThingType> userThings = new ArrayList<>();
		
		for (int i=0; i<20; i++) {
			userThings.add(building);	
		}
		user.setThings(userThings);
		
		/*
		 * print user id and list of things before purchase
		 */
		
		shop.printUsers(user);

		
		
		/*
		 * Purchase products from shop
		 */
		shop.purchaseProduct(buildingProduct, user);
		
		
		/*
		 * Print user id and list of things after purchase
		 */
		shop.printUsers(user);
		
		
		
	}

}
