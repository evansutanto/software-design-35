package softwaredesign;

import javafx.scene.image.Image;

public class JokerPrisoner extends Character {
    Image charImage = new Image(getClass().getResource("Joker.png").toExternalForm());
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

    public void laugh(){
        // add sound here
        System.out.println("HAHAHAHAHA");
    }
    public void JokerPrinoner(){
        name = "Joker";
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

