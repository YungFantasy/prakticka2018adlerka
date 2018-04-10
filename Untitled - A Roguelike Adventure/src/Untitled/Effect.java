package Untitled;

public class Effect {
    /*
    used for potion effects
     */
    protected int duration; //length of effect

    public boolean isDone() {
        return duration < 1;
    } //end of effect

    public Effect(int duration) {
        this.duration = duration;
    }

    public void update(Creature creature) {
        duration--;
    } //checks if pot is still in effect

    public void start(Creature creature) {
    } //applies changes when used

    public void end(Creature creature) {
    } //removes changes
}

