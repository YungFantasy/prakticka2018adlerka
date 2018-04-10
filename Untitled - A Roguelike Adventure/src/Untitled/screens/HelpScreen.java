package Untitled.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.writeCenter("Untitled - A Roguelike Adventure", 1);
        terminal.write("Find your way through the halls of the forgotten dungeon", 12, 3);
        terminal.write("to find the lost relic. Return to the surface to win.", 12, 4);
        terminal.write("Use whatever means necessary to survive.", 12, 5);

        int y = 7;
        terminal.write("[g] to pick up", 2, y++);
        terminal.write("[d] to drop", 2, y++);
        terminal.write("[e] to eat", 2, y++);
        terminal.write("[w] to wear or wield", 2, y++);
        terminal.write("[h] [j] [k] [l] or arrow keys for movement", 2, y++);
        terminal.write("[x] to examine your items", 2, y++);
        terminal.write("[;] to look around", 2, y++);
        terminal.write("[t] to throw", 2, y++);
        terminal.write("[f] to fire your weapon", 2, y++);
        terminal.write("[q] to drink a potion", 2, y++);
        terminal.write("[?] to reset the game", 2, y);

        terminal.writeCenter("-- press any key to continue --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new CharacterCreationScreen() : this;
    }
}
