package com.bootcamp.Shop;

import com.bootcamp.Shop.Commands.BuyCoommand;
import com.bootcamp.Shop.Commands.Command;
import com.bootcamp.Shop.Commands.CommandManager;
import com.bootcamp.Shop.Commands.ReturnCommand;
import com.bootcamp.Shop.Pool.Pool;

public class Main {

	public static void main(String[] args) {

		/**
		 * Create things
		 */
		Thing chocolate = new Thing("Chocolate");

		/**
		 * Create a category
		 */
		Category sweetThings = new Category();


		/**
		 * Create product add thing to product set cost and payload fro this product
		 */
		Product productChocolate =  new Product(1, "Chocolate");
		productChocolate.setCost(chocolate, 10);
		productChocolate.setPayload(chocolate, 1);


		/**
		 * Create a shop add  to shop product ad=nd set this product category
		 */
		ShopIml shop = new ShopIml();
		shop.addProduct(productChocolate, sweetThings);
		/**
		 * Create or fisrt player
		 */
		User user = new User("FisrtPlaye");
		user.addItem(chocolate, 20);

		Pool<BuyCoommand> buyCoommandPool = new Pool<BuyCoommand> () {
			@Override
			protected BuyCoommand newObject() {
				return new BuyCoommand();
			}
    	};
		Pool<ReturnCommand> returnCommandPool = new Pool<ReturnCommand> () {
			@Override
			protected ReturnCommand newObject() {
				return new ReturnCommand();
			}
		};

		/**
		 * Execute BuyCommand
		 */
		CommandManager.getInstance().executeCommand(buyCoommandPool.obtain(), shop, user, 1);


		/**
		 * Undo buy command
		 */
		CommandManager.getInstance().undo(shop, user, 1);

		/**
		 * Redo buy command
		 */
		CommandManager.getInstance().redo(shop, user, 1);

		user.outputInventory();


	}

}
