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
    private boolean isUp = true;

    public ImageView getCharacter(Character myChar){
        ImageView chosenCharacter = new ImageView();
        if(isCellBg == true) {
            chosenCharacter.setImage(myChar.getCharacter().charImage);
        }
        if(isCellBg == false && isUp == true) {
            chosenCharacter.setImage(myChar.getCharacter().charPushUp);
        }
        if (isCellBg == false && isUp == false) {
            chosenCharacter.setImage(myChar.getCharacter().charPushDown);
        }
        chosenCharacter.setFitWidth(200);
        chosenCharacter.setFitHeight(200);
        return chosenCharacter;
    }

    public void gameHandler(Character myCharacter) {
        Image cellbg = new Image(getClass().getResource("Cell.jpeg").toExternalForm());
        Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());

        Button switchButton = new Button("Push-up Game");
        HBox switchHBox = new HBox(switchButton);
        switchButton.setAlignment(Pos.TOP_LEFT);

        HBox chosenCharacterHBox = new HBox(getCharacter(myCharacter));
        chosenCharacterHBox.setAlignment(Pos.CENTER);

        container = new VBox(switchHBox, chosenCharacterHBox);
        container.setAlignment(Pos.CENTER);
        BackgroundImage cell = new BackgroundImage(cellbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        container.setBackground(new Background(cell));

        Button pushButton = new Button("PUSH UP!");
        HBox pushButtonHBox = new HBox(pushButton);
        pushButtonHBox.setAlignment(Pos.BOTTOM_CENTER);

        switchButton.setOnAction(event -> {
            if (isCellBg) {
                BackgroundImage backyard = new BackgroundImage(backyardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
                container.setBackground(new Background(backyard));
                isCellBg = false;
                chosenCharacterHBox.getChildren().clear();
                chosenCharacterHBox.getChildren().add(getCharacter(myCharacter));
                switchButton.setText("Exit");

                container.getChildren().add(pushButtonHBox);

//                long start_time = System.currentTimeMillis();
//                long wait_time = 10000;
//                long end_time = start_time + wait_time;

                pushButton.setOnAction(event1 -> {
                    if(isUp == true) {
                        isUp = false;
                        chosenCharacterHBox.getChildren().clear();
                        chosenCharacterHBox.getChildren().add(getCharacter(myCharacter));
                    }
                    else {
                        isUp = true;
                        chosenCharacterHBox.getChildren().clear();
                        chosenCharacterHBox.getChildren().add(getCharacter(myCharacter));
                    }
                });
            } else {
                switchButton.setText("Push-up Game");
                container.getChildren().remove(pushButtonHBox);
                container.setBackground(new Background(cell));
                isCellBg = true;
                chosenCharacterHBox.getChildren().clear();
                chosenCharacterHBox.getChildren().add(getCharacter(myCharacter));
            }
        });
    }
    public VBox render(){
        return container;
    }
    public GameEnv(Character character){gameHandler(character);}
}
