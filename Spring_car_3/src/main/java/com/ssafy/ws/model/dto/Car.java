package com.ssafy.ws.model.dto;

public class Car {

	private String vin;
	private String modelName;
	private String color;
	private int mileage;

	public Car(String vin, String modelName, String color, int mileage) {
		this.vin = vin;
		this.modelName = modelName;
		this.color = color;
		this.mileage = mileage;
	}

	public Car() {
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", modelName=" + modelName + ", color=" + color + ", mileage=" + mileage + "]";
	}

}
