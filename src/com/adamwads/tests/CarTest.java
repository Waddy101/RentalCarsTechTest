package com.adamwads.tests;

import org.junit.Test;

import com.adamwads.models.Car;
import com.adamwads.classes.MainPart2;

import static org.junit.Assert.assertEquals;

public class CarTest {
	
	MainPart2 main = new MainPart2();
	
	//Testing getCarType() method
    @Test
    public void testCarType1() {	
	    Car car = new Car();
	    car.setSipp("MCMR");
	    assertEquals("Mini", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
	@Test
	public void testCarType2() {
	    Car car = new Car();
	    car.setSipp("ETAR");
	    assertEquals("Economy", car.getCarType(main.getCAR_TYPE_SPEC()));
	}
   
    @Test
    public void testCarType3() {	
 	    Car car = new Car();
	    car.setSipp("CDMR");
	    assertEquals("Compact", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType4() {
	    Car car = new Car();
	    car.setSipp("IVMR");
	    assertEquals("Intermediate", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType5() {	
    	Car car = new Car();
    	car.setSipp("SDMR");
    	assertEquals("Standard", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType6() {	 
	  	Car car = new Car();
	  	car.setSipp("FDMR");
	   	assertEquals("Full size", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType7() {	
    	Car car = new Car();
    	car.setSipp("PDMR");
    	assertEquals("Premium", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType8() {	 
    	Car car = new Car();
    	car.setSipp("LDMR");
    	assertEquals("Luxury", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarType9() {	  
    	Car car = new Car(); 
    	car.setSipp("XDMR");
    	assertEquals("Special", car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarTypeInvalid1() {	  
    	Car car = new Car(); 
    	car.setSipp("QDMR");
    	assertEquals(null, car.getCarType(main.getCAR_TYPE_SPEC()));
    }
   
    @Test
    public void testCarTypeInvalid2() {	  
    	Car car = new Car(); 
    	car.setSipp("Z7MR");
    	assertEquals(null, car.getCarType(main.getCAR_TYPE_SPEC()));
    }
    
    //Testing getCarDoorsType() method
    @Test
    public void testCarDoorsType1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MBMR");
 	   assertEquals("2 doors", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MCMR");
 	   assertEquals("4 doors", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType3() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MDMR");
 	   assertEquals("5 doors", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType4() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MWMR");
 	   assertEquals("Estate", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType5() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MTMR");
 	   assertEquals("Convertible", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType6() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MFMR");
 	   assertEquals("SUV", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType7() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MPMR");
 	   assertEquals("Pick up", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType8() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MVMR");
 	   assertEquals("Passenger Van", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsType9() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MXMR");
 	   assertEquals("Special", car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsTypeInvalid1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQMR");
 	   assertEquals(null, car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    @Test
    public void testCarDoorsTypeInvalid2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("M3MR");
 	   assertEquals(null, car.getCarDoorsType(main.getCAR_DOORS_TYPE_SPEC()));
    }
    
    //Testing getTransmission() method
    @Test
    public void testTransmission1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQMR");
 	   assertEquals("Manual", car.getTransmission(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testTransmission2() {	  
 	   Car car = new Car();
 	   car.setSipp("MQAR");
 	   assertEquals("Automatic", car.getTransmission(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testTransmissionInvalid1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQZR");
 	   assertEquals(null, car.getTransmission(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testTransmissionInvalid2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQ1R");
 	   assertEquals(null, car.getTransmission(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    //Testing getFuelAndAirCon() method
    @Test
    public void testFuelAndAirCon1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQMN");
 	   assertEquals("Petrol,No Air Conditiong", car.getFuelAndAirCon(main.getCAR_FUEL_AC_SPEC()));
    }
    
    @Test
    public void testFuelAndAirCon2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQMR");
 	   assertEquals("Petrol,Air Conditiong", car.getFuelAndAirCon(main.getCAR_FUEL_AC_SPEC()));
    }
    
    @Test
    public void testFuelAndAirConInvalid1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQMQ");
 	   assertEquals(null, car.getFuelAndAirCon(main.getCAR_FUEL_AC_SPEC()));
    }
    
    @Test
    public void testFuelAndAirConInvalid2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MQM4");
 	   assertEquals(null, car.getFuelAndAirCon(main.getCAR_FUEL_AC_SPEC()));
    }
    
    //Testing getVehicleScore() method
    @Test
    public void testVehicleScore1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MBMN");
 	   assertEquals(1, car.getVehicleScore(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testVehicleScore2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("CDMR");
 	   assertEquals(3, car.getVehicleScore(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testVehicleScore3() {	  
 	   Car car = new Car(); 
 	   car.setSipp("CDAN");
 	   assertEquals(5, car.getVehicleScore(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test
    public void testVehicleScore4() {	  
 	   Car car = new Car(); 
 	   car.setSipp("XPAR");
 	   assertEquals(7, car.getVehicleScore(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    @Test(expected=NullPointerException.class)
    public void testVehicleScoreInvalid() {	  
 	   Car car = new Car(); 
 	   car.setSipp("XPZQ");
 	   assertEquals(0, car.getVehicleScore(main.getCAR_TRANSMISSION_SPEC()));
    }
    
    //Testing getVehicleScorePlusSupplierRating() method
    @Test
    public void testVehicleScorePlusSupplierRating1() {	  
 	   Car car = new Car(); 
 	   car.setSipp("MBMN");
 	   //Vehicle Score = 1
 	   car.setRating(5.0);
 	   assertEquals(6.0, car.getVehicleScorePlusSupplierRating(main.getCAR_TRANSMISSION_SPEC()), 0.1);
    }
    
    @Test
    public void testVehicleScorePlusSupplierRating2() {	  
 	   Car car = new Car(); 
 	   car.setSipp("CDMR");
 	   //Vehicle Score = 3
 	   car.setRating(7.0);
 	   assertEquals(10.0, car.getVehicleScorePlusSupplierRating(main.getCAR_TRANSMISSION_SPEC()), 0.1);
    }
    
    @Test
    public void testVehicleScorePlusSupplierRating3() {	  
 	   Car car = new Car(); 
 	   car.setSipp("CDAN");
 	   //Vehicle Score = 5
 	   car.setRating(8.0);
 	   assertEquals(13.0, car.getVehicleScorePlusSupplierRating(main.getCAR_TRANSMISSION_SPEC()), 0.1);
    }
    
    @Test
    public void testVehicleScorePlusSupplierRating4() {	  
 	   Car car = new Car(); 
 	   car.setSipp("XPAR");
 	   //Vehicle Score = 7
 	   car.setRating(3.0);
 	   assertEquals(10.0, car.getVehicleScorePlusSupplierRating(main.getCAR_TRANSMISSION_SPEC()), 0.1);
    }
    
    @Test(expected=NullPointerException.class)
    public void testVehicleScorePlusSupplierRating5() {	  
 	   Car car = new Car(); 
 	   car.setSipp("XPZQ");
 	   //Vehicle Score = 0
 	   car.setRating(1.0);
 	   assertEquals(1.0, car.getVehicleScorePlusSupplierRating(main.getCAR_TRANSMISSION_SPEC()), 0.1);
    }
    
    //Testing my Price comparator works correctly
    @Test
    public void testPriceComparator1GreaterThan2() {	  
 	   Car car1 = new Car("","",300.0,"", 5.0); 
 	   Car car2 = new Car("","",150.0,"", 7.0);
 	   int result = Car.getPriceComparator().compare(car1, car2);
 	   assertEquals(1, result);
    }
    
    @Test
    public void testPriceComparator1LessThan2() {	  
 	   Car car1 = new Car("","",150.0,"", 5.0); 
 	   Car car2 = new Car("","",300.0,"", 7.0);
 	   int result = Car.getPriceComparator().compare(car1, car2);
	   assertEquals(-1, result);
	}
    
    @Test
    public void testPriceComparatorEqual() {	  
 	   Car car1 = new Car("","",150.0,"", 5.0); 
 	   Car car2 = new Car("","",150.0,"", 7.0);
 	   int result = Car.getPriceComparator().compare(car1, car2);
	   assertEquals(0, result);   
    }
    
    //Testing my Rating comparator works correctly, note the values are switched because this is
    //Being sorted in descending order rather than ascending order
    @Test
    public void testRatingComparator1GreaterThan2() {	  
 	   Car car1 = new Car("","",300.0,"", 7.0); 
 	   Car car2 = new Car("","",150.0,"", 5.0);
 	   int result = Car.getRatingComparator().compare(car1, car2);
 	   assertEquals(-1, result);
    }
    
    @Test
    public void testRatingComparator1LessThan2() {	  
 	   Car car1 = new Car("","",150.0,"", 5.0); 
 	   Car car2 = new Car("","",300.0,"", 7.0);
 	   int result = Car.getRatingComparator().compare(car1, car2);
	   assertEquals(1, result);
	}
    
    @Test
    public void testRatingComparatorEqual() {	  
 	   Car car1 = new Car("","",150.0,"", 5.0); 
 	   Car car2 = new Car("","",150.0,"", 5.0);
 	   int result = Car.getRatingComparator().compare(car1, car2);
	   assertEquals(0, result);   
    }
    
    //Testing my SumOfScores comparator works correctly, note the values are switched because this is
    //Being sorted in descending order rather than ascending order
    @Test
    public void testSumOfScoresComparator1GreaterThan2() {	  
 	   Car car1 = new Car("CDAR","",300.0,"", 7.0); 
 	   Car car2 = new Car("CDMR","",150.0,"", 5.0);
 	   int result = Car.getSumOfScoresComparator(main.getCAR_TRANSMISSION_SPEC()).compare(car1, car2);
 	   assertEquals(-1, result);
    }
    
    @Test
    public void testSumOfScoresComparator1LessThan2() {	  
 	   Car car1 = new Car("CDMR","",150.0,"", 5.0); 
 	   Car car2 = new Car("CDAR","",300.0,"", 7.0);
 	   int result = Car.getSumOfScoresComparator(main.getCAR_TRANSMISSION_SPEC()).compare(car1, car2);
	   assertEquals(1, result);
	}
    
    @Test
    public void testSumOfScoresComparatorEqual() {	  
 	   Car car1 = new Car("CDMR","",150.0,"", 5.0); 
 	   Car car2 = new Car("CDMR","",150.0,"", 5.0);
 	   int result = Car.getSumOfScoresComparator(main.getCAR_TRANSMISSION_SPEC()).compare(car1, car2);
	   assertEquals(0, result);   
    }
}

