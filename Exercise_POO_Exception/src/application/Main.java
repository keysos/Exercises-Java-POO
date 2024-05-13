package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = scanner.nextInt();
			System.out.print("Holder: ");
			String holder = scanner.nextLine();
			scanner.nextLine();
			System.out.println("Initial balance: ");
			double balance = scanner.nextDouble();
			System.out.println("Withdraw limit: ");
			double withdraw = scanner.nextDouble();
			Account account = new Account(null, holder, balance, withdraw);

			System.out.println("Enter amount to withdraw: ");
			double amount = scanner.nextDouble();
			account.withdraw(amount);
			System.out.println("New Balance: " + account.getBalance());
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Input mismatch error:");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		scanner.close();
	}

}
