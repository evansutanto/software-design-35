package softwaredesign;

import javafx.scene.image.Image;

public class BuffPrisoner extends Character {
    Image charImage = new Image(getClass().getResource("Buff.png").toExternalForm());
    Image specialImage = new Image(getClass().getResource("Buff.png").toExternalForm()); // should make a flexing image

    public void flex(){
        // change pictures to flexing
        System.out.println("ARGGHHHH am big");
    }
    public  BuffPrisoner(){
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
        isAlive = true;
    }

}
