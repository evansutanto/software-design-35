package softwaredesign;

import javafx.scene.image.Image;

public class JokerPrisoner extends Character {
    Image charImage = new Image(getClass().getResource("Joker.png").toExternalForm());


    public void laugh(){
        // add sound here
        System.out.println("HAHAHAHAHA");
    }
    public JokerPrisoner(){
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
        isAlive = true;
    }

}

