package com.lukaos187.bettertext.listener;

import com.lukaos187.bettertext.util.ColorTranslator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){

        if (e.getClickedInventory() != null
                && e.getClickedInventory().getType() == InventoryType.ANVIL
                && e.getRawSlot() == 2){ //Make sure it is the "finished-item" slot in an anvil gui

            if (e.getCurrentItem() != null
                    && e.getCurrentItem().getItemMeta() != null
                    && e.getCurrentItem().getItemMeta().hasDisplayName()){ //Make sure the item has a displayName

                ItemStack item = e.getCurrentItem();
                ItemMeta meta = item.getItemMeta();
                String displayName = meta.getDisplayName(); //get displayName
                String colorizedName = new ColorTranslator().translateChatColor(displayName, (Player) e.getWhoClicked()); //translate the displayName

                meta.setDisplayName(colorizedName); //set the new displayName
                item.setItemMeta(meta); //Set the ItemMeta

            }
        }
    }
}
