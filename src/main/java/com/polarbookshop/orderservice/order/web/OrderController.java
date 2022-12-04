package com.polarbookshop.orderservice.order.web;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarbookshop.orderservice.order.domain.Order;
import com.polarbookshop.orderservice.order.domain.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("orders")
public class OrderController {
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public Flux<Order> getAllOrders() {
		return this.orderService.getAllOrders();
	}
	
	@PostMapping
	public Mono<Order> submitOrder(@RequestBody @Valid OrderRequest orderRequest) {
		return this.orderService.submitOrder(orderRequest.isbn(), orderRequest.quantity());
	}
}
