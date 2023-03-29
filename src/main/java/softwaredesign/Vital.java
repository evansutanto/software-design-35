package softwaredesign;

 public abstract class Vital {
     int value;
     String text;
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
     public int criticalness = 4;
}
class Mood extends Vital{
     String text = "Mood";
     public int criticalness = 1;

}
class Hygiene extends Vital{
     String text = "Hygiene";
     public int criticalness = 2;
}
class Sleepiness extends Vital{
     String text = "Sleepiness";
    public int criticalness = 3;
}
