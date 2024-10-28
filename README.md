[![Latest Version](https://img.shields.io/github/v/release/AwayAllay/colorify?label=latest)](https://github.com/AwayAllay/colorify/releases)

# Colorify

**Colorify** is a plugin that allows players to customize all text in Minecraft with color codes and hex colors. Bring personality and color to your game, making your text stand out in unique shades!

## Features

- **Use color codes to color your texts**:
  - Standard color codes
  - Hex color codes
  - Transitions between colors

- **Color all texts such as**:
  - Books
  - Chat
  - Item names
  - Signs

- **Tested versions**: 1.19.2 - 1.20.1

## Installation

1. Download the latest version of the plugin from [SpigotMC]() or from [GitHub](https://github.com/AwayAllay/colorify/releases).
2. Move the `.jar` file into your server's `/plugins` folder.
3. Restart the server or load the plugin using `/reload`.

## Usage

With the **Colorify** plugin, you can easily add colors to text in Minecraft. Here’s how to use the various formatting options:

### 1. Color Codes

- Use `&` followed by a letter or number (e.g., `&a` for light green, `&d` for pink) to apply standard Minecraft colors. You can find the available codes [here](https://htmlcolorcodes.com/minecraft-color-codes/).

### 2. Hex Colors

- For custom colors, use `&#` followed by a 6-digit hex color code (e.g., `&#484848` for a dark gray color). You can find a hex color chooser [here](https://htmlcolorcodes.com/).

### 3. Color Transitions

- To create smooth color transitions, use the syntax `&(&color1, &color2)`. You can mix standard color codes and hex colors.
  - **Example**: `&(&d, &#484848)` will transition from pink to dark gray.

Simply add the color code or transition syntax before your text, and **Colorify** will automatically apply the colors when displayed in Minecraft.

## Permissions

- `colorify.color`: Allows a player to use the coloring features.

## Support

If you can't find a version of this plugin that works for your server or have more plugin ideas:

- Create an issue in the [Issues tab](https://github.com/AwayAllay/colorify/issues), and I will get to it as soon as possible.
- If you are a developer, you can also create a [Pull Request](https://github.com/AwayAllay/colorify/pulls).
