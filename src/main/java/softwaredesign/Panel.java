package softwaredesign;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.List;

public class Panel {
    public List<myButton> buttons;
    public Tracker hungerTracker = new Tracker();
    public Tracker sleepTracker = new Tracker();
    public Tracker moodTracker = new Tracker();
    public Tracker hygienTracker = new Tracker();
    public Tracker healthTracker = new Tracker();
    private final VBox sidebarLeft;
    private final VBox sidebarRight;
    private final HBox bottom;
    public Panel() {
        sidebarLeft = new VBox(20);
        sidebarRight = new VBox(20);

        sidebarLeft.setPadding(new Insets(10, 50, 50, 50));
        sidebarLeft.setAlignment(Pos.CENTER);

        sidebarLeft.setStyle("-fx-justify-content: space-between;");

        sidebarRight.setPadding(new Insets(10, 50, 50, 50));
        sidebarRight.setAlignment(Pos.CENTER);

        VBox hungerVBox = new VBox(5, new Label("Hunger:"), hungerTracker.render());
        hungerVBox.setAlignment(Pos.CENTER);
        VBox hygieneVBox = new VBox(5, new Label("Hygiene:"), hygienTracker.render());
        hygieneVBox.setAlignment(Pos.CENTER);
        VBox sleepVBox = new VBox(5, new Label("Sleep:"), sleepTracker.render());
        sleepVBox.setAlignment(Pos.CENTER);
        VBox moodVBox = new VBox(5, new Label("Mood:"), moodTracker.render());
        moodVBox.setAlignment(Pos.CENTER);
        VBox healthVBox = new VBox(5, new Label("Health:"), healthTracker.render());
        healthVBox.setAlignment(Pos.CENTER);

        bottom = new HBox(5, hungerVBox, hygieneVBox, sleepVBox, moodVBox, healthVBox);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        // TODO: Not sure if should be made into variables
        buttons = List.of(new myButton("A"), new myButton("B"), new myButton("C"), new myButton("D"), new myButton("E"));

        sidebarLeft.getChildren().addAll(buttons.get(0), buttons.get(1), buttons.get(2));
        sidebarRight.getChildren().addAll(buttons.get(3), buttons.get(4));
    }
    public VBox getRight() {
        sidebarRight.setBackground(Background.fill(Color.PINK));
        return sidebarRight;
    }
    public VBox getLeft() {
        sidebarLeft.setBackground(Background.fill(Color.LIGHTGREEN));
        return sidebarLeft;
    }
    public HBox getBottom() {
        bottom.setPrefHeight(180);
        bottom.setBackground(Background.fill(Color.LIGHTGRAY));
        bottom.setSpacing(40);
        bottom.setAlignment(Pos.CENTER);
        return bottom;
    }
    public void setBottom(Node input) {
        bottom.getChildren().clear();
        bottom.getChildren().add(input);
    }
    public void setButton(int index, String text, EventHandler<MouseEvent> event) {
        buttons.get(index).setFunction(event);
        buttons.get(index).rename(text);
    }
    public void setTracker() {
        Tracker hunger = new Tracker();
        Tracker sleepiness = new Tracker();
        Tracker hygiene = new Tracker();
        Tracker mood = new Tracker();

        bottom.getChildren().add(hunger.render());
        bottom.getChildren().add(sleepiness.render());
        bottom.getChildren().add(hygiene.render());
        bottom.getChildren().add(mood.render());
    }
}
