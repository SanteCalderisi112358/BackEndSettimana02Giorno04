package Esercizio01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.slf4j.LoggerFactory;

public class Prove {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Esercizio.class);

	public static void main(String[] args) {

//********THREAD CREATO CON LAMBDA FUNCTION**********//	
//		Runnable r1 = () -> {
//			for (int i = 0; i < 10; i++) {
//				log.info("ciao");
//			}
//		};
//
//		Runnable r2 = () -> {
//			int a = 9;
//			int b = 11;
//			for (int i = 0; i < 10; i++) {
//				int somma = a + b;
//				log.info("La somma è: " + somma);
//			}
//
//		};
//		Thread thread2 = new Thread(r2);
//		Thread thread1 = new Thread(r1);
//		thread1.start();
//		try {
//			thread1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		thread2.start();

//**********FOREACH CON COLLECTION **********//

		Map<String, Integer> list = new HashMap<>();
		list.put("Sante", 33);
		list.put("Erika", 30);
		list.put("Gaetano", 85);
		list.put("Luca", 15);
		list.put("Manuela", 18);
		list.put("Giorgio", 100);
		list.put("Antonio", 33);
		list.put("Piero", 54);
		list.put("Luca", 70);
//
//		list.forEach((nome, eta) -> log.info(nome + " ha " + eta + " anni"));
//
//		log.info("********************");
//		list.keySet().removeIf(nome -> nome.equals("Luca"));
//		list.forEach((nome, eta) -> log.info(nome + " ha " + eta + " anni"));

		// *********** FUNCTIONAL INTERFACE CUSTOM **********//

//		Prova inverter = (str) -> {
//			String[] strSplit = str.split("");
//			String finale = "";
//			for (int i = strSplit.length - 1; i >= 0; i--) {
//				finale += strSplit[i];
//			}
//
//			return finale;
//		};
//
//		System.out.println(inverter.modify("ciao mondo"));

		// **********PREDICATE***********//
		// esempio di utilizzo di un
		// Predicate per filtrare Map creato (nome,eta) in base all'età

		Predicate<Integer> maggiorenne = eta -> eta > 60;
		Predicate<Integer> minorenne = eta -> eta < 30;
		Predicate<Integer> etaCompresa = maggiorenne.or(minorenne);
		// Map<String, Integer> risultato = new HashMap<>();
		// System.out.println("Ha più di 60 anni o meno di 30");
//		for (Map.Entry<String, Integer> entry : list.entrySet()) {
//			if (etaCompresa.test(entry.getValue())) {
//
//				System.out.println(entry.getKey());
//			}
//		}

//		Predicate<String> isThere = nome -> nome == "Luca";
//
//		Map<String, Integer> risultatoPresenza = new HashMap<String, Integer>();
//		for(Map.Entry<String, Integer> entry : list.entrySet()) {
//			if (isThere.test(entry.getKey())) {
//				System.out.println("Nell'elenco esiste un " + entry.getKey() + " e ha " + entry.getValue() + " anni");
//			} else {
//				System.out.println("Non esiste nessun " + entry.getKey() + " nell'elenco.");
//			}
//		}

		// **********SUPPLIER***********//
		Supplier<List<Integer>> randomNumberSupplier = () -> {
			List<Integer> array = new ArrayList<>();
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				array.add(random.nextInt(100));
			}
			return array;
		};

		Supplier<int[]> randomNumberSupplierArray = () -> {
			int[] array = new int[10];
			Random random = new Random();
			for (int i = 0; i < array.length; i++) {
				array[i] = random.nextInt(100);
			}
			return array;
		};

		int[] arrayRandomNumber = randomNumberSupplierArray.get();
		System.out.println(Arrays.toString(arrayRandomNumber));
		List<Integer> randomNumber = randomNumberSupplier.get();
		System.out.println(randomNumber);

		// ***** PREDICATE E SUPPLIER **********//

		Predicate<Integer> isEven = (n) -> n % 2 == 0;
		System.out.println("Numeri pari");
		randomNumber.stream().filter(isEven).forEach(el -> System.out.println(el));
		
		Supplier<Integer> randomNumberSupplier1 = () -> new Random().nextInt(10) + 1;

	}

}
