package com.adamwads.models;

import java.util.Comparator;
import java.util.Map;

/**
 * An object representing a Car that contains it's sipp, name, price, supplier and rating and various methods
 * for acting on that data.
 * @author Adam Wadsworth
 *
 */
public class Car {
	private String sipp;
	private String name;
	private double price;
	private String supplier;
	private double rating;
		
	//Constructor only used for testing purposes
	public Car() {
		super();
	}
	
	//Constructor only used for testing purposes
	public Car(String sipp, String name, double price, String supplier, double rating) {
		super();
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getSipp() {
		return sipp;
	}
	
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	/**
	 * @return The cars type
	 */
	public String getCarType(Map<String, String> carTypeSpecification) {
		return carTypeSpecification.get(this.getSipp().substring(0,1));
	}
	
	/**
	 * @return The cars secondary type/ doors type
	 */
	public String getCarDoorsType(Map<String, String> carDoorsTypeSpecification) {
		return carDoorsTypeSpecification.get(this.getSipp().substring(1,2));
		
	}
	
	/**
	 * @return The cars transmission type
	 */
	public String getTransmission(Map<String, String> transmissionSpecification) {
		return transmissionSpecification.get(this.getSipp().substring(2,3));
	}
	
	/**
	 * @return The cars fuel type and air conditioning
	 */
	public String getFuelAndAirCon(Map<String, String> fuelAndACSpecification) {
		return fuelAndACSpecification.get(this.getSipp().substring(3,4));
	}
	
	/**
	 * @return The cars vehicle score
	 */
	public int getVehicleScore(Map<String, String> transmissionSpecification) {
		int score = 0;
		if (this.getTransmission(transmissionSpecification).equals("Manual")) score += 1;
		if (this.getTransmission(transmissionSpecification).equals("Automatic")) score += 5;
		if (this.getSipp().substring(3, 4).equals("R")) score += 2;
        return score;
	}
	
	/**
	 * @return The cars vehicle score added to the supplier rating
	 */
	public double getVehicleScorePlusSupplierRating(Map<String, String> transmissionSpecification) {
		return this.getVehicleScore(transmissionSpecification) + this.getRating();
	}
	
	/**
	 * A comparator for comparing the price of two different cars
	 * @return A comparator for comparing price
	 */
	public static Comparator<Car> getPriceComparator() {
		return new Comparator<Car>() {
			public int compare(Car car1, Car car2) {
				if (car1.getPrice() < car2.getPrice()) return -1;
				if (car1.getPrice() > car2.getPrice()) return 1;
				return 0;
			}
			
		};
	}
	
	/**
	 * A comparator for comparing the rating of two different cars
	 * @return A comparator for comparing rating
	 */
	public static Comparator<Car> getRatingComparator() {
		return new Comparator<Car>() {
			public int compare(Car car1, Car car2) {
				if (car1.getRating() < car2.getRating()) return 1;
				if (car1.getRating() > car2.getRating()) return -1;
				return 0;
			}
			
		};
	}
	
	/**
	 * A comparator for comparing the sum of the vehicle score and rating of two different cars
	 * @return A comparator for comparing the sum of vehicle score and rating
	 */
	public static Comparator<Car> getSumOfScoresComparator(Map<String, String> transmissionSpecification) {
		return new Comparator<Car>() {
			public int compare(Car car1, Car car2) {
				if (car1.getVehicleScorePlusSupplierRating(transmissionSpecification) < car2.getVehicleScorePlusSupplierRating(transmissionSpecification)) return 1;
				if (car1.getVehicleScorePlusSupplierRating(transmissionSpecification) > car2.getVehicleScorePlusSupplierRating(transmissionSpecification)) return -1;
				return 0;
			}
		};
	}
}
