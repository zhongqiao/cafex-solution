package com.cafex.billing.service;


import com.cafex.billing.model.MenuItemDetail;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class TotalChargeService {

    public BigDecimal calculateTotalChargeForPurchasedItems(List<MenuItemDetail> purchasedItems) {
        BigDecimal total = purchasedItems
                .stream()
                .map(item -> item.getItemPrice().multiply(BigDecimal.valueOf(item.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        total.setScale(2, RoundingMode.HALF_UP);

        return total;
    }

}
