package com.skilldistillery.app;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		FoodTruckApp foodTruckApp = new FoodTruckApp();

		foodTruckApp.startApp(keyboard, foodTruckApp);

		keyboard.close();
	}

	public void startApp(Scanner keyboard, FoodTruckApp foodTruckApp) {
		System.out.println("Welcome to Food Truck Rater!");
		FoodTruck[] ftrucks = foodTruckApp.inputTruck(keyboard);

		boolean menuScreen = true;
		while (menuScreen) {
			foodTruckApp.showMenu();
			menuScreen = foodTruckApp.menuChoice(keyboard, ftrucks);
		}
	}

	public FoodTruck[] inputTruck(Scanner keyboard) {
		System.out.println("\nHow many food trucks would you like to rate?");
		System.out.print("\nPlease choose between 1 - 5: ");
		int arrIndex = keyboard.nextInt();

		FoodTruck[] truckArr = new FoodTruck[arrIndex];

		String truckFood;
		int truckRating = -1;

		for (int i = 0; i < truckArr.length; i++) {
			System.out.print("\nPlease enter the name of the food truck you would like to rate: ");
			String truckName = keyboard.next();

			if (truckName.equalsIgnoreCase("quit")) {
				FoodTruck[] earlyExitArr = Arrays.copyOf(truckArr, i);
				return earlyExitArr;
			} else {
				System.out.print("\nPlease enter the type of food " + truckName + " serves: ");
				truckFood = keyboard.next();
				System.out.println("\nYummy! " + truckFood + " is a great type of food!");

				do {
					System.out.print(
							"\nHow would you rate " + truckName + "'s " + truckFood + " on a scale from 1 - 5? : ");
					truckRating = keyboard.nextInt();

					if (truckRating == 0) {
						System.out.println("\nOh wow! That " + truckFood + " must have been awful.");

					} else if (truckRating == 1 || truckRating == 2) {
						System.out.println("\nHmm, that " + truckFood + " doesn't sound like it was very good.");
					} else if (truckRating == 3 || truckRating == 4) {
						System.out.println("\nAhh, that sounds like some decent " + truckFood + ".");
					} else if (truckRating == 5) {
						System.out.println("\nThat sounds like some amazing " + truckFood + "!");
					} else {
						System.out.println("\nPlease enter a rating between 1 - 5.");
					}
				} while (truckRating < 0 || truckRating > 5);

				truckArr[i] = new FoodTruck();
				truckArr[i].setTruckName(truckName);
				truckArr[i].setTruckName(truckName);
				truckArr[i].setTruckFood(truckFood);
				truckArr[i].setTruckRating(truckRating);
				truckArr[i].setid(i);
			}
		}

		return truckArr;

	}

	public void showMenu() {
		System.out.println("\n\tMenu: ");
		System.out.println("\nPress 1 to view all food trucks.");
		System.out.println("\nPress 2 to see the average rating of all food trucks.");
		System.out.println("\nPress 3 to display the highest rated food truck.");
		System.out.println("\nPress 4 to exit the program.");
	}

	public boolean menuChoice(Scanner keyboard, FoodTruck[] ftrucks) {
		int userChoice = 0;

		do {
			System.out.print("\nPlease enter your menu choice: ");
			userChoice = keyboard.nextInt();

			if (userChoice > 4 || userChoice < 1) {
				System.out.println("\nPlease choose an option between 1 - 5");
			}
		} while (userChoice > 4 || userChoice < 1);

		switch (userChoice) {
		case 1:
			displayTrucks(ftrucks);
			break;

		case 2:
			averageRating(ftrucks);
			break;

		case 3:
			bestTruck(ftrucks);
			break;

		case 4:
			System.out.println("\nThank you for using the Food Truck Rater! Goodbye!");
			return false;
		}
		return true;
	}

	public void displayTrucks(FoodTruck[] ftrucks) {
		System.out.println("\nOkay, these are all the food trucks!");

		for (int i = 0; i < ftrucks.length; i++) {
			System.out.println(ftrucks[i].toString());
		}
	}

	public void averageRating(FoodTruck[] ftrucks) {
		double rating = 0.0;

		for (int i = 0; i < ftrucks.length; i++) {
			rating += ftrucks[i].getTruckRating();
		}

		double average = rating / ftrucks.length * 1.0;
		double avgRate = (Math.round((average) * 100.0)) / 100.0;

		System.out.println("\nThe average food truck rating is: " + avgRate);
	}

	public void bestTruck(FoodTruck[] ftrucks) {
		double bestRate = ftrucks[0].getTruckRating();

		for (int i = 0; i < ftrucks.length; i++) {
			if (ftrucks[i].getTruckRating() > bestRate) {
				bestRate = ftrucks[i].getTruckRating();
			}
		}

		int tie = 0;
		for (int i = 0; i < ftrucks.length; i++) {
			if (bestRate == ftrucks[i].getTruckRating()) {
				tie++;
			}
		}

		if (tie > 1) {
			System.out.println("\nThe following trucks are tied in first place! " + tie + "");
		} else {
			System.out.println("\nThe best food truck by rating is: ");
		}

		for (int i = 0; i < ftrucks.length; i++) {
			if (bestRate == ftrucks[i].getTruckRating()) {
				System.out.println(ftrucks[i].toString());

			}
		}
	}
}