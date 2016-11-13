package com.adamwads.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.adamwads.models.Car;

/**
 * A class implementing part 2 of the brief given by Rentalcars.com for their technical test
 * @author Adam Wadsworth
 *
 */
@Path("/vehicleList")
public class MainPart2 extends MainPart1 {
			
	public MainPart2() {
		cars = getListOfCars();
		populateCarSpecification();
	}
		
	/**
	 * Returns the list of cars in price order displayed in a HTML table
	 * (I'm aware that this may not be 100% "RESTful" but it is easier to read and seemed the best option for the brief)
	 * @return The list of cars in price order
	 */
	@GET
	@Path("/printPriceOrder")
	@Override
	public String printPriceOrder() {
		if(!cars.isEmpty()){
			Collections.sort(cars, Car.getPriceComparator());
			int i = 1;
			String output = "<table><tr><th>No.</th><th>Car Name</th><th>Price</th></tr>";
			for (Car car : cars) {
				output = output + String.format("<tr><td>%d</td><td>%s</td><td>%.2f</td></tr>", i, car.getName(), car.getPrice());
				i++;
			}
			return output + "</table>";
		} else {
			return "The .json file could not be found";
		}
	}
	
	/**
	 * Returns the list of cars and their specifications displayed in a HTML table
	 * @return The list of cars and their specifications
	 */
	@GET
	@Path("/printSpecification")
	@Override
	public String printSpecification() {
		if(!cars.isEmpty()){
			int i = 1;
			String output = "<table><tr><th>No.</th><th>Car Name</th><th>Sipp</th><th>Car Type</th><th>Doors/2nd Type</th><th>Transmission</th><th>Fuel Type</th><th>Air Con</th></tr>";
			for (Car car : cars) {
				String type = car.getCarType(CAR_TYPE_SPEC);
				String doorsType = car.getCarDoorsType(CAR_DOORS_TYPE_SPEC);
				String transmission = car.getTransmission(CAR_TRANSMISSION_SPEC);
				String fuelAndAirCon = car.getFuelAndAirCon(CAR_FUEL_AC_SPEC);
				String fuel = fuelAndAirCon.split(",")[0];
				String airCon = fuelAndAirCon.split(",")[1];
				output = output + String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", i, car.getName(), car.getSipp(), type, doorsType, transmission, fuel, airCon);
				i++;
			}
			return output + "</table>";
		} else {
			return "The .json file could not be found";
		}
	}
	
	/**
	 * Returns a list of the highest rated supplier for each car type
	 * @return The highest rated supplier for each car type
	 */
	@GET
	@Path("/printHighestRatedSupplier")
	@Override
	public String printHighestRatedSupplier() {
		if(!cars.isEmpty()){
			List<Car> highestRatings = new ArrayList<Car>();
			List<Car> tempList = new ArrayList<Car>();
			
			for (String type : CAR_TYPE_SPEC.keySet()) {
				for (Car car: cars) {
					if (car.getSipp().substring(0,1).equals(type)) {
						tempList.add(car);
					}	
				}
				Collections.sort(tempList, Car.getRatingComparator());
				if(!tempList.isEmpty()) highestRatings.add(tempList.get(0));
				tempList.clear();
			}
			
			int i = 1;
			String output = "<table><tr><th>No.</th><th>Car Name</th><th>Type</th><th>Supplier</th><th>Rating</th></tr>";
			for (Car car : highestRatings) {
				output = output + String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%1.1f</td></tr>", i, car.getName(), car.getCarType(CAR_TYPE_SPEC), car.getSupplier(), car.getRating());
				i++;
			}
			return output + "</table>";
		} else {
			return "The .json file could not be found";
		}
	}
	
	/**
	 * Returns the list of cars and their associated vehicle scores in descending order
	 * @return The list of cars and their associated vehicle score in descending order
	 */
	@GET
	@Path("/printVehicleScores")	
	@Override
	public String printVehicleScores() {
		if(!cars.isEmpty()){
			Collections.sort(cars, Car.getSumOfScoresComparator(CAR_TRANSMISSION_SPEC));
			int i = 1;
			String output = "<table><tr><th>No.</th><th>Car Name</th><th>Vehicle Score</th><th>Rating</th><th>Sum of Scores</th></tr>";
			for (Car car : cars) {
				output = output + String.format("<tr><td>%d</td><td>%s</td><td>%d</td><td>%.1f</td><td>%.1f</td></tr>", i, car.getName(), car.getVehicleScore(CAR_TRANSMISSION_SPEC), car.getRating(), car.getVehicleScorePlusSupplierRating(CAR_TRANSMISSION_SPEC));
				i++;
			}
			return output + "</table>";
		} else {
			return "The .json file could not be found";
		}
	}
	
}