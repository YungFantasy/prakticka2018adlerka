package Untitled.screens;

import Untitled.Creature;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class EndScreen implements Screen {

    Creature player;

    public EndScreen(Creature player) {
        this.player = player;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("----------------------------------YOUR STATS----------------------------------", 1);
        terminal.writeCenter("Your attack was: " + player.attackValue(), 5);
        terminal.writeCenter("Your defense was: " + player.defenseValue(), 8);
        terminal.writeCenter("Your hitpoins were: " + player.maxHp(), 11);
        terminal.writeCenter("Your vision radius was: " + player.visionRadius(), 14);
        terminal.writeCenter("I hope you enjoyed playing this game!", 20);
        terminal.writeCenter("--- press [ENTER] to restart ---", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
