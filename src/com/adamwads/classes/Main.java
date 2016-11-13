package com.adamwads.classes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.adamwads.models.Car;
import com.google.gson.*;

/**
 * A class implementing the brief given by Rentalcars.com for their technical test
 * @author Adam Wadsworth
 *
 */
@Path("/vehicleList")
public class Main {
	
	private static String JSON_URL = "http://www.rentalcars.com/js/vehicles.json";
	
	private static List<Car> cars;
	public static Map<String, String> CAR_TYPE_SPEC;
	public static Map<String, String> CAR_DOORS_TYPE_SPEC;
	public static Map<String, String> CAR_TRANSMISSION_SPEC;
	public static Map<String, String> CAR_FUEL_AC_SPEC;
	
	//Get methods used in testing
	public Map<String, String> getCAR_TYPE_SPEC() {
		return CAR_TYPE_SPEC;
	}

	public Map<String, String> getCAR_DOORS_TYPE_SPEC() {
		return CAR_DOORS_TYPE_SPEC;
	}

	public Map<String, String> getCAR_TRANSMISSION_SPEC() {
		return CAR_TRANSMISSION_SPEC;
	}

	public Map<String, String> getCAR_FUEL_AC_SPEC() {
		return CAR_FUEL_AC_SPEC;
	}
	
	public Main() {
		cars = getListOfCars();
		populateCarSpecification();
	}
	
	/**
	 * A class that gets the list of cars from the .json file provided by rentalcars, deserializes the data
	 * and then returns a list of the cars as POJOs
	 * @return	A list of cars as Car objects
	 */
	private List<Car> getListOfCars() {		
		Gson gson = new Gson();
		try {
			URL url = new URL(JSON_URL);
			InputStreamReader reader = new InputStreamReader(url.openStream());			
			JSONDeserializer parsedFile = gson.fromJson(reader, JSONDeserializer.class);
			List<Car> cars = parsedFile.getSearch().getVehicleList();
			return cars;
		} catch (IOException e) {
			System.out.println("An error has occured reading the file from the URL");
		}
		return null;
	}
	
	/**
	 * Returns the list of cars in price order displayed in a HTML table
	 * (I'm aware that this may not be 100% "RESTful" but it is easier to read and seemed the best option for the brief)
	 * @return The list of cars in price order
	 */
	@GET
	@Path("/printPriceOrder")
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
				output = output + String.format("<tr><td>%4d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", i, car.getName(), car.getSipp(), type, doorsType, transmission, fuel, airCon);
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
	
	/**
	 * Populates 4 hashmaps that convert the sipp value into the text value associated with that sipp value
	 */
	private void populateCarSpecification() {
		
		//1st Letter of the sipp 
		CAR_TYPE_SPEC = new HashMap<>();
		CAR_TYPE_SPEC.put("M","Mini");
		CAR_TYPE_SPEC.put("E","Economy");
		CAR_TYPE_SPEC.put("C","Compact");
		CAR_TYPE_SPEC.put("I","Intermediate");
		CAR_TYPE_SPEC.put("S","Standard");
		CAR_TYPE_SPEC.put("F","Full size");
		CAR_TYPE_SPEC.put("P","Premium");
		CAR_TYPE_SPEC.put("L","Luxury");
		CAR_TYPE_SPEC.put("X","Special");
		
		//2nd Letter of the sipp
		CAR_DOORS_TYPE_SPEC = new HashMap<>();
		CAR_DOORS_TYPE_SPEC.put("B","2 doors");
		CAR_DOORS_TYPE_SPEC.put("C","4 doors");
		CAR_DOORS_TYPE_SPEC.put("D","5 doors");
		CAR_DOORS_TYPE_SPEC.put("W","Estate");
		CAR_DOORS_TYPE_SPEC.put("T","Convertible");
		CAR_DOORS_TYPE_SPEC.put("F","SUV");
		CAR_DOORS_TYPE_SPEC.put("P","Pick up");
		CAR_DOORS_TYPE_SPEC.put("V","Passenger Van");
		//Not sure about this one because the VW Golf has X as its 2nd Sipp value but that isnt specified in the table
		//I added this so that it prints out special for X but not sure it's correct
		CAR_DOORS_TYPE_SPEC.put("X","Special");
		
		//3rd letter of the sipp
		CAR_TRANSMISSION_SPEC = new HashMap<>();
		CAR_TRANSMISSION_SPEC.put("M", "Manual");
		CAR_TRANSMISSION_SPEC.put("A", "Automatic");
		
		//4th letter of the sipp
		CAR_FUEL_AC_SPEC  = new HashMap<>();
		CAR_FUEL_AC_SPEC.put("N", "Petrol,No Air Conditiong");
		CAR_FUEL_AC_SPEC.put("R", "Petrol,Air Conditiong");
	}

}
