package softwaredesign;

import javafx.scene.image.Image;

public class BuffPrisoner extends Character {
    Image buffImage = new Image(getClass().getResource("Buff.png").toExternalForm());
    Image buffPushDown = new Image(getClass().getResource("BuffDown.png").toExternalForm());
    Image buffPushUp = new Image(getClass().getResource("BuffUp.png").toExternalForm());
    Image buffSpecial = new Image(getClass().getResource("BuffFlex.png").toExternalForm()); // should make a flexing image

    public void flex(){
        // change pictures to flexing
        System.out.println("ARGGHHHH am big");
    }
    public  BuffPrisoner(){
        specialImage = buffSpecial;
        charImage = buffImage;
        charPushDown = buffPushDown;
        charPushUp = buffPushUp;
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
