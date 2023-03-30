package softwaredesign;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class HelloApplication extends Application {
    BorderPane root = new BorderPane();
    String chosenCharType;
    Character myCharacter;
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        titleState();

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        FadeTransition fade = new FadeTransition(Duration.seconds(1), root);

        // Create a delay transition for the titleState
        delay.setOnFinished(e -> fade.play());
        delay.play();

//         Create a fade transition for the BorderPane
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(1);
        fade.setOnFinished(e -> {
            FadeTransition fade2 = new FadeTransition(Duration.seconds(1.5), root);
            fade2.setFromValue(0.0);
            fade2.setToValue(1.0);
            fade2.play();
            startCustomizePage();
        });

//        gameOverState();

        Scene scene = new Scene(root);
        stage.setTitle("Jailbird!");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();



//        CharacterFactory charFactory = new CharacterFactory();
//        myCharacter = charFactory.createCharacter(chosenCharType);

        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                  if(myCharacter != null) {
                      myCharacter.updateHP();
                      if(!myCharacter.isAlive){
                          System.out.println("YOUR PRISONER DIED\nGAMVE OVER");
                          timer.cancel();
                      }
                  }
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if(myCharacter != null) {
                    myCharacter.updateVitals();
                }
            }
        };
        timer.scheduleAtFixedRate(task1, 5000, 5000);
        timer.scheduleAtFixedRate(task2, 5000, 1000);
    }

    public void startCustomizePage() {
        CustomizationPage selectCharacter = new CustomizationPage();
        Panel panel = new Panel();
        Button selectButton = new Button("Select");
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
                    GameEnv env = new GameEnv();
                    root.setCenter(env.render());
                    chosenCharType = selectCharacter.selectedCharacter;
                    CharacterFactory charFactory = new CharacterFactory();
                    myCharacter = charFactory.createCharacter(chosenCharType);

                    Panel gamePanel = new Panel();
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
    public Label authorIdentity(String name){
        Label nameLabel = new Label(name);
        nameLabel.setTextFill(Color.WHITE);
        Font font = new Font("Comic Sans MS", 14);
        nameLabel.setFont(font);
        return nameLabel;
    }
    public void titleState() {
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

    public void gameOverState(){
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

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(150, 50);
        exitButton.setStyle("-fx-background-color: black");
        exitButton.setFont(new Font("Arial", 20));
        exitButton.setTextFill(Color.WHITE);

        HBox gameOverButtons = new HBox(20, playAgainButton, exitButton);
        gameOverButtons.setAlignment(Pos.CENTER);

        VBox gameOverContainer = new VBox(imageHBox, gameOverButtons);
        gameOverContainer.setAlignment(Pos.CENTER);

        root.setCenter(gameOverContainer);
        root.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGRAY, null, null)));
    }
    public void startGame() {
        GameEnv env = new GameEnv();
        root.setCenter(env.render());

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