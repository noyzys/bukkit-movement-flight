package me.noyzys.flight;

import org.diorite.config.Config;
import org.diorite.config.annotations.CustomKey;

/**
 * @author: NoyZys, 12:32 28.07.2019
 **/
public interface FlightConfiguration extends Config {

    @CustomKey(value = "command_only_player")
    default String getCommandOnlyPlayer(){
        return "Command only Player.";
    }

    @CustomKey("permissions")
    default String getPermissions(){
        return "plugin.flight";
    }

    @CustomKey("nopermissions")
    default String getNoPermissions(){
        return "Nie posiadasz permisji (plugin.flight).";
    }

    @CustomKey(value = "fly_player_switch")
    default String getFlyPlayerSwitch(){
        return "Twoj tryb latania zostal: {SWITCH}.";
    }

    @CustomKey(value = "player_not_found")
    default String getPlayerNotFound(){
        return "Podany gracz jest offline.";
    }

    @CustomKey(value = "fly_switch_player")
    default String getFlySwitchPlayer(){
        return "Zmieniles tryb latania graczowi: {PLAYER} na: {SWITCH}.";
    }

    @CustomKey(value = "fly_switch_sender")
    default String getFlySwitchSender(){
        return "Twoj tryb latania zostal zmieniony przez administratora: {PLAYER} na: {SWITCH}.";
    }

    @CustomKey("boolean-on")
    default String getBooleanOn() {
        return "&awlaczone";
    }

    @CustomKey("boolean-off")
    default String getBooleanOff() {
        return "&cwylaczone";
    }
}
