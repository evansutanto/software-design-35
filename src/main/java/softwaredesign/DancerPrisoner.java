package softwaredesign;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DancerPrisoner extends Character {
    Image dancerImage = new Image(getClass().getResource("Dancer.png").toExternalForm());
    Image dancerPushDown = new Image(getClass().getResource("DancerDown.png").toExternalForm());
    Image dancerPushUp = new Image(getClass().getResource("DancerUp.png").toExternalForm());
    Image dancerSpecial = new Image(getClass().getResource("DancerDance1.png").toExternalForm());// should make a dancing picture

    public void dance(){
        // change to dancing pictures
        System.out.println("lala alala am dancing");
    }

    public DancerPrisoner(){
        specialImage = dancerSpecial;
        charImage = dancerImage;
        charPushDown = dancerPushDown;
        charPushUp = dancerPushUp;
        name = "Dancer";
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
