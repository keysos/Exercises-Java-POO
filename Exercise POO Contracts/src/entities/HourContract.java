package entities;

import java.util.Date;

public class HourContract {

	public Date date;
	public Double valuePerHour;
	public Integer hour;

	public HourContract() {

	}

	public HourContract(Date date, Double valuePerHour, Integer hour) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public double TotalValue() {
		return hour * valuePerHour;
	}

}
