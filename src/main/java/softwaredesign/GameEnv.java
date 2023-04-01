package softwaredesign;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class GameEnv extends HBox{
    private static GameEnv instance;
    private boolean pushupDone;
    private Character character;
    private int score;
    private Label scoreGUI;
    private Timeline timeline;
    private Label timerLabel;
    private static final Integer STARTTIME = 15;
    private IntegerProperty timeSeconds;
    private ImageView characterModel;
    private Image cellbg = new Image(getClass().getResource("Cell.jpeg").toExternalForm());
    private Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());
    private BackgroundImage cell = new BackgroundImage(cellbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
    private BackgroundImage backyard = new BackgroundImage(backyardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
    private GameEnv() {
        scoreGUI = new Label("SCORE:\n 0");
    }

    public void placeCharacter(Character myCharacter) {
        this.character = myCharacter;
        characterModel = new ImageView(this.character.charImage);
        characterModel.setFitWidth(200);
        characterModel.setFitHeight(200);

        this.getChildren().add(characterModel);
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(cell));
    }
    public static synchronized GameEnv getInstance() {
        if (instance == null) {
            instance = new GameEnv();
        }
        return instance;
    }
    public void playMinigame() {
        timerLabel = new Label();
        timeSeconds = new SimpleIntegerProperty(STARTTIME);
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 2em; -fx-text-align: right; -fx-font-weight: bold;");
        timerLabel.setTextAlignment(TextAlignment.RIGHT);
        scoreGUI.setStyle("-fx-font-size: 2em; -fx-font-weight: bold;");
        scoreGUI.setTextAlignment(TextAlignment.CENTER);

        if (timeline != null) {
            timeline.stop();
            changeToCell();
        }
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();

        changeToYard();
    }
    public void doPushUp() {
        characterModel.setImage(this.character.charPushUp);
        if (pushupDone) {
            score += 1;
            scoreGUI.setText("SCORE: \n" + score);
            pushupDone = false;
        }
    }
    public void doPushDown() {
        characterModel.setImage(this.character.charPushDown);
        pushupDone = true;
    }
    private void changeToYard() {
        this.getChildren().clear();
        this.setBackground(new Background(backyard));
        characterModel.setImage(this.character.charPushUp);
        this.getChildren().addAll(scoreGUI, characterModel, timerLabel);
    }
    private void changeToCell() {
        this.getChildren().clear();
        this.setBackground(new Background(cell));
        characterModel.setImage(this.character.charImage);
        this.getChildren().add(characterModel);
    }
    public void clearCharacter(){
        this.getChildren().clear();
    }
}
