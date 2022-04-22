package projetofx.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class JanelaPrincipal extends Application {

    @SneakyThrows
    @SuppressWarnings("ConstantConditions")
    private Scene createScene() {
        Parent root = FXMLLoader.load(getClass().getResource("JanelaPrincipal.fxml"));

        return new Scene(root);
    }

    @SneakyThrows
    @Override
    public void start(Stage stage) {
        stage.setTitle("Janela Principal");
        stage.setScene(createScene());
        stage.show();
    }
}
