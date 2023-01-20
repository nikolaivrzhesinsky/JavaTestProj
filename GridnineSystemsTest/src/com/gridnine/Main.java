package com.gridnine;

import com.gridnine.testing.FilterFlights;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightList = new ArrayList<>();
        flightList = FlightBuilder.createFlights();

        flightList.forEach(System.out::println);
        //1
        System.out.println("1.Past departure");
        flightList.stream().filter(s -> !(FilterFlights.checkPasteDeparture(s))).forEach(System.out::println);

        //2
        System.out.println("arriving after departure");
        flightList.stream().filter(s -> !(FilterFlights.checkDepartureBeforeArriving(s))).forEach(System.out::println);

        //3
        System.out.println("on the ground more then two hours");
        flightList.stream().filter(FilterFlights::checkLimitTimeInGround).forEach(System.out::println);
    }
}
