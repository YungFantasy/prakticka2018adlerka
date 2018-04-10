package Untitled;

import java.util.ArrayList;
import java.util.List;

public class LevelUpController {

    private static LevelUpChoice[] options = new LevelUpChoice[]{
            new LevelUpChoice("Increased hit points") {
                public void invoke(Creature creature) {
                    creature.gainMaxHp();
                }
            },
            new LevelUpChoice("Increased attack value") {
                public void invoke(Creature creature) {
                    creature.gainAttackValue();
                }
            },
            new LevelUpChoice("Increased defense value") {
                public void invoke(Creature creature) {
                    creature.gainDefenseValue();
                }
            },
            new LevelUpChoice("Increased vision") {
                public void invoke(Creature creature) {
                    creature.gainVision();
                }
            },
            new LevelUpChoice("Increased hp regeneration") {
                public void invoke(Creature creature) {
                    creature.gainRegenHp();
                }
            }
    };

    public void autoLevelUp(Creature creature) {
        options[(int) (Math.random() * options.length)].invoke(creature);
    }

    public List<String> getLevelUpOptions() {
        List<String> names = new ArrayList<String>();
        for (LevelUpChoice option : options) {
            names.add(option.name());
        }
        return names;
    }

    public LevelUpChoice getLevelUpOption(String name) {
        for (LevelUpChoice option : options) {
            if (option.name().equals(name))
                return option;
        }
        return null;
    }
}
