package me.noyzys.flight;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author: NoyZys, 13:03 28.07.2019
 **/
public class FlightCommand implements CommandExecutor {

    private final FlightPlugin plugin;

    public FlightCommand(FlightPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(this.plugin.getFlightConfiguration().getCommandOnlyPlayer());
            return true;
        }

        if (!sender.hasPermission(this.plugin.getFlightConfiguration().getPermissions())) return MessageHelper.sendMessage(sender, this.plugin.getFlightConfiguration().getNoPermissions());

        final Player player = (Player) sender;
        boolean switched = !player.isFlying();
        player.setAllowFlight(switched);
        MessageHelper.sendMessage(player, this.plugin.getFlightConfiguration().getFlyPlayerSwitch().replace("{SWITCH}", FlightParser.parseFlightStatus(switched)));

        final Player target = Bukkit.getPlayer(args[1]);
        boolean switchedd = !target.isFlying();
        target.setAllowFlight(switchedd);
        if (target == null) return MessageHelper.sendMessage(player, this.plugin.getFlightConfiguration().getPlayerNotFound());

        MessageHelper.sendMessage(player, this.plugin.getFlightConfiguration().getFlySwitchPlayer()
                .replace("{PLAYER}", target.getName())
                .replace("{SWITCH}", FlightParser.parseFlightStatus(switchedd)
                ));

        return MessageHelper.sendMessage(target, this.plugin.getFlightConfiguration().getFlySwitchSender()
                .replace("{PLAYER}", player.getName()
                .replace("{SWITCH}", FlightParser.parseFlightStatus(switchedd))
                ));
    }
}
