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


public class HelloApplication extends Application {
    BorderPane root = new BorderPane();
    String chosenChar;
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



    }

    public void startCustomizePage() {
        CustomizationPage selectCharacter = new CustomizationPage();
        root.setCenter(selectCharacter.renderOption());
        chosenChar = selectCharacter.selectedCharacter;
        Button selectButton = new Button("Select");
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Selected character: " + selectCharacter.selectedCharacter);

                if (selectCharacter.selectedCharacter != null) {
                    startGame();
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