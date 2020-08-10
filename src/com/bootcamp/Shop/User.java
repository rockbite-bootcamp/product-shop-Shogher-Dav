package com.bootcamp.Shop;

import java.util.HashMap;

public class User {
    /**
     * User name
     */
    private String  name;

    private HashMap<Thing,  Integer> goods = new HashMap<>();


    public User( String name) {
        this.name = name;
    }


    public boolean hasItem (Thing thing, int count) {
        if(!goods.containsKey(thing)) {
            return false;
        }
        return true;
    }

    public void spendItem (Thing thing, int count)  {
        if(!goods.containsKey(thing) || goods.get(thing) < count) {
            System.out.println("Trying to spend item that we don't have enough of");
        }

        if(goods.containsKey(thing)) {
            int currCount = goods.get(thing);
            goods.put(thing, currCount - count);
        }
    }

    public void addItem (Thing thing, int count) {
        if(!goods.containsKey(thing)) {
            goods.put(thing, count);
        } else {
            goods.put(thing, goods.get(thing) + count);
        }
    }

    public void outputInventory() {
        System.out.println("player inventory");
        System.out.println("---------------");

        for(Thing item: goods.keySet()) {
            int count = goods.get(item);
            System.out.println(item.getName() + ": " + count);
        }
        System.out.println("---------------");
    }


}

