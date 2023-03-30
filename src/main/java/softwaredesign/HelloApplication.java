package softwaredesign;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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

        startCustomizePage();
        initCustomPanel();

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
        root.setCenter(selectCharacter.renderOption());
        chosenCharType = selectCharacter.selectedCharacter;
        Button selectButton = new Button("Select");
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
                }
            }
        });

        Panel panel = new Panel();
        panel.setBottom(selectButton);
        root.setBottom(panel.getBottom());
        root.setLeft(panel.getLeft());
        root.setRight(panel.getRight());
    }
    public void initCustomPanel() {

    }

    public void startGame() {
        GameEnv env = new GameEnv();
        root.setCenter(env.render());
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