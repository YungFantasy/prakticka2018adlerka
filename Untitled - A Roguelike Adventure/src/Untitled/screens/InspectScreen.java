package Untitled.screens;

import Untitled.Creature;
import Untitled.Item;

public class InspectScreen extends InventoryBasedScreen {

    public InspectScreen(Creature player) {
        super(player);
    }

    protected String getVerb() {
        return "examine";
    }

    protected boolean isAcceptable(Item item) {
        return true;
    }

    @Override
    protected Screen use(Item item) {
        String article = "aeiou".contains(item.name().subSequence(0, 1)) ? "an " : "a ";
        player.notify("It's " + article + item.name() + "." + item.details());
        return null;
    }
}
