package com.mohsen.calculatebmi.model;

import java.util.HashMap;

public class Food {
    private String name;
    private int calory;
    private HashMap<String, Integer> map;
    private String type;

    public Food(String name, int calory, String type) {
        map = new HashMap();
        map.put(name,calory);
        this.name = name;
        this.calory = calory;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalory() {
        return calory;
    }

    public int getCaleryByStringKey(String key){
        return map.get(key);
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public String getModel() {
        return type;
    }

    public void setModel(String model) {
        this.type = model;
    }
}
