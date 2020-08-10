package com.bootcamp.Shop;

import java.util.HashMap;


    public class Product {
        /**
         * The unique identifier for product that can't be changed
         */
        private int  id;

        /**
         *  name for Product
         */
        private String productName;

        /**
         * Cost is a map for things and their counts that wiil be  DEDUCED as a part of transaction
         */
        private HashMap<Thing,  Integer> cost = new HashMap<>();

        /**
         * Payloads is map of things and their counts that will be REWARDED  as a part of transaction
         */
        private HashMap<Thing,  Integer> payload = new HashMap<>();

        public Product(int id, String productName) {
            this.id = id;
            this.productName = productName;
        }

        public void setCost(Thing thing, int count) {
            cost.put(thing, count);
        }


        public void setPayload(Thing thing, int count) {
            payload.put(thing, count);
        }


        public Integer getId() {
            return id;
        }

        public String getProductName() {
            return productName;
        }


        public HashMap<Thing,  Integer> getPayload() {
            return payload;
        }

        public HashMap<Thing,  Integer> getCost() {
            return cost;
        }



    }


