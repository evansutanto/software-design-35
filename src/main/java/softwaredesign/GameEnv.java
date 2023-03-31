package softwaredesign;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class GameEnv {
    private static GameEnv instance;
    private HBox container;
    private boolean isMinigame = true;
    private boolean pushupDone;
    private Character character;
    private int score;
    private int minigameCounter;
    private Timeline timeline;
    public HBox getCharacter(Character myChar){
        ImageView chosenCharacter = new ImageView();
        if(isMinigame) {
            chosenCharacter.setImage(myChar.getCharacter().charImage);
        }

        chosenCharacter.setFitWidth(200);
        chosenCharacter.setFitHeight(200);
        HBox container = new HBox(chosenCharacter);
        return container;
    }
    private GameEnv() {}
    private Image cellbg = new Image(getClass().getResource("Cell.jpeg").toExternalForm());
    private Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());
    private BackgroundImage cell = new BackgroundImage(cellbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
    private BackgroundImage backyard = new BackgroundImage(backyardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));

    public void placeCharacter(Character myCharacter) {
        this.character = myCharacter;
        container = getCharacter(myCharacter); //TODO: Rename method
        container.setAlignment(Pos.CENTER);

        container.setBackground(new Background(cell));
    }
    public static synchronized GameEnv getInstance() {
        if (instance == null) {
            instance = new GameEnv();
        }
        return instance;
    }
    public HBox render(){
        return container;
    }
    public void playMinigame() {
        minigameCounter = 5;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            minigameCounter -=1;
            if (minigameCounter == 0)
            {
                timeline.stop();
            container.setBackground(new Background(cell));
            container.getChildren().clear();
            ImageView temp = new ImageView(this.character.charImage);
            temp.setFitWidth(200);
            temp.setFitHeight(200);
            container.getChildren().add(temp);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        container.setBackground(new Background(backyard));
        container.getChildren().clear();
        ImageView temp = new ImageView(this.character.charPushUp);
        temp.setFitWidth(200); //TODO: Make this default inside character class and maybe Imageview as default
        temp.setFitHeight(200);
        container.getChildren().add(temp);
    }
    public void doPushUp() {
        container.getChildren().clear();
        ImageView temp = new ImageView(this.character.charPushUp);
        temp.setFitWidth(200);
        temp.setFitHeight(200);
        container.getChildren().add(temp);
        if (pushupDone) {
            score += 1;
            pushupDone = false;
            System.out.println("score-----------"+ score);
        }
    }
    public void doPushDown() {
        container.getChildren().clear();
        ImageView temp = new ImageView(this.character.charPushDown);
        temp.setFitWidth(200);
        temp.setFitHeight(200);
        container.getChildren().add(temp);
        pushupDone = true;
    }
}
