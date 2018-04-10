package Untitled.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Welcome to the spooky castle!",1);

        terminal.write("                 |ZZzzz", 21, 4);
        terminal.write("                 |",21, 5);
        terminal.write("                 |",21, 6);
        terminal.write("    |ZZzzz      /^\\           |ZZzzz", 21, 7);
        terminal.write("    |          |~~~|           |",21, 8);
        terminal.write("    |        |^^^^^^^|        / \\",21, 9);
        terminal.write("   /^\\       |[]+    |       |~~~|", 21, 10);
        terminal.write("|^^^^^^^|    |    +[]|       |   |", 21, 11);
        terminal.write("|    +[]|/\\/\\/\\/\\^/\\/\\/\\/\\/|^^^^^^^|", 21, 12);
        terminal.write("|+[]+   |~~~~~~~~~~~~~~~~~~|    +[]|", 21, 13);
        terminal.write("|       |  []   /^\\   []   |+[]+   |", 21, 14);
        terminal.write("|   +[]+|  []  || ||  []   |   +[]+|", 21, 15);
        terminal.write("|[]+    |      || ||       |[]+    |", 21, 16);
        terminal.write("|_______|------------------|_______|", 21,17);

        terminal.writeCenter("Your adventure is waiting for you inside the castle's dungeon!", 20);
        terminal.writeCenter("--- press [ENTER] to start ---", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new HelpScreen() : this;
    }
}
