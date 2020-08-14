package com.bootcamp.Shop.Commands;

import java.util.ArrayList;
import com.bootcamp.Shop.ShopIml;
import com.bootcamp.Shop.User;


public class CommandManager {

    private static CommandManager instance;

    private ArrayList<Command> history = new ArrayList<>();

    private int cursor = 0;

    private CommandManager(){

    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }



    public void executeCommand(Command command, ShopIml shop, User user, int id) {

        command.execute(shop, user, id);
        if (cursor < history.size() - 1) {
            history.set(cursor, command);
        } else {
            history.add(command);
        }
        cursor++;

    }

    public void undo(ShopIml shop, User user, int id) {
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







}
