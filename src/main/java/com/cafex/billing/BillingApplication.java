package com.cafex.billing;

import com.cafex.billing.model.MenuItem;
import com.cafex.billing.model.Order;
import com.cafex.billing.service.BillingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class BillingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args); }
	@Bean
	public BillingService getBillingService(){
		return  new BillingService();
	}

	@Override
	public void run(String... args)  {

		Order newOrder = testDataSetup();
		BigDecimal customerBill = getBillingService().calculateBillForOrder(newOrder);
		System.out.println("The bill for order number " + newOrder.getOrderId() + " is $" + customerBill);
	}

	private Order testDataSetup(){
		Map<String, Integer> menuItems = new HashMap<String, Integer>();
		menuItems.put(MenuItem.COLA.toString(), Integer.valueOf(2));
		menuItems.put(MenuItem.STEAK_SANDWICH.toString(), Integer.valueOf(3));
		Order newOrder = Order
				.builder()
				.orderId("CAFEX001")
				.orderMenuItems(menuItems)
				.build();
		return newOrder;
	}


}