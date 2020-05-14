package pacote;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Programa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Olá Mundo!");

        Button button = new Button("OK");
        button.setOnAction(event -> primaryStage.close());

        VBox pane = new VBox(15, label, button);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15));

        primaryStage.setTitle("Olá Mundo");
        primaryStage.setScene(new Scene(pane));
        primaryStage.setAlwaysOnTop(true);

        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
