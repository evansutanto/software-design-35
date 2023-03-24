package softwaredesign;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class CustomizationPage {
    private ImageView selectedCharacterImageView;
    private HBox characterSelectionHBox;
    private HBox selectedCharacterHBox;
    Pane p;

    public CustomizationPage(){
        // Create images for tamagotchi characters
        Image buffPrisoner = new Image(getClass().getResource("Buff.png").toExternalForm());
        Image dancerPrisoner = new Image(getClass().getResource("Dancer.png").toExternalForm());
        Image jokerPrisoner = new Image(getClass().getResource("Joker.png").toExternalForm());

        // Create image views for tamagotchi characters
        ImageView buffPrisonerView = new ImageView(buffPrisoner);
        ImageView dancerPrisonerView = new ImageView(dancerPrisoner);
        ImageView jokerPrisonerView = new ImageView(jokerPrisoner);

        // Set the size of the image views
        buffPrisonerView.setFitWidth(100);
        buffPrisonerView.setFitHeight(100);
        dancerPrisonerView.setFitWidth(100);
        dancerPrisonerView.setFitHeight(100);
        jokerPrisonerView.setFitWidth(100);
        jokerPrisonerView.setFitHeight(100);

        // Create buttons for selecting tamagotchi characters
        Button buffPrisonerButton = new Button("Buff", buffPrisonerView);
        Button dancerPrisonerButton = new Button("Dancer", dancerPrisonerView);
        Button jokerPrisonerButton = new Button("Joker", jokerPrisonerView);

        // Set the size of the buttons
        buffPrisonerButton.setPrefSize(150, 150);
        dancerPrisonerButton.setPrefSize(150, 150);
        jokerPrisonerButton.setPrefSize(150, 150);

        buffPrisonerButton.setContentDisplay(ContentDisplay.TOP);
        dancerPrisonerButton.setContentDisplay(ContentDisplay.TOP);
        jokerPrisonerButton.setContentDisplay(ContentDisplay.TOP);

        // Set the action for selecting character 1
        buffPrisonerButton.setOnAction(event -> {
            selectedCharacterImageView.setImage(buffPrisoner);
            System.out.println("Selected character = buff prisoner");
        });

        // Set the action for selecting character 2
        dancerPrisonerButton.setOnAction(event -> {
            selectedCharacterImageView.setImage(dancerPrisoner);
            System.out.println("Selected character = dancer prisoner");
        });

        // Set the action for selecting character 3
        jokerPrisonerButton.setOnAction(event -> {
            selectedCharacterImageView.setImage(jokerPrisoner);
            System.out.println("Selected character = joker prisoner");
        });

        // Create a hbox to hold the character selection options buttons
        characterSelectionHBox = new HBox(20, buffPrisonerButton, dancerPrisonerButton, jokerPrisonerButton);
        characterSelectionHBox.setAlignment(Pos.CENTER);

        // Create an hbox to hold the selected character image
        selectedCharacterImageView = new ImageView();
        selectedCharacterImageView.setFitWidth(200);
        selectedCharacterImageView.setFitHeight(200);
        selectedCharacterHBox = new HBox(selectedCharacterImageView);
        selectedCharacterHBox.setAlignment(Pos.CENTER);
    }

    public HBox renderOption(){ return characterSelectionHBox;}

    public HBox renderSelectedCharacter() {return selectedCharacterHBox;}


}
