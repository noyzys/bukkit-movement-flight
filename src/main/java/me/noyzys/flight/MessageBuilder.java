package me.noyzys.flight;

import org.immutables.value.Value;

/**
 * @author: NoyZys, 13:15 28.07.2019
 **/
@Value.Immutable
public interface MessageBuilder {

    String content();
}
