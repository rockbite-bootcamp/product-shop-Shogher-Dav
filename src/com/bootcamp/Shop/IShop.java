package com.bootcamp.Shop;

import java.util.HashMap;

public interface IShop {

	/**
	 * Get product with a specific category
	 * @param category
	 * @return
	 */
	 HashMap<Integer, Product> getProductsByCategory(Category category);

	/**
	 * Purchase product
	 * @param id
	 * @param user
	 */
	public boolean purchaseProduct (User user, int id);


	/**
	 * If user doen't want a product  he or she can return it to shop
	 * @param user
	 * @param id
	 * @return
	 */
	public boolean returnProduct(User user, int id);

	/**
	 * Check if  user can afford buying some items
	 * @param user
	 * @param id
	 * @return
	 */
	boolean canAfford (User user, int id);





	
	
	
	

}
