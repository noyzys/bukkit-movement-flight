package me.noyzys.flight;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys, 13:15 28.07.2019
 **/
public final class MessageFactory {

    @NotNull
    @Contract(pure = true)
    private MessageFactory() {
    }

    @NotNull
    public static MessageBuilder create(final String content){
        return ImmutableMessageBuilder
                .builder()
                .content(content)
                .build();
    }
}
