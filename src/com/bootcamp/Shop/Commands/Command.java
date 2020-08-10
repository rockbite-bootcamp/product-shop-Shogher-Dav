package com.bootcamp.Shop.Commands;

import com.bootcamp.Shop.Pool.Poolable;
import com.bootcamp.Shop.ShopIml;
import com.bootcamp.Shop.User;

/**
 * Command interface for all commands and also it should be Poolable
 */
public interface Command extends Poolable {

    void execute(ShopIml shop, User user, int id);
    void undo(ShopIml shop, User user, int id);
}
