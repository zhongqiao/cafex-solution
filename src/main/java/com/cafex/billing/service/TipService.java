package com.cafex.billing.service;

import com.cafex.billing.model.FoodType;
import com.cafex.billing.model.MenuItemDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TipService {

    @Value("${DEFAULT_TIP_PERCENTAGE}")
    private int defaultTipPercentage;

    public BigDecimal calculateTip(List<MenuItemDetail> purchasedItems) {
        BigDecimal tipPercentage = BigDecimal.ZERO;
        if (purchasedItems
                .stream()
                .anyMatch(item -> (item.getFeature().contains(FoodType.FOOD.toString())))) {
            tipPercentage = BigDecimal.valueOf(defaultTipPercentage);
        }
        return tipPercentage;
    }

}
