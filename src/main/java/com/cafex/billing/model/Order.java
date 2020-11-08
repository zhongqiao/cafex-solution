package com.cafex.billing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class Order {
    String orderId;
    Map<String, Integer> orderMenuItems;
}
