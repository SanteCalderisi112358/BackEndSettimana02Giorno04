package Esercizio01;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", products=" + products
				+ ", customer=" + customer + "]";
	}

    // Resto del codice della classe
}
