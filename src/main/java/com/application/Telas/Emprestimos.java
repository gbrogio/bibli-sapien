package com.application.Telas;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import com.application.Database.Database;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Emprestimos extends ControladorEmprestimos {
    Database db = Database.pegarInstancia();
    
    @FXML
    private TextField livroId;
    @FXML
    private TextField pessoaId;
    @FXML
    private TextField autor;
    @FXML
    private DatePicker dataEmprestimo;
    @FXML
    private Button salvarEmprestimoBotao;
    
    @FXML  
    public void irParaEmprestimos() throws IOException {
        this.irPara("emprestimos");
    }
    
    @FXML  
    public void irParaDevolverEmprestimos() throws IOException {
        this.irPara("emprestimos_devolver");
    }

    @FXML  
    public void irParaEmprestarEmprestimos() throws IOException {
        this.irPara("emprestimos_emprestar");
    }

    private void limparCampos() {
        livroId.setText("");
        pessoaId.setText("");
        dataEmprestimo.setValue(null);
        autor.setText("");
    }
    
    private void desabilitarCampos(boolean desabilitar) {
        livroId.setDisable(desabilitar);
        pessoaId.setDisable(desabilitar);
        dataEmprestimo.setDisable(desabilitar);
        autor.setDisable(desabilitar);
    }
    
    @FXML
    public void criarEmprestimo() throws IOException {
        Timer timer = new Timer();
        salvarEmprestimoBotao.setText("SALVANDO...");
        salvarEmprestimoBotao.setDisable(true);
        desabilitarCampos(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    salvarEmprestimoBotao.setText("SALVAR");
                    salvarEmprestimoBotao.setDisable(false);
                    desabilitarCampos(false);
                    limparCampos();
                });
                timer.cancel();
            }
        }, 2000);
    }    
}
