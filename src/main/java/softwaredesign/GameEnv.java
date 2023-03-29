package softwaredesign;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GameEnv {
    Pane p;
    private boolean isCellBg = true;
    public void setBackground(){
        Image cellbg = new Image(getClass().getResource("mainbg.jpg").toExternalForm());
        Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());

        p = new Pane();
        Button switchButton = new Button("switch");
        p.getChildren().add(switchButton);

        BackgroundImage cell = new BackgroundImage(cellbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));
        p.setBackground(new Background(cell));

        switchButton.setOnAction(event -> {
            if (isCellBg) {
                BackgroundImage backyard = new BackgroundImage(backyardbg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));
                p.setBackground(new Background(backyard));
                isCellBg = false;

            } else {
                p.setBackground(new Background(cell));
                isCellBg = true;
            }
        });
    }
    public Pane render(){
        return p;
    }
    public GameEnv(){
        setBackground();
    }
}
