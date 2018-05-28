package com.carrental.grammar.classTest;

public class Rental {
	private int rentalId;
	private float estimatedRentalPrice;
	private boolean open;
	private Driver driver;
	private Creditcard creditCard;
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public float getEstimatedRentalPrice() {
		return estimatedRentalPrice;
	}
	public void setEstimatedRentalPrice(float estimatedRentalPrice) {
		this.estimatedRentalPrice = estimatedRentalPrice;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Creditcard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(Creditcard creditCard) {
		this.creditCard = creditCard;
	}
	
}
