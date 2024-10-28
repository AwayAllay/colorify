package com.lukaos187.bettertext.listener;

import com.lukaos187.bettertext.util.ColorTranslator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditBook implements Listener {

    @EventHandler
    public void onBookEdit(PlayerEditBookEvent e){

        BookMeta bookMeta = e.getNewBookMeta();
        List<String> content = bookMeta.getPages();
        List<String> coloredContent = new ArrayList<>();
        ColorTranslator ct = new ColorTranslator();

        content.forEach(page -> coloredContent.add(ct.translateChatColor(page, e.getPlayer())));

        bookMeta.setPages(coloredContent);

        if (bookMeta.hasTitle()){
            bookMeta.setTitle(ct.translateChatColor(Objects.requireNonNull(bookMeta.getTitle()), e.getPlayer()));
        }

        e.setNewBookMeta(bookMeta);

    }
}
