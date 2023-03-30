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
    public boolean isAlive;

//        + giveScore(): void
//        + destroy(): void

    public Character getCharacter(){
        return this;
    }
    public void feed(){
        hungerVital.value += 25;
        if(hungerVital.value > 100) hungerVital.value = 100;
    }
    public void clean(){
        hygineVital.value += 30;
        if(hygineVital.value > 100) hygineVital.value = 100;
    }
    public void sleep(){
        sleepVital.value += 30;
        if(sleepVital.value > 100) sleepVital.value = 100;
    }
    public void incHP(int toAdd){
        healthVital.value += toAdd;
    }
    public void decHP(int toTake){
        healthVital.value -= toTake;
    }

    public void updateHP(){// checks vitals and updates HP accordingly
        int toAdd = 0;
        if(hungry){
            toAdd -= hungerVital.criticalness;
            if(hungerVital.value == 0) toAdd -= hungerVital.criticalness;
        } else{ toAdd += 2;}
        if(tired){
            toAdd -= sleepVital.criticalness;
            if(sleepVital.value == 0) toAdd -= sleepVital.criticalness;
        } else{ toAdd += 2;}
        if(dirty){
            toAdd -= hygineVital.criticalness;
            if(hygineVital.value == 0) toAdd -= hygineVital.criticalness;
        } else {toAdd += 2;}
        if(sad){
            toAdd -= moodVital.criticalness;
            if(moodVital.value == 0) toAdd -= moodVital.criticalness;
        } else { toAdd += 2;}
        healthVital.value += toAdd;
        if(healthVital.value > 100) healthVital.value = 100;
        if(healthVital.value <= 0){
            isAlive = false;
        }
        healthVital.notifyObservers();
        System.out.println("Vitals Updated:");
        System.out.println("Hunger = " + hungerVital.value);
        System.out.println("Sleep = " + sleepVital.value);
        System.out.println("Hygien = " + hygineVital.value);
        System.out.println("Mood = " + moodVital.value);
        System.out.println("HP = " + healthVital.value);
    }
    public void updateVitals(){
        hungerVital.value -= 5;
        if(hungerVital.value < 20) {
            hungry = true;
            if(hungerVital.value < 0 ) hungerVital.value = 0;
        }
        else  hungry = false;

        hygineVital.value -= 3;
        if(hygineVital.value < 20) {
            dirty = true;
            if(hygineVital.value < 0 ) hygineVital.value = 0;
        }
        else  dirty = false;

        sleepVital.value -= 2;
        if(sleepVital.value < 20) {
            tired = true;
            if(sleepVital.value < 0 ) sleepVital.value = 0;
        }
        else  tired = false;

        moodVital.value -= 2;
        if(moodVital.value < 20) {
            sad = true;
            if(moodVital.value < 0 ) moodVital.value = 0;
        }
        else  sad = false;

        hungerVital.notifyObservers();
        hygineVital.notifyObservers();
        sleepVital.notifyObservers();
        moodVital.notifyObservers();
    }

}

/* NOTES
* modify in UML
* wakeup() should be sleep()
* for buff prisoner eatBig() will be flex()
* add check() to Character class
* isDead() is removed
*
* */