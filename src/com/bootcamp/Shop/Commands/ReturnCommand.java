package com.bootcamp.Shop.Commands;

import com.bootcamp.Shop.ShopIml;
import com.bootcamp.Shop.User;

public class ReturnCommand implements Command {

    @Override
    public void execute(ShopIml shop, User user, int id) {

        shop.returnProduct(user, id);
    }

    @Override
    public void undo(ShopIml shop, User user, int id) {

        shop.purchaseProduct(user, id);
    }

    @Override
    public void reset(){

    }

}
