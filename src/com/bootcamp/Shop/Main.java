package com.bootcamp.Shop;

import com.bootcamp.Shop.Commands.BuyCommand;
import com.bootcamp.Shop.Commands.CommandManager;
import com.bootcamp.Shop.Commands.ReturnCommand;


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

		/**
		 * Execute Buy command
		 */
		BuyCommand buyCommand = (BuyCommand) CommandManager.getInstance().createPoolComands().get(BuyCommand.class).obtain();
		CommandManager.getInstance().executeCommand(buyCommand, shop, user, 1);

		/**
		 * Execute Return command
		 */
		ReturnCommand returnCommand = (ReturnCommand) CommandManager.getInstance().createPoolComands().get(ReturnCommand.class).obtain();
		CommandManager.getInstance().executeCommand(returnCommand, shop, user, 1);

		/**
		 * Undo Return command
		 */
		CommandManager.getInstance().undo( shop, user, 1);

		/**
		 * Redo Return command
		 */
		CommandManager.getInstance().redo(shop, user, 1);

		user.outputInventory();


	}

}
