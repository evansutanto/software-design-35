package softwaredesign;

public class CharacterFactory {
    public Character createCharacter(String charType){
        if(charType == "Buff"){
            return new BuffPrisoner();
        }
        else if(charType == "Joker"){
            return new JokerPrisoner();
        }
        else if(charType == "Dancer"){
            return new DancerPrisoner();
        }
        else{
            return null;
        }
    }
}
