package Untitled;

import Untitled.ai.*;
import Untitled.world.World;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.util.List;

public class StuffFactory {
    private World world;

    public StuffFactory(World world) {
        this.world = world;
    }

    public Creature newPlayer(List<String> messages, FieldOfView fov) {
        Color playerColor = null;
        if (Settings.gender.equals("M")){
            playerColor = AsciiPanel.brightCyan;
        }else{
            playerColor = AsciiPanel.brightMagenta;
        }//creates the player

        Creature player = new Creature(world, '@', playerColor, "player", 100, 20, 10);

        for (int i = 0; i < Settings.hp;i++){
            player.gainMaxHp();
        }
        for (int i = 0; i < Settings.attack;i++){
            player.gainAttackValue();
        }
        for (int i = 0; i < Settings.defense;i++){
            player.gainDefenseValue();
        }
        for (int i = 0; i < Settings.vision;i++){
            player.gainVision();
        }
        for (int i = 0; i < Settings.regen;i++){
            player.gainRegenHp();
        }

        world.addAtEmptyLocation(player, 0);
        new PlayerAi(player, messages, fov);
        return player;
    }

    public Creature newFungus(int depth) {
        Creature fungus = new Creature(world, 'f', AsciiPanel.green, "fungus", 10, 1, 0);
        world.addAtEmptyLocation(fungus, depth);
        new FungusAi(fungus, this);
        return fungus;
    }

    public Creature newBat(int depth) {
        Creature bat = new Creature(world, 'b', AsciiPanel.brightYellow, "bat", 15, 3, 0);
        world.addAtEmptyLocation(bat, depth);
        new BatAi(bat);
        return bat;
    }

    public Creature newZombie(int depth, Creature player) {
        Creature zombie = new Creature(world, 'z', AsciiPanel.white, "zombie", 50, 5, 10);
        world.addAtEmptyLocation(zombie, depth);
        new ZombieAi(zombie, player);
        return zombie;
    }

    public Creature newGoblin(int depth, Creature player) {
        Creature goblin = new Creature(world, 'g', AsciiPanel.brightGreen, "goblin", 65, 8, 5);
        goblin.equip(randomWeapon(depth));
        goblin.equip(randomArmor(depth));
        world.addAtEmptyLocation(goblin, depth);
        new GoblinAi(goblin, player);
        return goblin;
    }

    public Item newRock(int depth) {
        Item rock = new Item(',', AsciiPanel.white, "Rock");
        world.addAtEmptyLocation(rock, depth);
        return rock;
    }

    public Item newRelic(int depth) {
        Item item = new Item('*', AsciiPanel.brightYellow, "Golden Relic");
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newBread(int depth) {
        Item item = new Item('%', AsciiPanel.yellow, "Bread");
        item.modifyFoodValue(200);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newFruit(int depth) {
        Item item = new Item('%', AsciiPanel.brightRed, "Apple");
        item.modifyFoodValue(100);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newDagger(int depth) {
        Item item = new Item(')', AsciiPanel.white, "Dagger");
        item.modifyAttackValue(5);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    private Item newSword(int depth) {
        Item item = new Item(')', AsciiPanel.brightWhite, "Sword");
        item.modifyAttackValue(10);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newStaff(int depth) {
        Item item = new Item(')', AsciiPanel.yellow, "Staff");
        item.modifyAttackValue(5);
        item.modifyDefenseValue(3);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newLightArmor(int depth) {
        Item item = new Item('[', AsciiPanel.green, "Leather armor");
        item.modifyDefenseValue(2);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newMediumArmor(int depth) {
        Item item = new Item('[', AsciiPanel.white, "Chainmail");
        item.modifyDefenseValue(4);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newHeavyArmor(int depth) {
        Item item = new Item('[', AsciiPanel.brightWhite, "Platemail");
        item.modifyDefenseValue(6);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newBow(int depth) {
        Item item = new Item(')', AsciiPanel.yellow, "Bow");
        item.modifyAttackValue(1);
        item.modifyRangedAttackValue(5);
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newHealthPotion(int depth) {
        Item item = new Item('!', AsciiPanel.brightRed, "Health potion");
        item.setDrinkEffect(new Effect(1) {
            public void start(Creature creature) {
                if (creature.hp() == creature.maxHp())
                    return;
                creature.modifyHp(50);
                creature.doAction("look healthier");
            }
        });
        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newPoisonPotion(int depth) {
        Item item = new Item('!', AsciiPanel.brightGreen, "Poison potion");
        item.setDrinkEffect(new Effect(20) {
            public void start(Creature creature) {
                creature.doAction("look sick");
            }

            public void update(Creature creature) {
                super.update(creature);
                creature.modifyHp(-1);
            }
        });

        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newWarriorPotion(int depth) {
        Item item = new Item('!', AsciiPanel.brightMagenta, "Warrior's potion");
        item.setDrinkEffect(new Effect(20) {
            public void start(Creature creature) {
                creature.modifyAttackValue(5);
                creature.modifyDefenseValue(5);
                creature.doAction("look stronger");
            }

            public void end(Creature creature) {
                creature.modifyAttackValue(-5);
                creature.modifyDefenseValue(-5);
                creature.doAction("look less strong");
            }
        });

        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newArcherPotion(int depth) {
        Item item = new Item('!', AsciiPanel.brightYellow, "Archer's potion");
        item.setDrinkEffect(new Effect(20) {
            public void start(Creature creature) {
                creature.modifyVisionRadius(3);
                creature.doAction("look more alert");
            }

            public void end(Creature creature) {
                creature.modifyVisionRadius(-3);
                creature.doAction("look less alert");
            }
        });

        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item newExpPotion(int depth) {
        Item item = new Item('!', AsciiPanel.brightCyan, "Experience potion");
        item.setDrinkEffect(new Effect(20) {
            public void start(Creature creature) {
                creature.doAction("look more experienced");
                creature.modifyXp(creature.level() * 5);
            }
        });

        world.addAtEmptyLocation(item, depth);
        return item;
    }

    public Item randomWeapon(int depth) {
        switch ((int) (Math.random() * 3)) {
            case 0:
                return newDagger(depth);
            case 1:
                return newSword(depth);
            case 2:
                return newBow(depth);
            default:
                return newStaff(depth);
        }
    }

    public Item randomArmor(int depth) {
        switch ((int) (Math.random() * 3)) {
            case 0:
                return newLightArmor(depth);
            case 1:
                return newMediumArmor(depth);
            default:
                return newHeavyArmor(depth);
        }
    }

    public Item randomPotion(int depth) {
        switch ((int) (Math.random() * 6)) {
            case 0:
                return newHealthPotion(depth);
            case 1:
                return newPoisonPotion(depth);
            case 2:
                return newWarriorPotion(depth);
            case 3:
                return newArcherPotion(depth);
            default:
                return newExpPotion(depth);
        }
    }
}
