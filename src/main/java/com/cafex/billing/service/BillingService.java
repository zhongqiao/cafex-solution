package com.cafex.billing.service;


import com.cafex.billing.util.MenuItemInfo;
import com.cafex.billing.model.MenuItemDetail;
import com.cafex.billing.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BillingService {

    @Autowired
    TipService tipService;

    @Autowired
    TotalChargeService totalChargeService;

    public BigDecimal calculateBillForOrder(Order order) {
        Map<String, MenuItemDetail> menuItemInfoMap = MenuItemInfo.getMenuItemInfo();
        List<MenuItemDetail> purchasedItems = new ArrayList<>();

        order.getOrderMenuItems().forEach((key, value) -> {
            MenuItemDetail newMenuItemDetail= menuItemInfoMap.get(key);
            newMenuItemDetail.setCount(value);
            purchasedItems.add(newMenuItemDetail);

        });

        BigDecimal totalForPurchasedItems = totalChargeService.calculateTotalChargeForPurchasedItems(purchasedItems);
        BigDecimal tipPercentage = tipService.calculateTip(purchasedItems);

        return totalForPurchasedItems.multiply(BigDecimal.valueOf(100).add(tipPercentage))
                .divide(BigDecimal.valueOf(100));
    }



}
