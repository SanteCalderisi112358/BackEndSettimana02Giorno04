package Esercizio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

import com.github.javafaker.Faker;

//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Random;
//import java.util.function.Supplier;
//
//import org.slf4j.LoggerFactory;
//
//import com.github.javafaker.Faker;
//
//public class Esercizio {
//
//	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Esercizio.class);
//
//	public static void main(String[] args) {
//
//
//		Faker f = new Faker(Locale.ITALY);
////ID che uso per clienti, prodotti e ordini
//		Supplier<Long> idSupplier = () -> {
//			Random rndmId = new Random();
//			return rndmId.nextLong(900) + 100;
//		};
////tier per i clienti
//		Supplier<Integer> tierSupplier = () -> {
//			Random rndmTier = new Random();
//			return rndmTier.nextInt(10) + 1;
//		};
////CLIENTI
//		Supplier<Customer> customersSupplier = () -> {
//			return new Customer(idSupplier.get(), f.name().firstName(), tierSupplier.get());
//		};
////date per gli ordini
//
//		Supplier<LocalDate> randomDateSupplier = () -> {
//			LocalDate today = LocalDate.now();
//			LocalDate fourYearAgo = today.minusYears(4);
//
//			long days = today.toEpochDay() - fourYearAgo.toEpochDay();
//			Random random = new Random();
//			// System.out.println(days);
//			return fourYearAgo.plusDays(random.nextInt((int) days));
//
//		};
//
//		List<LocalDate> date = new ArrayList<LocalDate>();
//		for (int i = 0; i < 10; i++) {
//			date.add(randomDateSupplier.get());
//		}
//
//		// date.forEach(d -> System.out.println(d));
//
//		List<Customer> customers = new ArrayList<>();
//
//		for (int i = 0; i < 10; i++) {
//			customers.add(customersSupplier.get());
//		}
//
//		customers.forEach(c -> System.out.println(c));
//	}
//
//
//}


public class Esercizio {
	public static void main(String[] args) {
		Faker f = new Faker(Locale.ITALY);

		Supplier<Long> idSupplier = () -> {
			Random rndmId = new Random();
			return rndmId.nextLong(900) + 100;
		};

		Supplier<Integer> tierSupplier = () -> {
			Random rndmTier = new Random();
			return rndmTier.nextInt(10) + 1;
		};

		Supplier<Customer> customersSupplier = () -> {
			return new Customer(idSupplier.get(), f.name().firstName(), tierSupplier.get());
		};

		Supplier<Product> productSupplier = () -> {
			long id = idSupplier.get();
			String name = f.commerce().productName();
			Category category = Category.values()[f.random().nextInt(Category.values().length)];
			double price = Math.round(f.random().nextDouble() * 100 * 100.0) / 100.0;
			return new Product(id, name, category, price);
		};

		List<Customer> customers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			customers.add(customersSupplier.get());
		}

		for (Customer customer : customers) {
			List<Product> products = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				products.add(productSupplier.get());
			}

			LocalDate orderDate = LocalDate.now();
			LocalDate deliveryDate = orderDate.plusDays(7);

			Order order = new Order(orderDate, deliveryDate, products, customer);
			System.out.println("Prodotti per il cliente " + customer.getName() + ":");
			products.forEach(p -> System.out.println(p));
			System.out.println("Ordine per il cliente " + customer.getName() + ":");
			System.out.println(order);
			System.out.println();
		}
	}
}
