package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("NAME: ");
		String workerName = sc.nextLine();
		System.out.print("LEVEL: ");
		String workerLevel = sc.nextLine();
		System.out.print("BASE SALARY: ");
		double workerDoubleSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerDoubleSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data: ");
			sc.nextLine();
			System.out.print("DATE (DD/MM/YYYY): ");
			Date contractDate = formatter.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			double contractValuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int contractHours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, contractValuePerHour, contractHours);
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String monthAndYear = sc.next();
		int y = Integer.parseInt(monthAndYear.substring(3));
		int m = Integer.parseInt(monthAndYear.substring(0, 2));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.incomeDouble(y, m)));

		sc.close();
	}
}
