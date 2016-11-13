package com.adamwads.classes;
import java.util.List;

import com.adamwads.models.Car;

/**
 * A class that performs deserilization on the provided .json file
 * so that the list of cars can be used as a list of POJOs
 * @author Adam Wadsworth
 */
public class JSONDeserializer {
	
	private Search Search;
	
	public Search getSearch() {
		return Search;
	}
	/**
	 * Extracts the array of cars from the "Search" value
	 * @author Adam
	 * @return The list of cars as a list of car objects
	 */
	public static class Search {
		private List<Car> VehicleList;

		public List<Car> getVehicleList() {
			return VehicleList;
		}

	}
	
}
