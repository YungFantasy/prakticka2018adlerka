package Untitled.ai;

import Untitled.Creature;

public class BatAi extends CreatureAi {

    public BatAi(Creature creature) {
        super(creature);
    }

    public void onUpdate() {
        roam();
        roam();
    }

}
