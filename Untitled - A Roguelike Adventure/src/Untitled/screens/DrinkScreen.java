package Untitled.screens;

import Untitled.Creature;
import Untitled.Item;

public class DrinkScreen extends InventoryBasedScreen {

    public DrinkScreen(Creature player) {
        super(player);
    }

    protected String getVerb() {
        return "drink";
    }

    protected boolean isAcceptable(Item item) {
        return item.drinkEffect() != null;
    }

    @Override
    protected Screen use(Item item) {
        player.drink(item);
        return null;
    }
}
