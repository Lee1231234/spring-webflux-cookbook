package com.webflux.test;

import reactor.core.publisher.Flux;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	private final KitchenService kitchen;

	public ServerController(KitchenService kitchen) {
		this.kitchen = kitchen;
	}

	@GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Dish> serveDishes() {
		return this.kitchen.getDishes();
	}
	// end::controller[]

	// tag::deliver[]
	@GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Dish> deliverDishes() {
		return this.kitchen.getDishes() //
				.map(dish -> Dish.deliver(dish));
	}
}