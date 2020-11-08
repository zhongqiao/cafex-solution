package com.cafex.billing.service;

import com.cafex.billing.model.FoodType;
import com.cafex.billing.model.HotColdType;
import com.cafex.billing.model.MenuItem;
import com.cafex.billing.model.MenuItemDetail;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipServiceTest {

    @Autowired
    TipService tipService;

    List<MenuItemDetail> purchasedItems = new ArrayList<>();
    @BeforeEach
    void setUp() {
        MenuItemDetail menuItemDetailOne = MenuItemDetail.builder()
                .itemName(MenuItem.COLA.toString())
                .itemPrice(BigDecimal.valueOf(0.5))
                .count(2)
                .build();
        ArrayList<String> coldColaFeature = new ArrayList<>();
        coldColaFeature.add(FoodType.DRINK.toString());
        menuItemDetailOne.setFeature(coldColaFeature);
        purchasedItems.add(menuItemDetailOne);

        MenuItemDetail menuItemDetailTwo = MenuItemDetail.builder()
                .itemName(MenuItem.COFFEE.toString())
                .itemPrice(BigDecimal.valueOf(1))
                .count(2)
                .build();
        ArrayList<String> hotCoffeeFeature = new ArrayList<>();
        hotCoffeeFeature.add(FoodType.DRINK.toString());
        menuItemDetailTwo.setFeature(hotCoffeeFeature);
        purchasedItems.add(menuItemDetailTwo);
    }


    @Test
    void tip_percentage_should_return_zero_when_no_food_ordered() {
        assertThat(tipService.calculateTip(purchasedItems),
                Matchers.comparesEqualTo(BigDecimal.valueOf(0)));
    }
    @Test
    void tip_percentage_should_return_ten_when_food_ordered() {
        MenuItemDetail menuItemDetailTwo = MenuItemDetail.builder()
                .itemName(MenuItem.STEAK_SANDWICH.toString())
                .itemPrice(BigDecimal.valueOf(4.5))
                .count(2)
                .build();
        ArrayList<String> hotSteakSandwichFeature = new ArrayList<>();
        hotSteakSandwichFeature.add(FoodType.FOOD.toString());
        menuItemDetailTwo.setFeature(hotSteakSandwichFeature);
        purchasedItems.add(menuItemDetailTwo);

        assertThat(tipService.calculateTip(purchasedItems),
                Matchers.comparesEqualTo(BigDecimal.valueOf(10)));
    }
}