package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	public Date moment;
	public OrderStatus status;
	public Client client;

	List<OrderItem> orderItemList = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void addItem(OrderItem item) {
		orderItemList.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItemList.remove(item);
	}

	public Double total() {
		Double total = 0.0;
		for (OrderItem item : orderItemList) {
			total += (item.getPrice() * item.getQuantity());
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + moment + "\n");
		sb.append("Order status: " + status + "\n");
		client.toString();
		sb.append("Order items: \n");
		for (OrderItem item : orderItemList) {
			sb.append(item.getProduct().getName() + "," + item.getPrice() + ", Quantity: " + item.getQuantity()
					+", Subtotal: " + String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append(total());
		return sb.toString();
	}

}
