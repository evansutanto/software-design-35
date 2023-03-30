package softwaredesign;

import java.util.ArrayList;

public abstract class Vital implements Subject {
     private Observer myTracker = null;
     public int value = 100;
     String text;
     @Override
     public void attach(Observer obs) {
        myTracker = obs;
     }

     @Override
     public void detach(Observer obs) {
        myTracker = null;
     }

     @Override
     public void notifyObservers() {
        if(myTracker != null){
            myTracker.update(value);
        }
     }
}

class Health extends Vital{
     String text = "HP";
     public boolean isAlive(){
         if (value > 0){
             return true;
         }
         return false;
     }
}
class Hunger extends Vital{
     String text = "Hunger";
     public int criticalness = 5;
     Hunger(){
         value = 100;
     }

}
class Mood extends Vital{
     String text = "Mood";
     public int criticalness = 3;

}
class Hygiene extends Vital{
     String text = "Hygiene";
     public int criticalness = 2;
}
class Sleepiness extends Vital{
     String text = "Sleepiness";
    public int criticalness = 4;
}
