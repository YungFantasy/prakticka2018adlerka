package Untitled.world;

import asciiPanel.AsciiPanel;

import java.awt.*;

public enum Tile {
    FLOOR((char) 250, AsciiPanel.brightWhite, "A stone dungeon floor."),
    WALL((char) 177, AsciiPanel.brightBlack, "A stone dungeon wall."),
    BOUNDS('x', AsciiPanel.brightBlack, "Beyond the edge of the world."),
    STAIRS_DOWN('>', AsciiPanel.white, "A stone staircase that goes down."),
    STAIRS_UP('<', AsciiPanel.white, "A stone staircase that goes up."),
    UNKNOWN(' ', AsciiPanel.white, "(unknown)");

    private char glyph;
    public char glyph() {
        return glyph;
    }

    private Color color;
    public Color color() {
        return color;
    }

    private String details;
    public String details() {
        return details;
    }

    Tile(char glyph, Color color, String details) {
        this.glyph = glyph;
        this.color = color;
        this.details = details;
    }

    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}
