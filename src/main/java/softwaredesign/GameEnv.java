package softwaredesign;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GameEnv {
    VBox container;
    private boolean isCellBg = true;
    public ImageView getCharacter(Character myChar){
        ImageView chosenCharacter = new ImageView();
        chosenCharacter.setImage(myChar.getCharacter().charImage);
        chosenCharacter.setFitWidth(200);
        chosenCharacter.setFitHeight(200);
        return chosenCharacter;
    }
    public void gameHandler(Character myCharacter){
        Image cellbg = new Image(getClass().getResource("Cell.jpeg").toExternalForm());
        Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());

        Button switchButton = new Button("switch");
        HBox switchHBox = new HBox(switchButton);
        switchButton.setAlignment(Pos.TOP_LEFT);

        HBox chosenCharacterHBox = new HBox(getCharacter(myCharacter));
        chosenCharacterHBox.setAlignment(Pos.CENTER);

        container = new VBox(switchHBox, chosenCharacterHBox);
        container.setAlignment(Pos.CENTER);
        BackgroundImage cell = new BackgroundImage(cellbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        container.setBackground(new Background(cell));

        switchButton.setOnAction(event -> {
            if (isCellBg) {
                BackgroundImage backyard = new BackgroundImage(backyardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
                container.setBackground(new Background(backyard));
                isCellBg = false;
            } else {
                container.setBackground(new Background(cell));
                isCellBg = true;
            }
        });
    }
    public VBox render(){
        return container;
    }
    public GameEnv(Character character){gameHandler(character);}
}
