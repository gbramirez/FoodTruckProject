package com.skilldistillery.app;

public class FoodTruck {

//	private static int counter = 0;

	private int id;
	private String truckName;
	private String truckFood;
	private double truckRating;
	private static int truckId = 999;

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String truckFood, int truckRating) {
		this.truckName = truckName;
		this.truckFood = truckFood;
		this.truckRating = truckRating;
		this.id = id;
		truckId++;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTruckFood() {
		return truckFood;
	}

	public void setTruckFood(String truckFood) {
		this.truckFood = truckFood;
	}

	public double getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(double truckRating) {
		this.truckRating = truckRating;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id + truckId;
	}

	public static int getTruckId() {
		return truckId;
	}

	public static void setTruckId(int truckID) {
		FoodTruck.truckId = truckId;
		truckId++;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Truck Name: ").append(truckName).append(", Food Type: ").append(truckFood)
				.append(", Rating: ").append(truckRating).append(", and truckID: ").append(id).append(".");
		return builder.toString();
	}

	public void displayTruck() {
		String truckData = this.toString();
		System.out.println(truckData);
	}
}