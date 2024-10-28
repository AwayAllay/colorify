package com.lukaos187.bettertext.util;

import org.bukkit.ChatColor;

import javax.annotation.Nullable;
import java.awt.*;

public class ColorTranslator {

    /**Translates the colors form the given String with '&' or from hexColors.*/
    public String translateChatColor(String toColor){

        String[] text = toColor.split("(?=&)");
        StringBuilder finalMessage = new StringBuilder();

        for (int i = 0; i < text.length; i++) {

            String part = text[i];

            if (part.startsWith("&#") && part.length() > 7 && getColor(part) != null) {
                //&#484848
                    finalMessage.append(getColor(part));
                    finalMessage.append(part.substring(8));
            }
            else if (part.startsWith("&") && part.length() >= 2 && getColor(part) != null) {

                    finalMessage.append(getColor(part));
                    finalMessage.append(part.substring(2));
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

    @Nullable
    private net.md_5.bungee.api.ChatColor getColor(String colorString){

        if (colorString.startsWith("&#") && colorString.length() > 7){

            String hexCode = colorString.substring(1, 8);

            if (isValidHexColor(hexCode)){
                return net.md_5.bungee.api.ChatColor.of(hexCode);
            }

        }
        else if (colorString.startsWith("&") && colorString.length() >= 2) {

            char colorCode = colorString.charAt(1);

            if (ChatColor.getByChar(colorCode) != null) {
                return net.md_5.bungee.api.ChatColor.getByChar(colorCode);
            }
        }

        return null;
    }

    /**Makes a transition between two colours for a specific text.*/
    private String transition(String text, Color startColor, Color endColor) {

        StringBuilder gradientText = new StringBuilder();
        int textLength = text.length();

        // calculate colour transition
        double rStep = (endColor.getRed() - startColor.getRed()) / (double) textLength;
        double gStep = (endColor.getGreen() - startColor.getGreen()) / (double) textLength;
        double bStep = (endColor.getBlue() - startColor.getBlue()) / (double) textLength;

        // text with transition
        for (int i = 0; i < textLength; i++) {
            int r = (int) (startColor.getRed() + (rStep * i));
            int g = (int) (startColor.getGreen() + (gStep * i));
            int b = (int) (startColor.getBlue() + (bStep * i));

            // Minecraft Hex-Code
            gradientText.append("§x")
                    .append("§").append(Integer.toHexString((r >> 4) & 0xF))
                    .append("§").append(Integer.toHexString(r & 0xF))
                    .append("§").append(Integer.toHexString((g >> 4) & 0xF))
                    .append("§").append(Integer.toHexString(g & 0xF))
                    .append("§").append(Integer.toHexString((b >> 4) & 0xF))
                    .append("§").append(Integer.toHexString(b & 0xF))
                    .append(text.charAt(i));
        }

        return gradientText.toString();
    }

}
