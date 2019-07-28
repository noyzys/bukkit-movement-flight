package me.noyzys.flight;

import org.jetbrains.annotations.Contract;

/**
 * @author: NoyZys, 12:27 28.07.2019
 **/
public final class FlightParser {

    @Contract(pure = true)
    private FlightParser(Flight flight) {
        FlightParser.flight = flight;
    }

    private static Flight flight;

    public static String parseFlightStatus(boolean b){
        return b ? flight.getFlightConfiguration()
                .getBooleanOn() : flight.getFlightConfiguration()
                .getBooleanOff();
    }
}
