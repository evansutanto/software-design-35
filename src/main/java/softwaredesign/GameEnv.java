package softwaredesign;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameEnv {
    Pane p;
    ImageView currBackground;
    private void cellBackground(ImageView currBackground){
        Image mainbg = new Image(getClass().getResource("mainbg.jpg").toExternalForm());
        currBackground.setImage(mainbg);
    }

    private void backyardBackground(ImageView currBackground){
        Image mainbg = new Image(getClass().getResource("backyardBackground.png").toExternalForm());
        currBackground.setImage(mainbg);
    }
    public Pane render(){
        return p;
    }
    public GameEnv(){
        currBackground = new ImageView();
        currBackground.setFitHeight(370);
        currBackground.setFitWidth(600);
        cellBackground(currBackground);
//        backyardBackground(currBackground);
        p = new Pane();
        p.getChildren().add(currBackground);
    }
}
