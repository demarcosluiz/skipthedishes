package com.skip.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.ServicesController")
public class ServicesController {
	
	@Resource
	private ApplicationContext context = null;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private CousineService cousineService;
	
	@Inject
	private StoreService storeService;
	
	@Inject
	private ProductService productService;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private OrderItemService orderItemService;
	
	
	
	
	private static ServicesController instance;
	
	
	
	private ServicesController() {
		super();
	}
	
	@PostConstruct
	public void init() {
		instance = (ServicesController) context.getBean("com.skip.service.ServicesController");
		
	}
	
	public EntityTransaction getTransaction(){
		return entityManager.getTransaction();
	}
	
	public static final ServicesController getInstance() {
		return instance;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public CousineService getCousineService() {
		return cousineService;
	}
	
	public void setCousineService(CousineService cousineService) {
		this.cousineService = cousineService;
	}
	
	public StoreService getStoreService() {
		return storeService;
	}
	
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	public ProductService getProductService() {
		return productService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public OrderService getOrderService() {
		return orderService;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	
}
