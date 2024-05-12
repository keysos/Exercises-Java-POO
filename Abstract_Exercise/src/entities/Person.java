package entities;

public abstract class Person {

	private String name;
	private double annualIncome;

	public Person(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double anualIncome) {
		this.annualIncome = anualIncome;
	}
	
	public abstract Double taxCalculation();

	public abstract String toString();

}
