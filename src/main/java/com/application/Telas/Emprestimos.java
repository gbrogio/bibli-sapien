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
    private DatePicker dataEmprestimo;
    @FXML
    private DatePicker dataDevolucao;
    @FXML
    private Button salvarEmprestimoBotao;
    @FXML
    private Button salvarEmprestimoBotaoDevolucao;
    
    @FXML  
    public void irParaEmprestimos() throws IOException {
        this.irPara("emprestimos");
    }
    
    @FXML  
    public void irParaDevolverEmprestimos() throws IOException {
        this.irPara("emprestimos-devolver");
    }

    @FXML  
    public void irParaEmprestarEmprestimos() throws IOException {
        this.irPara("emprestimos-emprestar");
    }

    private void limparCampos() {
        livroId.setText("");
        pessoaId.setText("");
        dataEmprestimo.setValue(null);
    }
    
    private void limparCamposDevolucao() {
        livroId.setText("");
        pessoaId.setText("");
        dataDevolucao.setValue(null);
    }
    
    private void desabilitarCampos(boolean desabilitar) {
        livroId.setDisable(desabilitar);
        pessoaId.setDisable(desabilitar);
        dataEmprestimo.setDisable(desabilitar);
    }
    
    private void desabilitarCamposDevolucao(boolean desabilitar) {
        livroId.setDisable(desabilitar);
        pessoaId.setDisable(desabilitar);
        dataDevolucao.setDisable(desabilitar);
    }
    
    @FXML
    public void emprestimoEmprestar() throws IOException {
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

    public void emprestimoDevolver() throws IOException {
        Timer timer = new Timer();
        salvarEmprestimoBotaoDevolucao.setText("SALVANDO...");
        salvarEmprestimoBotaoDevolucao.setDisable(true);
        desabilitarCamposDevolucao(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    salvarEmprestimoBotaoDevolucao.setText("SALVAR");
                    salvarEmprestimoBotaoDevolucao.setDisable(false);
                    desabilitarCamposDevolucao(false);
                    limparCamposDevolucao();
                });
                timer.cancel();
            }
        }, 2000);
    }    
    
        // this.emprestarLivro(0, 0);
        // this.emprestarLivro(0, 0, null);

        // this.pegarEmprestimo(0);
        // this.pegarTodosEmprestimos();
        // this.pegarEprestimosPorCliente(0);

        // devolverLivro(0);
    
}
