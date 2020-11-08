package com.cafex.billing.service;

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

@SpringBootTest
class TotalChargeServiceTest {

    @Autowired
    TotalChargeService totalChargeService;

    List<MenuItemDetail> purchasedItems = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MenuItemDetail menuItemDetailOne = MenuItemDetail.builder()
                .itemName(MenuItem.COLA.toString())
                .itemPrice(BigDecimal.valueOf(0.5))
                .count(2)
                .build();
        purchasedItems.add(menuItemDetailOne);

        MenuItemDetail menuItemDetailTwo = MenuItemDetail.builder()
                .itemName(MenuItem.STEAK_SANDWICH.toString())
                .itemPrice(BigDecimal.valueOf(4.5))
                .count(2)
                .build();
        purchasedItems.add(menuItemDetailTwo);

    }


    @Test
    void total_charge_should_return_added_price_for_all_items() {
        assertThat(totalChargeService.calculateTotalChargeForPurchasedItems(purchasedItems),
                Matchers.comparesEqualTo(BigDecimal.valueOf(10)));


    }
}