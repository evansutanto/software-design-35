package softwaredesign;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public abstract class Character {
    String charImage;
    Image specialImage;
    public String name;
    public Hunger hungerVital;
    public Sleepiness sleepVital;
    public Hygiene hygineVital;
    public Mood moodVital;
    public Health healthVital;
    public boolean hungry;
    public boolean tired;
    public boolean dirty;
    public boolean sad;

//        + giveScore(): void
//        + destroy(): void

    public Character getCharacter(){
        return this;
    }
    public void feed(){
        hungerVital.value += 25;
        if(hungerVital.value > 100){ hungerVital.value = 100; }
    }
    public void clean(){
        hygineVital.value += 30;
        if(hygineVital.value > 100){ hygineVital.value = 100; }
    }
    public void sleep(){
        sleepVital.value += 30;
        if(sleepVital.value > 100){ sleepVital.value = 100; }
    }
    public boolean isDead(){
        return healthVital.isAlive();
    }
    public void incHP(int toAdd){
        healthVital.value += toAdd;
    }
    public void decHP(int toTake){
        healthVital.value -= toTake;
    }

    public void check(){ // checks vitals and updates HP accordingly
        int toDeduct = 0;
        if(hungerVital.value < 20){
            toDeduct += hungerVital.criticalness;
        }
        if(sleepVital.value < 20){
            toDeduct += sleepVital.criticalness;
        }
        if(hygineVital.value < 20 ){
            toDeduct += hygineVital.criticalness;
        }
        if(moodVital.value < 20){
            toDeduct += moodVital.criticalness;
        }
        decHP(toDeduct);
    }

}

/* NOTES
* modify in UML
* wakeup() should be sleep()
* for buff prisoner eatBig() will be flex()
*
* */