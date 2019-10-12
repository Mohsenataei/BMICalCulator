package com.mohsen.calculatebmi.constants;

import java.util.HashMap;

public class CaloriesList {
    public  HashMap<String, Integer> caloriesMap;
    public CaloriesList(){
        caloriesMap = new HashMap<>();

    }   public CaloriesList(HashMap<String, Integer> hash){
        caloriesMap = hash;
    }

    public  void putData(String key, int value){
        caloriesMap.put(key,value);
    }
    public  int getData(String key){
        return caloriesMap.get(key);
    }

    public  HashMap<String, Integer> getCaloriesMap() {
        return caloriesMap;
    }

    public  void setCaloriesMap(HashMap<String, Integer> caloriesMap) {
        this.caloriesMap = caloriesMap;
    }
}
