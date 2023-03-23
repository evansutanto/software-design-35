package softwaredesign;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameEnv {
    Pane p;
    private ImageView currBackground;
    private boolean isCellBg;
    public void setBackground(){
        Image cellbg = new Image(getClass().getResource("mainbg.jpg").toExternalForm());
        Image backyardbg =  new Image(getClass().getResource("backyardBackground.png").toExternalForm());

        currBackground = new ImageView(cellbg);
        currBackground.setFitHeight(370);
        currBackground.setFitWidth(600);

        Button switchButton = new Button("switch");
        switchButton.setOnAction(event -> {
            if (isCellBg) {
                currBackground.setImage(backyardbg);
                isCellBg = false;
            } else {
                currBackground.setImage(cellbg);
                isCellBg = true;
            }
        });

        p = new Pane();
        p.getChildren().addAll(currBackground, switchButton);
    }
    public Pane render(){
        return p;
    }
    public GameEnv(){
        setBackground();
    }
}
