package com.lukaos187.bettertext;

import com.lukaos187.bettertext.listener.ChatEvent;
import com.lukaos187.bettertext.listener.EditBook;
import com.lukaos187.bettertext.listener.InventoryClick;
import com.lukaos187.bettertext.listener.SignChange;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterText extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerListener();
    }

    /**Registers all the listeners.*/
    private void registerListener() {
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new SignChange(), this);
        getServer().getPluginManager().registerEvents(new EditBook(), this);
    }

}
