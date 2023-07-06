package Esercizio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

import com.github.javafaker.Faker;

public class Esercizio {

	public static void main(String[] args) {
		Faker f = new Faker(Locale.ITALY);
//ID che uso per clienti, prodotti e ordini
		Supplier<Long> idSupplier = () -> {
			Random rndmId = new Random();
			return rndmId.nextLong(900) + 100;
		};
//tier per i clienti
		Supplier<Integer> tierSupplier = () -> {
			Random rndmTier = new Random();
			return rndmTier.nextInt(10) + 1;
		};
//CLIENTI
		Supplier<Customer> customersSupplier = () -> {
			return new Customer(idSupplier.get(), f.name().firstName(), tierSupplier.get());
		};
//date per gli ordini

		Supplier<LocalDate> randomDateSupplier = () -> {
			LocalDate today = LocalDate.now();
			LocalDate fourYearAgo = today.minusYears(4);

			long days = today.toEpochDay() - fourYearAgo.toEpochDay();
			Random random = new Random();
			System.out.println(days);
			return fourYearAgo.plusDays(random.nextInt((int) days));

		};

		List<LocalDate> date = new ArrayList<LocalDate>();
		for (int i = 0; i < 10; i++) {
			date.add(randomDateSupplier.get());
		}

		date.forEach(d -> System.out.println(d));

		List<Customer> customers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			customers.add(customersSupplier.get());
		}

		customers.forEach(c -> System.out.println(c));
	}


}
