package com.bootcamp.Shop.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import com.bootcamp.Shop.Pool.Pool;
import com.bootcamp.Shop.ShopIml;
import com.bootcamp.Shop.User;

/**
 * The CommandManager is Singleton class
 */
public class CommandManager {

    private static CommandManager instance;

    /**
     * Create history for undo redo methods
     */
    private ArrayList<Command> history = new ArrayList<>();
    /**
     * Cretae HashMap for storing pool commands
     */
    private  HashMap<Class, Pool>  poolCommands = new HashMap<>();

    private int cursor = 0;

    private CommandManager() {
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    /**
     * Create instances for Pool commands
     */
    private static  Pool<BuyCommand> buyCommandPool = new Pool<BuyCommand> () {
        @Override
        protected BuyCommand newObject() {
            return new BuyCommand();
        }
    };
    private static Pool<ReturnCommand> returnCommandPool = new Pool<ReturnCommand> () {
        @Override
        protected ReturnCommand newObject() {
            return new ReturnCommand();
        }
    };

    public void executeCommand(Command command, ShopIml shop, User user, int id) {
        command.execute(shop, user, id);
        if (cursor < history.size() - 1) {
            history.set(cursor, command);
        } else {
            history.add(command);
        }
        cursor++;
    }

    public void undo(  ShopIml shop, User user, int id) {
        if (cursor == 0 ) return;
        Command command = history.get(cursor-1);
        command.undo(shop, user, id);
        cursor--;
    }

    public void redo(ShopIml shop, User user, int id) {
        if (cursor > history.size() - 1) return;
        Command command = history.get(cursor);
        command.execute(shop, user, id);
        cursor++;
    }

    /**
     * Adding pool comamds to HashMap
     * @return
     */
    public HashMap<Class, Pool>  createPoolComands() {
        poolCommands.put(BuyCommand.class,  buyCommandPool );
        poolCommands.put(ReturnCommand.class, returnCommandPool);
        return  poolCommands;
    }
}
