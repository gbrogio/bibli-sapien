package com.application.Telas;

import com.application.ControladorTela;
import com.application.Database.Database;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.util.Timer;
import java.util.TimerTask;

public class Clientes extends ControladorTela {
    Database db = Database.pegarInstancia();

    @FXML
    private TextField nome;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private TextField endereco;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private Button salvarClienteBotao;

    @FXML
    public void irParaClientes() throws IOException {
        this.irPara("clientes");
    }

    @FXML
    public void irParaCriarCliente() throws IOException {
        this.irPara("criar-cliente");
    }

    private void limparCampos() {
        nome.clear();
        email.clear();
        telefone.clear();
        endereco.clear();
        dataNascimento.getEditor().clear();
    }

    private void desabilitarCampos(boolean desabilitar) {
        nome.setDisable(desabilitar);
        email.setDisable(desabilitar);
        telefone.setDisable(desabilitar);
        endereco.setDisable(desabilitar);
        dataNascimento.setDisable(desabilitar);
    }

    @FXML
    public void criarCliente() throws IOException {
        Timer timer = new Timer();
        salvarClienteBotao.setText("SALVANDO...");
        salvarClienteBotao.setDisable(true);
        desabilitarCampos(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    salvarClienteBotao.setText("SALVAR");
                    salvarClienteBotao.setDisable(false);
                    desabilitarCampos(false);
                    limparCampos();
                });
                timer.cancel();
            }
        }, 2000);
    }
}
