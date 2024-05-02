package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> productList = new ArrayList<Product>();

		System.out.print("Enter the number of products: ");
		
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data: ");
			System.out.print("Common, used or imported? (c/u/i): ");
			String productType = scanner.nextLine().trim();
			System.out.print("Name: ");
			String productNameString = scanner.nextLine();
			System.out.print("Price: ");
			Double productPrice = scanner.nextDouble();
			scanner.nextLine();
			
			if (productType.equals("u")) {
				System.out.print("Manufacture date (dd/MM/yyyy): ");
				Date productDate = sdf.parse(scanner.nextLine());
				productList.add(new UsedProduct(productNameString, productPrice, productDate));
				
			} else if (productType.equals("i")) {
				System.out.print("Custom fee: ");
				Double productFee = scanner.nextDouble();
				scanner.nextLine();
				productList.add(new ImportedProduct(productNameString, productPrice, productFee));
				
			} else if (productType.equals("c")) {
				productList.add(new Product(productNameString, productPrice));
			}
			
		}
		
		System.out.println("PRICE TAGS: ");
		for (Product product : productList) {
			System.out.println(product.priceTag());
		}
		
		scanner.close();
	}
}
