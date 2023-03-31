package softwaredesign;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
        sidebarLeft = new VBox(50);
        sidebarRight = new VBox(50);

        sidebarLeft.setPadding(new Insets(10, 50, 50, 50));
        sidebarLeft.setAlignment(Pos.CENTER);

        sidebarLeft.setStyle("-fx-justify-content: space-between;");

        sidebarRight.setPadding(new Insets(10, 50, 50, 50));
        sidebarRight.setAlignment(Pos.CENTER);

        bottom = new HBox();
        bottom.getChildren().addAll(hungerTracker.render(), hygienTracker.render(), sleepTracker.render(), moodTracker.render(),healthTracker.render());

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        // TODO: Not sure if should be made into variables
        buttons = List.of(new myButton("A"), new myButton("B"), new myButton("C"), new myButton("D"));

        sidebarLeft.getChildren().addAll(buttons.get(0), buttons.get(1));
        sidebarRight.getChildren().addAll(buttons.get(2), buttons.get(3));
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
