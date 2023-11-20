package dev.crafty;

import org.bukkit.plugin.java.JavaPlugin;

public class Create extends JavaPlugin {
    private static Create instance;
    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public static Create getInstance() {
        if (instance == null) {
            instance = new Create();
        }
        return instance;
    }
}
