package me.noyzys.flight;

import static me.noyzys.flight.FlightPlugin.getInstance;
/**
 * @author: NoyZys, 12:43 28.07.2019
 **/
public enum  FlightMessageType {

    COMMAND_ONLY_PLAYER(getInstance().getFlightConfiguration().getCommandOnlyPlayer()),
    PERMISSIONS(getInstance().getFlightConfiguration().getPermissions()),
    NO_PERMISSIONS(getInstance().getFlightConfiguration().getNoPermissions()),
    FLY_PLAYER_SWIITCH(getInstance().getFlightConfiguration().getFlyPlayerSwitch()),
    PLAYER_NOT_FOUND(getInstance().getFlightConfiguration().getPlayerNotFound()),
    PLAYER_FLY_SWTICH(getInstance().getFlightConfiguration().getFlySwitchPlayer()),
    SENDER_FLY_SWITCH(getInstance().getFlightConfiguration().getFlySwitchSender());

    FlightMessageType(String message) {
    }
}
