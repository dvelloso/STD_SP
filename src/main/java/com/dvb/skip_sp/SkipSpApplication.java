package com.dvb.skip_sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkipSpApplication {//implements CommandLineRunner{

	/*@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private OrderService orderService;*/
	
	public static void main(String[] args) {
		SpringApplication.run(SkipSpApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		// customer
				List<Customer> customers = Arrays.asList(new Customer("daniel@gmail.com", "Daniel", "Address1", "123"),//
						new Customer("joaquim@gmail.com", "Joaquim", "Address2", "456"));
				customers.stream().forEach(c -> customerService.save(c));
				
				// store
				List<Store> stores = Arrays.asList(new Store("Italian Store"), new Store("Japanese Store"));
				stores.stream().forEach(s -> storeService.save(s));
				
				// products
				List<Product> products = Arrays.asList(new Product(stores.get(0).getId(), "Japanese 1", "", new BigDecimal("10")), //
						new Product(stores.get(0).getId(), "Japanese foods", "", new BigDecimal("5")), //)
						new Product(stores.get(0).getId(), "Japanese drinks", "", new BigDecimal("5")),
						new Product(stores.get(1).getId(), "Pasta", "", new BigDecimal("5")));
				
				products.stream().forEach(p -> productService.save(p));
				
				// Order
				// Order item
				Order order = new Order(customers.get(0).getId(), "address", "contact", stores.get(0).getId(), new BigDecimal("100"));
				List<OrderItem> itens = Arrays.asList( new OrderItem(order.getId(), products.get(0).getId(), new BigDecimal("100"), 1));
				//order.setOrderItems(itens);
				orderService.save(order, itens);	
		
	}*/
}
