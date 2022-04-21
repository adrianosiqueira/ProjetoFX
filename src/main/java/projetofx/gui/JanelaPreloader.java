package projetofx.gui;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class JanelaPreloader extends Preloader {

    private Stage stage;

    @SneakyThrows
    @SuppressWarnings("ConstantConditions")
    private Scene createScene() {
        Parent root = FXMLLoader.load(getClass().getResource("JanelaPreloader.fxml"));

        return new Scene(root);
    }

    /**
     * Atrasa um segundo para fechar o preloader para dar tempo da janela
     * principal se tornar visível.
     */
    private void fecharComAtraso() {
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {}

            Platform.runLater(stage::close);
        };

        new Thread(runnable).start();
    }


    /**
     * Intercepta as notificações de mudança de estado da aplicação. Quando
     * encontrar o estado responsável por fechar o preloader, será aplicado um
     * atraso antes do fechamento.
     */
    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if (info.getType() == StateChangeNotification.Type.BEFORE_START) fecharComAtraso();
        else super.handleStateChangeNotification(info);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(createScene());
        stage.show();
    }
}
