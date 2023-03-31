package softwaredesign;

import javafx.scene.image.Image;

public class JokerPrisoner extends Character {
    Image jokerImage = new Image(getClass().getResource("Joker.png").toExternalForm());
    Image jokerPushUp = new Image(getClass().getResource("JokerUp.png").toExternalForm());
    Image jokerPushDown = new Image(getClass().getResource("JokerDown.png").toExternalForm());
    Image jokerSpecial = new Image(getClass().getResource("JokerLaugh.png").toExternalForm());

    public void laugh(){
        // add sound here
        System.out.println("HAHAHAHAHA");
    }
    public JokerPrisoner(){
        specialImage = jokerSpecial;
        charImage = jokerImage;
        charPushDown = jokerPushDown;
        charPushUp = jokerPushUp;
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

