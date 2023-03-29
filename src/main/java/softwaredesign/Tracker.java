package softwaredesign;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.TilePane;

public class Tracker {

    TilePane r = new TilePane();
    Button b = new Button("increase");
    ProgressBar pb = new ProgressBar();
    double ii;
    public Tracker() {
        ii = 0;
        // action event
        EventHandler<ActionEvent> event = e -> {
            // set progress to different level of progressbar
            ii += 0.1;
            pb.setProgress(ii);
        };
        // creating button
        // set on action
        b.setOnAction(event);
    }
    public ProgressBar render() {
        r.getChildren().add(pb);
        r.getChildren().add(b);
        return pb;
    }
}
