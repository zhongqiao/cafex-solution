package com.cafex.billing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
@Builder
public class MenuItemDetail {
    String itemName;
    ArrayList<String> feature;
    BigDecimal itemPrice;
    int count;
}