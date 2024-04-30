package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter client data: ");

		System.out.print("Name: ");
		String clientName = scanner.nextLine();
		System.out.print("Email: ");
		String clientEmail = scanner.nextLine();
		System.out.print("Birth date: (DD/MM/YYYY) ");
		Date clientBirthDate = sdf.parse(scanner.nextLine());
		Client client = new Client(clientName, clientEmail, clientBirthDate);

		System.out.println("Enter order data: ");
		Date orderMoment = calendar.getTime();
		System.out.print("Status: ");
		String orderStatus = scanner.nextLine();
		System.out.print("How many items to this order? ");
		Order order = new Order(orderMoment, OrderStatus.valueOf(orderStatus), client);
		int orderQuantity = scanner.nextInt();

		for (int i = 0; i < orderQuantity; i++) {
			System.out.println("Enter product " + (i + 1) + "# name: ");
			scanner.nextLine();
			System.out.print("Product name: ");
			String productName = scanner.nextLine();
			System.out.print("Product price: ");
			double productPrice = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Product quantity: ");
			int productQuantity = scanner.nextInt();	
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, product.getPrice(), product);
			order.addItem(orderItem);
		}

		System.out.println(order.toString());

		scanner.close();

	}

}
