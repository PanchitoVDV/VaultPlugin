package me.panchito.vaultplugin;

import commands.VaultCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.printf("Vault plugin has started up!");

        // Register the Vault command
        getCommand("vault").setExecutor(new VaultCommand());

    }

}
