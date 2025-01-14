package com.orderService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.orderService.domain.OrderRequest;
import com.orderService.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackPlaceOrder")
    //@TimeLimiter(name = "inventory")
    @Retry(name = "inventory",fallbackMethod = "fallbackPlaceOrder")
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		
		try{
			System.out.println("+++++++++++place order  method called+++++++++++++++++");
			orderService.placeOrder(orderRequest);
			logger.info("Your order is placed succesfully.");
			return "Your order is placed succesfully.";
		}catch(Exception ex) {
			return ex.getMessage();
		}
		
	}
	
	public String fallbackPlaceOrder(Exception exception) {
		System.out.println("+++++++++++fallback method called+++++++++++++++++");
		return "Something went wrong, Please try again later.";
	}
	

}
