package softwaredesign;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class myButton extends StackPane {
    private Button btn;
    public myButton(String text) {
        Circle circle = new Circle(30, Color.WHITESMOKE);
        btn = new Button(text);
        btn.setStyle("-fx-background-color: transparent;");
        btn.setPrefSize(75, 75);
        this.getChildren().addAll(circle, btn);
    }
    public void setFunction(EventHandler<MouseEvent> event) {
        btn.setOnMouseClicked(null);
        btn.setOnMouseClicked(event);
    }
}
