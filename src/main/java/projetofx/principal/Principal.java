package projetofx.principal;

import javafx.application.Application;
import projetofx.gui.JanelaPreloader;
import projetofx.gui.JanelaPrincipal;

public class Principal {

    public static void main(String[] args) {
        adicionarTelaPreloader();
        abrirJanelaPrincipal(args);
    }

    private static void abrirJanelaPrincipal(String[] args) {
        Application.launch(JanelaPrincipal.class, args);
    }

    private static void adicionarTelaPreloader() {
        String preloaderName = JanelaPreloader.class.getCanonicalName();
        System.setProperty("javafx.preloader", preloaderName);
    }
}
