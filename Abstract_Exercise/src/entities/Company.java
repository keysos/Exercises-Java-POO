package entities;

public class Company extends Person {

	private Integer workersQuantity;

	public Company(String name, Double annualIncome, Integer workersQuantity) {
		super(name, annualIncome);
		this.workersQuantity = workersQuantity;
	}

	public Company() {

	}

	public Integer getWorkersQuantity() {
		return workersQuantity;
	}

	public void setWorkersQuantity(Integer workersQuantity) {
		this.workersQuantity = workersQuantity;
	}

	@Override
	public Double taxCalculation() {
		Double taxes = 0.0;
		if (workersQuantity < 10) {
			taxes = getAnnualIncome() * 0.16;
		} else {
			taxes = getAnnualIncome() * 0.14;
		}

		return taxes;
	}

	public String toString() {
		return getName() + ": $ " + String.format("%.2f", taxCalculation());
	}

}
