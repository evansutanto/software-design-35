package softwaredesign;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.List;

public class Panel {
    public List<Button> buttons;
    private final VBox sidebarLeft;
    private final VBox sidebarRight;
    private final HBox bottom;
    public Panel() {
        sidebarLeft = new VBox();
        sidebarRight = new VBox();
        sidebarLeft.setPadding(new Insets(10, 50, 50, 50));
        sidebarLeft.setSpacing(10);
        sidebarRight.setPadding(new Insets(10, 50, 50, 50));
        sidebarRight.setSpacing(10);
        bottom = new HBox();
        buttons = List.of(new Button(), new Button(), new Button(), new Button());

        sidebarLeft.getChildren().add(buttons.get(0));
        sidebarLeft.getChildren().add(buttons.get(1));
        sidebarRight.getChildren().add(buttons.get(2));
        sidebarRight.getChildren().add(buttons.get(3));

        Tracker hunger = new Tracker();
        Tracker sleepiness = new Tracker();
        Tracker hygiene = new Tracker();
        Tracker mood = new Tracker();

        bottom.getChildren().add(hunger.render());
        bottom.getChildren().add(sleepiness.render());
        bottom.getChildren().add(hygiene.render());
        bottom.getChildren().add(mood.render());
    }
    public VBox getRight() {
        sidebarRight.setBackground(Background.fill(Color.PINK));
        sidebarRight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return sidebarRight;
    }
    public VBox getLeft() {
        sidebarLeft.setBackground(Background.fill(Color.LIGHTGREEN));
        sidebarLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
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
}
