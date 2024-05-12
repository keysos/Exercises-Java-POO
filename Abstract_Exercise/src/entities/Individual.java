package entities;

public class Individual extends Person {

	private Double healthBills;

	public Individual(String name, Double annualIncome, Double healthBills) {
		super(name, annualIncome);
		this.healthBills = healthBills;
	}

	public Individual() {

	}

	public Double getHealthBills() {
		return healthBills;
	}

	public void setHealthBills(Double healthBills) {
		this.healthBills = healthBills;
	}

	@Override
	public Double taxCalculation() {
		Double taxes = 0.0; 
		if (getAnnualIncome() < 20000) {
			taxes = getAnnualIncome() * 0.15;
		} 
		else if (getAnnualIncome() >= 20000) {
			taxes = getAnnualIncome() * 0.25;
		}
		double healthBillsTax = healthBills;
		healthBillsTax *= 0.50;
		taxes -= healthBillsTax;

		return taxes;
	}

	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", taxCalculation());
	}

}
