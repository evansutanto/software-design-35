package softwaredesign;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.TilePane;

import javax.security.auth.Subject;
import java.util.Observable;

public class Tracker implements Observer {
    String text;
    double value;
    TilePane r = new TilePane();
    Button b = new Button("increase");
    ProgressBar pb = new ProgressBar();
    double ii;
    public Tracker() {
        value = 1.0;
        pb.setProgress(value);
    }
    public ProgressBar render() {
        r.getChildren().add(pb);
        r.getChildren().add(b);
        return pb;
    }

    public Tracker(Subject subject) {

    }

    @Override
    public void update(int val) {
        double newVal = ((double) val) / 100;
        this.value = newVal;
        if(this.value < 0 ){
            this.value = 0;
        }
        pb.setProgress(this.value);
    }
}
