package Untitled;

public abstract class LevelUpChoice {
    private String name;

    public String name() {
        return name;
    }

    public LevelUpChoice(String name) {
        this.name = name;
    }

    public abstract void invoke(Creature creature);
}
