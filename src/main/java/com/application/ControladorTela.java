package com.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControladorTela {
    @FXML
    private void close() {
        System.exit(0);
    }

    @FXML
    protected void irPara(String tela) throws IOException {
        App.setRoot(tela);
    }

    @FXML
    private void voltar() throws IOException {
        this.irPara("menu");
    }
}
