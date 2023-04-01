package softwaredesign;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class Main extends Application {
    BorderPane root;
    String chosenCharType;
    Character myCharacter;
    @Override
    public void start(Stage stage) throws IOException {
        root = new BorderPane();
        titleState();

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        FadeTransition titlePageFade = new FadeTransition(Duration.seconds(1), root);

        // Create a delay transition for the titleState
        delay.setOnFinished(e -> titlePageFade.play());
        delay.play();

        //Create a titlePageFade transition for the BorderPane
        titlePageFade.setFromValue(1.0);
        titlePageFade.setToValue(0.0);
        titlePageFade.setCycleCount(1);
        titlePageFade.setOnFinished(titleEvent -> {
                    FadeTransition fade2 = new FadeTransition(Duration.seconds(1.5), root);
                    fade2.setFromValue(0.0);
                    fade2.setToValue(1.0);
                    fade2.play();
                    startCustomizePage();
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), e ->{
            if(myCharacter != null) {
                if(myCharacter.isAlive) {
                    myCharacter.updateHP();
                    myCharacter.updateVitals();
                }
                else {
                    System.out.println("YOUR PRISONER DIED\nGAMVE OVER");
                    GameEnv game = GameEnv.getInstance();
                    game.clearCharacter();
                    myCharacter = null;
                    root.getChildren().clear();

                    //Create a fade transition for the BorderPane
                    FadeTransition gameOverFade = new FadeTransition(Duration.seconds(1), root);
                    gameOverFade.setFromValue(1.0);
                    gameOverFade.setToValue(0.5);
                    gameOverFade.setCycleCount(1);
                    gameOverFade.setOnFinished(gameOverEvent -> {
                        FadeTransition fade2 = new FadeTransition(Duration.seconds(0.5), root);
                        fade2.setFromValue(0.5);
                        fade2.setToValue(1.0);
                        fade2.play();
                        gameOverState();
                    });
                    gameOverFade.play();
                }
            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root);
        stage.setTitle("Jailbird!");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void startCustomizePage() {
        CustomizationPage selectCharacter = new CustomizationPage();
        Panel panel = new Panel();
        Button selectButton = new Button("Select");
        selectButton.setPrefSize(500, 100);
        selectButton.setStyle("-fx-font-size: 3em;");
        panel.setBottom(selectButton);
        root.setBottom(panel.getBottom());
        root.setLeft(panel.getLeft());
        root.setRight(panel.getRight());
        root.setCenter(selectCharacter.renderOption());
        chosenCharType = selectCharacter.selectedCharacter;
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Selected character: " + selectCharacter.selectedCharacter);

                if (selectCharacter.selectedCharacter != null) {
                    chosenCharType = selectCharacter.selectedCharacter;
                    CharacterFactory charFactory = new CharacterFactory();
                    myCharacter = charFactory.createCharacter(chosenCharType);
//                    GameEnv env = new GameEnv(myCharacter);
                    GameEnv game = GameEnv.getInstance();
                    game.placeCharacter(myCharacter);

                    FadeTransition startGameFade = new FadeTransition(Duration.seconds(0.5), root);
                    startGameFade.setFromValue(1.0);
                    startGameFade.setToValue(0);
                    startGameFade.setCycleCount(1);
                    startGameFade.setOnFinished(gameEvent -> {
                        FadeTransition startGameFade2 = new FadeTransition(Duration.seconds(1), root);
                        startGameFade2.setFromValue(0);
                        startGameFade2.setToValue(1.0);
                        startGameFade2.play();
                        root.setCenter(game);
                    });
                    startGameFade.play();

                    // Place inside a function
                    Panel gamePanel = new Panel();
                    gamePanel.setButton(0, "Eat", (e -> {
                        System.out.println("eat");
                        myCharacter.feed();
                    }));
                    gamePanel.setButton(1, "Play Minigame", (e -> {
                        gamePanel.setButton(0, "Push Up" ,(event2-> game.doPushDown()));
                        gamePanel.setButton(1, "" ,(event2-> System.out.println("empty button")));
                        gamePanel.setButton(2, "",(event2-> System.out.println("empty button")));
                        gamePanel.setButton(3, "Push Down",(event2-> game.doPushUp()));
                        gamePanel.setButton(4, "",(event2-> System.out.println("empty button")));
                        game.playMinigame();}));
                    gamePanel.setButton(2, "Clean", (e -> {
                        System.out.println("clean");
                        myCharacter.clean();
                    }));
                    gamePanel.setButton(3, "Sleep", (e -> {
                        System.out.println("sleep");
                        myCharacter.sleep();
                    }));
                    gamePanel.setButton(4, "Special Ability", (e -> {
                        System.out.println("Special");
                        game.specialAbility();
                    }));

                    root.setBottom(gamePanel.getBottom());
                    root.setLeft(gamePanel.getLeft());
                    root.setRight(gamePanel.getRight());

                    myCharacter.hungerVital.attach(gamePanel.hungerTracker);
                    myCharacter.hygineVital.attach(gamePanel.hygienTracker);
                    myCharacter.sleepVital.attach(gamePanel.sleepTracker);
                    myCharacter.moodVital.attach(gamePanel.moodTracker);
                    myCharacter.healthVital.attach(gamePanel.healthTracker);
                }
            }
        });
    }
    public void initCustomPanel() {
    }
    private Label authorIdentity(String name){
        Label nameLabel = new Label(name);
        nameLabel.setTextFill(Color.WHITE);
        Font font = new Font("Comic Sans MS", 14);
        nameLabel.setFont(font);
        return nameLabel;
    }
    private void titleState() {
        ImageView titleImageView = new ImageView(new Image(getClass().getResource("JailBirdTitle.png").toExternalForm()));
        titleImageView.setFitWidth(600);
        titleImageView.setFitHeight(300);
        HBox titleHBox = new HBox(titleImageView);
        titleHBox.setAlignment(Pos.TOP_CENTER);

        Label groupLabel = authorIdentity("Group 35:");
        Label TAlabel = authorIdentity("TA: Ariana Vargas Pastor");
        Label member1 = authorIdentity("Alvaro Pratama Maharto/2734663");
        Label member2 = authorIdentity("Mahmoud Ashtar/2696767");
        Label member3 = authorIdentity("Michael Evan Sutanto/2720871");
        Label member4 = authorIdentity("Miguel Sadorra/2728578");

        VBox membersVBox = new VBox(5);
        membersVBox.getChildren().addAll(groupLabel, TAlabel, member1, member2, member3, member4);
        membersVBox.setAlignment(Pos.CENTER);

        VBox titleContainer = new VBox(titleHBox, membersVBox);
        titleContainer.setAlignment(Pos.CENTER);

        root.setCenter(titleContainer);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }

    private void gameOverState(){
        ImageView gameOverImage = new ImageView(new Image(getClass().getResource("gameOver.png").toExternalForm()));
        gameOverImage.setFitWidth(400);
        gameOverImage.setFitHeight(300);
        HBox imageHBox = new HBox(gameOverImage);
        imageHBox.setAlignment(Pos.CENTER);

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setPrefSize(150, 50);
        playAgainButton.setStyle("-fx-background-color: black");
        playAgainButton.setFont(new Font("Arial", 20));
        playAgainButton.setTextFill(Color.WHITE);
        playAgainButton.setOnAction(event -> {
            startCustomizePage();
        });

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(150, 50);
        exitButton.setStyle("-fx-background-color: black");
        exitButton.setFont(new Font("Arial", 20));
        exitButton.setTextFill(Color.WHITE);
        exitButton.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });


        HBox gameOverButtons = new HBox(20, playAgainButton, exitButton);
        gameOverButtons.setAlignment(Pos.CENTER);

        VBox gameOverContainer = new VBox(imageHBox, gameOverButtons);
        gameOverContainer.setAlignment(Pos.CENTER);

        root.setCenter(gameOverContainer);
        root.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGRAY, null, null)));
    }
    private void startGame() {


        Panel panel = new Panel();
        root.setBottom(panel.getBottom());
        root.setLeft(panel.getLeft());
        root.setRight(panel.getRight());
    }

    public void startPanel() {

    }

    /* Unsure about destructor as exit
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    } */

    public static void main(String[] args) {
        launch();
    }
}