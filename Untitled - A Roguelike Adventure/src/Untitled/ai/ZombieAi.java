package Untitled.ai;

import Untitled.Creature;

public class ZombieAi extends CreatureAi {
    private Creature player;

    public ZombieAi(Creature creature, Creature player) {
        super(creature);
        this.player = player;
    }

    public void onUpdate() {
        if (Math.random() < 0.2)
            return;
        if (creature.canSee(player.x, player.y, player.z))
            chase(player);
        else
            roam();
    }

    public void chase(Creature target) {
        super.chase(target);
    }
}
