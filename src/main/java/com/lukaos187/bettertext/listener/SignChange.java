package com.lukaos187.bettertext.listener;

import com.lukaos187.bettertext.util.ColorTranslator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener {

    private final ColorTranslator ct = new ColorTranslator();

    @EventHandler
    public void onSignChange(SignChangeEvent e){

        String[] text = e.getLines();

        for (int i = 0; i < text.length; i++) {
            e.setLine(i, ct.translateChatColor(text[i]));
        }

    }
}
