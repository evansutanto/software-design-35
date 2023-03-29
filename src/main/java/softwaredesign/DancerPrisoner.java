package softwaredesign;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DancerPrisoner extends Character {
    Image charImage = new Image(getClass().getResource("Dancer.png").toExternalForm());
    Image specialImage = new Image(getClass().getResource("Dancer.png").toExternalForm()); // should make a dancing picture
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

    public void dance(){
        // change to dancing pictures
        System.out.println("lala alala am dancing");
    }

    public void DancerPrisoner(){
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
        alive = true;
    }


}
