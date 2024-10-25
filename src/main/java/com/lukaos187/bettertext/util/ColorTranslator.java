package com.lukaos187.bettertext.util;

import org.bukkit.ChatColor;

public class ColorTranslator {

    /**Translates the colors form the given String with '&' or from hexColors.*/
    public String translateChatColor(String toColor){

        String[] text = toColor.split("(?=&)");
        StringBuilder finalMessage = new StringBuilder();


        for (String part : text) {

            if (part.startsWith("&#") && part.length() > 7) {

                String hexCode = part.substring(1, 8);


                if (isValidHexColor(hexCode)) {
                    finalMessage.append(net.md_5.bungee.api.ChatColor.of(hexCode));
                    finalMessage.append(part.substring(8));
                }
                else {
                    finalMessage.append(part);
                }
            }
            else if (part.startsWith("&") && part.length() >= 2) {

                char colorCode = part.charAt(1);

                if (ChatColor.getByChar(colorCode) != null) {
                    finalMessage.append(ChatColor.getByChar(colorCode));
                    finalMessage.append(part.substring(2));
                }

            }
            else {
                finalMessage.append(part);
            }
        }

        return finalMessage.toString();
    }

    /**Tests if the given color is a valid hexColor.*/
    private boolean isValidHexColor(String hexCode) {

        try {
            net.md_5.bungee.api.ChatColor.of(hexCode);
            return true;
        }catch (IllegalArgumentException e){
            return  false;
        }
    }

}
