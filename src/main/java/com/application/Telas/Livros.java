package com.application.Telas;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.application.Controladores.Livros.ControladorLivros;
import com.application.Database.Database;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Livros extends ControladorLivros {
    Database db = Database.pegarInstancia();

    @FXML
    private TextField titulo;
    @FXML
    private TextField autor;
    @FXML
    private DatePicker ano;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField genero;
    @FXML
    private Button salvarLivroBotao;

    @FXML  
    public void irParaLivros() throws IOException {
        this.irPara("livros");
    }

    @FXML  
    public void irParaCriarLivro() throws IOException {
        this.irPara("criar-livro");
    }

    private void limparCampos() {
        titulo.setText("");
        autor.setText("");
        ano.setValue(null);
        quantidade.setText("");
        genero.setText("");
    }

    private void desabilitarCampos(boolean desabilitar) {
        titulo.setDisable(desabilitar);
        autor.setDisable(desabilitar);
        ano.setDisable(desabilitar);
        quantidade.setDisable(desabilitar);
        genero.setDisable(desabilitar);
    }

    @FXML
    public void criarLivro() throws IOException {
        Timer timer = new Timer();
        salvarLivroBotao.setText("SALVANDO...");
        salvarLivroBotao.setDisable(true);
        desabilitarCampos(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    salvarLivroBotao.setText("SALVAR");
                    salvarLivroBotao.setDisable(false);
                    desabilitarCampos(false);
                    limparCampos();
                });
                timer.cancel();
            }
        }, 2000);
    }
}

