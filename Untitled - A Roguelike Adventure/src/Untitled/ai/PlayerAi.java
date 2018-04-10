package Untitled.ai;

import Untitled.Creature;
import Untitled.FieldOfView;
import Untitled.world.Tile;

import java.util.List;

public class PlayerAi extends CreatureAi {

    private List<String> messages;
    private FieldOfView fov;

    public PlayerAi(Creature creature, List<String> messages, FieldOfView fov) {
        super(creature);
        this.messages = messages;
        this.fov = fov;
    }

    public void onEnter(int x, int y, int z, Tile tile) {
        if (tile.isGround()) {
            creature.x = x;
            creature.y = y;
            creature.z = z;
        }
    }

    public void onNotify(String message) {
        messages.add(message);
    }

    public boolean canSee(int wx, int wy, int wz) {
        return fov.isVisible(wx, wy, wz);
    }

    public void onGainLevel() {
    }

    public Tile rememberedTile(int wx, int wy, int wz) {
        return fov.tile(wx, wy, wz);
    }
}