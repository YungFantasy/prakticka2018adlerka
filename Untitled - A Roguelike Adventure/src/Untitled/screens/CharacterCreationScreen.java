package Untitled.screens;

import Untitled.Settings;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class CharacterCreationScreen implements Screen {
    private boolean genderFlag = false;

    private int hp = 0;
    private int attack = 0;
    private int defense = 0;
    private int vision = 0;
    private int regen = 0;

    private int freePoints = 5;

    public void displayOutput(AsciiPanel terminal) {
        if (!genderFlag) {
            terminal.clear();
            terminal.writeCenter("Are you a male or a female ? [M/F]", 2);
        } else {
            terminal.clear();
            terminal.writeCenter("Distribute your starting points [" + freePoints + "]", 2);
            terminal.writeCenter("[H]ealth " + getPounds(hp), 4);
            terminal.writeCenter("[A]ttack value " + getPounds(attack), 5);
            terminal.writeCenter("[D]efense value " + getPounds(defense), 6);
            terminal.writeCenter("[V]ision radius " + getPounds(vision), 7);
            terminal.writeCenter("Health [R]egen " + getPounds(regen), 8);
        }
    }

    public Screen respondToUserInput(KeyEvent key) {
        if (!genderFlag) {
            switch (key.getKeyCode()) {
                case KeyEvent.VK_M:
                    Settings.gender = "M";
                    genderFlag = true;
                    break;
                case KeyEvent.VK_F:
                    Settings.gender = "F";
                    genderFlag = true;
                    break;
                default:
                    break;
            }
        } else {
            switch (key.getKeyCode()) {
                case KeyEvent.VK_H:
                    hp++;
                    freePoints--;
                    break;
                case KeyEvent.VK_A:
                    attack++;
                    freePoints--;
                    break;
                case KeyEvent.VK_D:
                    defense++;
                    freePoints--;
                    break;
                case KeyEvent.VK_V:
                    vision++;
                    freePoints--;
                    break;
                case KeyEvent.VK_R:
                    regen++;
                    freePoints--;
                    break;
            }
        }

        if (freePoints == 0) {
            Settings.hp = hp;
            Settings.attack = attack;
            Settings.defense = defense;
            Settings.vision = vision;
            Settings.regen = regen;
            return new PlayScreen();
        } else {
            return this;
        }
    }

    private String getPounds(int value) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < value; i++) {
            sb.append("#");
        }

        sb.append("]");

        return sb.toString();
    }
}
