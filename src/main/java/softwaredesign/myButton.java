package softwaredesign;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class myButton extends StackPane {
    public myButton() {
        Circle circle = new Circle(30, Color.WHITESMOKE);
        Text text = new Text("FEED");
        text.setBoundsType(TextBoundsType.VISUAL);
        this.getChildren().addAll(circle, text);
    }
}
