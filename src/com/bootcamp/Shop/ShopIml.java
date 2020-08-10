package com.bootcamp.Shop;

import com.bootcamp.Shop.IShop;

import java.util.HashMap;

public class ShopIml implements IShop {


	/**
	 * Quick lookup map so that we can easily find products by category
	 */
	private HashMap<Category, HashMap<Integer, Product>> categoryMap = new HashMap<>();

	/**
	 * List of all products for looking up by SKU, without caring about category
	 */
	private HashMap<Integer, Product> productMap = new HashMap<>();

	/**
	 * Adds a product to the list of this shop products that are available for sale
	 * @param product
	 * @param category
	 */
	public void addProduct(Product product, Category category) {
		productMap.put(product.getId(),  product);

		if(!categoryMap.containsKey(category)) {
			categoryMap.put(category, new HashMap<>());
		}

		categoryMap.get(category).put(product.getId(), product);
	}

	@Override
	public HashMap<Integer, Product> getProductsByCategory(Category category) {
		return categoryMap.get(category);
	}


	/**
	 * Check if user canAfford a product
	 *
	 * @param user
	 * @param id
	 * @return
	 */
	@Override
	public boolean canAfford (User user, int id) {
		Product product = productMap.get(id);

		if (product == null) return false;

		for (Thing thing: product.getCost().keySet()) {
			int count = product.getCost().get(thing);
			if (!user.hasItem(thing, count)) {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * Check id user canAfford the product and if yes spend the cost and  get reward a payload
	 *
	 * @param user
	 * @param id
	 * @return true, if transaction was successful
	 */
	@Override
	public boolean purchaseProduct (User user, int id) {

		Product product = productMap.get(id);

		if (product != null) {

			if (canAfford(user, id)) {
				for(Thing thing: product.getCost().keySet()) {
					int count = product.getCost().get(thing);
					user.spendItem(thing, count);
				}

				for (Thing thing: product.getPayload().keySet()) {
					int count = product.getPayload().get(thing);
					user.addItem(thing, count);
				}

				System.out.println("transaction complete for product: " + product.getProductName());

				return true;
			}
		}

		return false;
	}


	@Override
	public boolean returnProduct(User user, int id) {

		Product product = productMap.get(id);
		if(product != null) {
			if(canAfford(user, id)) {
				for (Thing thing : product.getCost().keySet()) {
					int count = product.getCost().get(thing);
					user.addItem(thing, count);
				}
				for (Thing thing : product.getPayload().keySet()) {
					int count = product.getPayload().get(thing);
					user.spendItem(thing, count);
				}
				System.out.println("transaction complete for product: " + product.getProductName());

				return true;
			}
		}
		return false;

	}



}
