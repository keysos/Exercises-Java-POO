package entities;

public class OrderItem {

	public Integer quantity;
	public Double price;
	public Product product;

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order items: \n");
		sb.append(product.getName() + "," + price + ", Quantity: " + quantity + ", Subtotal: "
				+ String.format("%.2f", subTotal()) + "\n");
		return sb.toString();
	}

}
