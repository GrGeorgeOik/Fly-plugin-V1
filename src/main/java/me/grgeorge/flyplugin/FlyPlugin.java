package me.grgeorge.flyplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class FlyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Fly plugin enabled!");

        getCommand("fly").setExecutor(new FlyCommand());


    }
}
