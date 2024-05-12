package entities;

public class ImportedProduct extends Product {

	private Double customFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	@Override
	public final String priceTag() {
		return name + " $ " + String.format("%.2f", price) + " (Custom fee: $ " + String.format("%.2f", customFee) + ")";
	}
	
	public Double totalPrice() {
		return price + customFee;
	}

}
