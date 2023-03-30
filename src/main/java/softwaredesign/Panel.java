package softwaredesign;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class Panel {
    public List<myButton> buttons;
    private final VBox sidebarLeft;
    private final VBox sidebarRight;
    private final VBox bottom;
    public Panel() {
        sidebarLeft = new VBox(50);
        sidebarRight = new VBox(50);

        sidebarLeft.setPadding(new Insets(10, 50, 50, 50));
        sidebarLeft.setAlignment(Pos.CENTER);

        sidebarLeft.setStyle("-fx-justify-content: space-between;");

        sidebarRight.setPadding(new Insets(10, 50, 50, 50));
        sidebarRight.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        bottom = new VBox();
//        buttons = List.of(new Button("A"), new Button("B"), new Button("C"), new Button("D"));
        // TODO: Not sure if should be made into variables
        buttons = List.of(new myButton("A"), new myButton("B"), new myButton("C"), new myButton("D"));

//        Button circularBtn = new Button("Click me");
//        circularBtn.setPrefSize(75,75);
//        circularBtn.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
//        StackPane stack = new StackPane(circle, circularBtn);
//        stack.setAlignment(circle, javafx.geometry.Pos.CENTER);
//        circularBtn.setOnAction(e -> {
//            System.out.println("Button is clicked");
//        });
//        myButton btn1 = new myButton("Click me");
//        btn1.setFunction(e -> {System.out.println("TEST");});

        sidebarLeft.getChildren().addAll(buttons.get(0), buttons.get(1));
        sidebarRight.getChildren().addAll(buttons.get(2), buttons.get(3));
    }
    public VBox getRight() {
        sidebarRight.setBackground(Background.fill(Color.PINK));
//        sidebarRight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return sidebarRight;
    }
    public VBox getLeft() {
        sidebarLeft.setBackground(Background.fill(Color.LIGHTGREEN));
//        sidebarLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return sidebarLeft;
    }
    public VBox getBottom() {
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
    public void setButton(int index, EventHandler<MouseEvent> event) {
        buttons.get(index).setFunction(event);
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
