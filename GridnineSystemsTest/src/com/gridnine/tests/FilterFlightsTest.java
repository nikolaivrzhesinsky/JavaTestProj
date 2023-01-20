package com.gridnine.tests;

import com.gridnine.testing.FilterFlights;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gridnine.testing.FilterFlights.checkPasteDeparture;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@DisplayName("Flight filter tests")
class FilterFlightsTest {

    List<Flight> flightListTest;

    @BeforeEach
    void prepareFlights() {
        flightListTest = FlightBuilder.createFlights();
    }

    @Test
    void checkForPrevDatesTrue() {
        assertTrue(FilterFlights.checkPasteDeparture(flightListTest.get(2)));
    }

    @Test
    void checkForPrevDatesFalse() {
        assertFalse(FilterFlights.checkPasteDeparture(flightListTest.get(1)));
    }

    @Test
    void checkDepartureBeforeArrivingTrue() {
        assertTrue(FilterFlights.checkDepartureBeforeArriving(flightListTest.get(3)));
    }

    @Test
    void checkLimitTimeInGroundFalse() {
        assertFalse(FilterFlights.checkLimitTimeInGround(flightListTest.get(5)));
    }

}