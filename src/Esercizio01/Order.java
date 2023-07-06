package Esercizio01;

import java.time.LocalDate;
import java.util.List;

public class Order {
	long id;
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Product> products;
	Customer customer;

	public Order(long _id, String _status, LocalDate _orderDate, LocalDate _deliveryDate, List<Product> _products,
			Customer _customer) {

		this.id = _id;
		this.status = _status;
		this.orderDate = _orderDate;
		this.deliveryDate = _deliveryDate;
		this.products = _products;
		this.customer = _customer;
	}

}
