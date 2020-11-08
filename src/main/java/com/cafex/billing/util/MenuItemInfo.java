package com.cafex.billing.util;

import com.cafex.billing.model.FoodType;
import com.cafex.billing.model.HotColdType;
import com.cafex.billing.model.MenuItem;
import com.cafex.billing.model.MenuItemDetail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuItemInfo {

    private static Map<String, MenuItemDetail> menuItemInfoMap = new HashMap<>();
    private MenuItemInfo(){
        MenuItemDetail coldCola = MenuItemDetail
                .builder()
                .itemName("Cola")
                .itemPrice(BigDecimal.valueOf(0.50))
                .build();
        ArrayList<String> coldColaFeature = new ArrayList<>();
        coldColaFeature.add(FoodType.DRINK.toString());
        coldColaFeature.add(HotColdType.COLD.toString());
        coldCola.setFeature(coldColaFeature);
        menuItemInfoMap.put(MenuItem.COLA.toString(), coldCola);

        MenuItemDetail hotCoffee = MenuItemDetail
                .builder()
                .itemName("Coffee")
                .itemPrice(BigDecimal.valueOf(1))
                .build();
        ArrayList<String> hotCoffeeFeature = new ArrayList<>();
        hotCoffeeFeature.add(FoodType.DRINK.toString());
        hotCoffeeFeature.add(HotColdType.HOT.toString());
        hotCoffee.setFeature(hotCoffeeFeature);
        menuItemInfoMap.put(MenuItem.COFFEE.toString(), hotCoffee);

        MenuItemDetail coldCheeseSandwich = MenuItemDetail
                .builder()
                .itemName("Cheese Sandwich")
                .itemPrice(BigDecimal.valueOf(2))
                .build();
        ArrayList<String> coldCheeseSandwichFeature = new ArrayList<>();
        coldCheeseSandwichFeature.add(FoodType.FOOD.toString());
        coldCheeseSandwichFeature.add(HotColdType.COLD.toString());
        coldCheeseSandwich.setFeature(coldCheeseSandwichFeature);
        menuItemInfoMap.put(MenuItem.CHEESES_SANDWICH.toString(), coldCheeseSandwich);

        MenuItemDetail hotSteakSandwich = MenuItemDetail
                .builder()
                .itemName("Steak Sandwich")
                .itemPrice(BigDecimal.valueOf(4.5))
                .build();
        ArrayList<String> hotSteakSandwichFeature = new ArrayList<>();
        hotSteakSandwichFeature.add(FoodType.FOOD.toString());
        hotCoffeeFeature.add(HotColdType.HOT.toString());
        hotSteakSandwich.setFeature(hotSteakSandwichFeature);
        menuItemInfoMap.put(MenuItem.STEAK_SANDWICH.toString(), hotSteakSandwich);

    }

    public static Map<String, MenuItemDetail> getMenuItemInfo(){

        if (menuItemInfoMap.size() == 0) new MenuItemInfo();
        return menuItemInfoMap;
    }
}
