package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class FilterFlights<getPosPasteDeparture> {

    static LocalDateTime dateTime = LocalDateTime.now();
    static final int groundTimeLimit = 2;

    public static boolean checkPasteDeparture(Flight flight) {

        List<Segment> segments = flight.getSegments();
        LocalDateTime departureDate = segments.get(0).getDepartureDate();
        return dateTime.isAfter(departureDate);
    }

    public static boolean checkDepartureBeforeArriving(Flight flight) {

        List<Segment> segments = flight.getSegments();
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLimitTimeInGround(Flight flight) {

        List<Segment> segments = flight.getSegments();
        int sumHours = 0;

        for (int i = 1; i < segments.size(); i++) {

            sumHours += getSubtractionDateToHours(segments.get(i).getDepartureDate(),
                    segments.get(i - 1).getArrivalDate());
        }
        return sumHours < groundTimeLimit;
    }

    private static int getSubtractionDateToHours(LocalDateTime dateTime1, LocalDateTime dateTime2) {

        Date date1 = convertToDateFromLDT(dateTime1);
        Date date2 = convertToDateFromLDT(dateTime2);

        long milliseconds = date1.getTime() - date2.getTime();
        int seconds = (int) (milliseconds / (1000));
        int minutes = (int) (milliseconds / (60 * 1000));
        int hours = (int) (milliseconds / (60 * 60 * 1000));

        return hours;
    }

    private static Date convertToDateFromLDT(LocalDateTime localDateTime) {
        return java.util.Date
                .from(localDateTime.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

}
