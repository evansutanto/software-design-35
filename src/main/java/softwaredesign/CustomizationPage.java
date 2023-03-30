package softwaredesign;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CustomizationPage {
    Pane p;
    private ImageView selectedCharacterImageView;
    private VBox characterOptionsContainer;
    public static String selectedCharacter;
    public Character chosenCharacter;

    public Button createButton(String name, String file){
        Image prisoner = new Image(getClass().getResource(file).toExternalForm());
        ImageView prisonerView = new ImageView(prisoner);
        prisonerView.setFitWidth(100);
        prisonerView.setFitHeight(100);
        Button prisonerButton = new Button(name, prisonerView);
        prisonerButton.setPrefSize(150, 150);
        prisonerButton.setContentDisplay(ContentDisplay.TOP);
        prisonerButton.setOnAction(event -> {
            selectedCharacterImageView.setImage(prisoner);
            System.out.println("Selected character = " + name);
            selectedCharacter = name;
        });
        return prisonerButton;
    }

    public CustomizationPage(){
//         Create a hbox to hold the character selection options buttons
        Button buffButton = createButton("Buff", "Buff.png");
        Button dancerButton = createButton("Dancer", "Dancer.png");
        Button jokerButton = createButton("Joker", "Joker.png");
        HBox characterSelectionHBox = new HBox(20, buffButton, dancerButton, jokerButton);
        characterSelectionHBox.setAlignment(Pos.CENTER);

        // Create an hbox to hold the selected character image
        selectedCharacterImageView = new ImageView();
        selectedCharacterImageView.setFitWidth(200);
        selectedCharacterImageView.setFitHeight(200);
        HBox selectedCharacterHBox = new HBox(selectedCharacterImageView);
        selectedCharacterHBox.setAlignment(Pos.CENTER);

        // Create a vbox to hold the character selection and selected character image nodes
        characterOptionsContainer = new VBox(characterSelectionHBox, selectedCharacterHBox);
        characterOptionsContainer.setAlignment(Pos.CENTER);
        Image yardbg =  new Image(getClass().getResource("Yard.jpeg").toExternalForm());
        BackgroundImage yard = new BackgroundImage(yardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        characterOptionsContainer.setBackground(new Background(yard));
    }
    public VBox renderOption(){return characterOptionsContainer;}
}
