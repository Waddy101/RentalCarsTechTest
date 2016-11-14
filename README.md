# RentalCarsTechTest

An application to prove technical ability for a RentalCars.com interview

The application uses Jax-RS, RESTeasy and GSON to take the information from a .json file and display it in a readable format to the user. 

It is a maven project so requires maven to be installed, or an IDE to be used to resolve the necessary dependencies on GSON, JAX-RS and RESTeasy when running the .java files directly, the .war file however contains the necessary dependencies.

# Part 1

To run part 1 run the MainPart1.java class that contains code to output the data to the console

# Part 2 

Use the below REST URLs when the .war is hosted on an Apache Tomcat v9.0 server to access the data viewed as HTML, whilst not strictly RESTful because it's HTML and not easy parseable by other programs it is the easiest way to present the data in a human readable way

# REST URLs

To print the list of vehicles ordered by price use the URL
[server address]/RentalCarsTechTest/vehicleList/priceOrder

To print the list of vehicles and their specifications use the URL
[server address]/RentalCarsTechTest/vehicleList/specification

To print the list of highest rated suppliers per vehicle type use the URL
[server address]/RentalCarsTechTest/vehicleList/highestRatedSupplier

To print the list of vehicles and their scores based on their specification use the URL
[server address]/RentalCarsTechTest/vehicleList/vehicleScores
