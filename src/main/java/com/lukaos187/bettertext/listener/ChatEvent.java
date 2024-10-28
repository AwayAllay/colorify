package com.lukaos187.bettertext.listener;

import com.lukaos187.bettertext.util.ColorTranslator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){

        String message = event.getMessage(); //The message sent form the player
        event.setMessage(new ColorTranslator().translateChatColor(message, event.getPlayer()));

    }
}
