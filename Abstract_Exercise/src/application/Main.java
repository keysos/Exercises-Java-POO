package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiConsumer;

import entities.Company;
import entities.Individual;
import entities.Person;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<Person> taxPayers = new ArrayList<Person>();

		System.out.print("Enter the number of tax payers: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data: ");
			System.out.print("Indivudal or company: (i/c) ");
			char character = scanner.next().charAt(0);
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = scanner.nextDouble();
			if (character == 'i') {
				System.out.print("Health expenditures ");
				Double healthBills = scanner.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, healthBills));
			} else {
				System.out.print("Number of employees: ");
				Integer workersQuantity = scanner.nextInt();
				taxPayers.add(new Company(name, anualIncome, workersQuantity));
			}
		}

		System.out.println("");
		System.out.println("TAXES PAID: ");
		
		double totalTaxes = 0;

		for (Person person : taxPayers) {
			System.out.println(person);
			totalTaxes += person.taxCalculation();
			
		}
		System.out.println("TOTAL TAXES: ");
		System.out.println(totalTaxes);
		

		scanner.close();

	}

}
