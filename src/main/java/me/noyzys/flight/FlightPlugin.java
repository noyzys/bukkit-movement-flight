package me.noyzys.flight;

import ch.jalu.injector.Injector;
import ch.jalu.injector.InjectorBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.diorite.config.ConfigManager;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: NoyZys, 12:21 28.07.2019
 **/
public final class FlightPlugin extends JavaPlugin implements Flight {

    private static FlightPlugin instance;
    private FlightConfiguration flightConfiguration;
    private final File messagesFile = new File(this.getDataFolder(), "messages.yml");

    @Override
    public void onEnable() {
        instance = this;
        this.initialize();
        this.getLogger().info("Enable.");
    }

    private void initialize(){
        Injector injector = new InjectorBuilder()
                .addDefaultHandlers("me.noyzys.flight")
                .create();
        ExecutorService executorService = Executors.newCachedThreadPool();

        //<--- configuration --->
        this.flightConfiguration = ConfigManager.createInstance(FlightConfiguration.class);
        this.flightConfiguration.bindFile(messagesFile);
        this.flightConfiguration.load();
        this.flightConfiguration.save();
        injector.register(FlightConfiguration.class, this.flightConfiguration);
        injector.register(ExecutorService.class, executorService);

        new FlightCommand(this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disable.");
    }

    public FlightConfiguration getFlightConfiguration() {
        return flightConfiguration;
    }

    public static FlightPlugin getInstance() {
        return instance;
    }
}
