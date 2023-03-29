package softwaredesign;

import javafx.scene.image.Image;

public class BuffPrisoner extends Character {
    Image charImage = new Image(getClass().getResource("Buff.png").toExternalForm());
    Image specialImage = new Image(getClass().getResource("Buff.png").toExternalForm()); // should make a flexing image
    public String name;
    public Hunger hungerVital ;
    public Sleepiness sleepVital;
    public Hygiene hygineVital;
    public Mood moodVital;
    public Health healthVital;
    public boolean hungry;
    public boolean tired;
    public boolean dirty;
    public boolean sad;
    public boolean alive;
    public void flex(){
        // change pictures to flexing
        System.out.println("ARGGHHHH am big");
    }
    public void BuffPrisoner(){
        name = "Buff";
        hungerVital = new Hunger();
        sleepVital = new Sleepiness();
        hygineVital = new Hygiene();
        moodVital = new Mood();
        healthVital = new Health();
        hungry = false;
        tired = false;
        dirty = false;
        sad = false;
        alive = true;
    }

}
