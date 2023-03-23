package softwaredesign;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        BorderPane root = new BorderPane();
//        Should be panel since container
//        Label label_center = new Label("this is BorderPane center");
//        label_center.setBackground(Background.fill(Color.LIGHTGRAY));
//        label_center.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        root.setCenter(label_center);

        GameEnv env = new GameEnv();
        root.setCenter(env.render());

        Label label_top = new Label("this is BorderPane top");
        label_top.setBackground(Background.fill(Color.LIGHTBLUE));
        label_top.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label_top.setPrefHeight(20);
        root.setTop(label_top);

        Label label_bottom = new Label("this is BorderPane bottom");
        label_bottom.setBackground(Background.fill(Color.YELLOW));
        label_bottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label_bottom.setPrefHeight(180);
        root.setBottom(label_bottom);

        Label label_left = new Label("this is BorderPane left");
        label_left.setBackground(Background.fill(Color.LIGHTGREEN));
        label_left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setLeft(label_left);

        Label label_right = new Label("this is BorderPane right");
        label_right.setBackground(Background.fill(Color.PINK));
        label_right.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setRight(label_right);

        // set alignment alternative
        /*
        border_pane.setAlignment(label_top, Pos.CENTER);
        border_pane.setAlignment(label_bottom, Pos.CENTER);
        border_pane.setAlignment(label_left, Pos.CENTER);
        border_pane.setAlignment(label_right, Pos.CENTER);
        */

        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}