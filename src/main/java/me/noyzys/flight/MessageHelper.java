package me.noyzys.flight;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys, 12:25 28.07.2019
 **/
public final class MessageHelper {

    @Contract(pure = true)
    private MessageHelper() {
    }

    @NotNull
    public static String colored(@NotNull String content){
        return ChatColor
                .translateAlternateColorCodes('&', content);
    }

    @NotNull
    public static MessageBuilder coloredBuilder(@NotNull String content){
        return ImmutableMessageBuilder
                .builder()
                .build();
    }

    public static boolean sendMessage(@NotNull CommandSender sender, String message){
        sender.sendMessage(colored(message));
        return true;
    }
}
