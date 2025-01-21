package net.beta.betacore;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import net.beta.betacore.commands.GiveCommand;
import net.beta.betacore.events.BlockPlace;
import net.beta.betacore.events.PlayerJoin;
import net.beta.betacore.events.PlayerQuit;
import net.beta.betacore.events.RandomSpawn;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerJoin playerJoin = new PlayerJoin();
        PlayerQuit playerQuit = new PlayerQuit();
       getCommand("give").setExecutor(new GiveCommand());
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerJoin, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerQuit, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BlockPlace(), Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_RESPAWN, new RandomSpawn(), Event.Priority.Highest, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
