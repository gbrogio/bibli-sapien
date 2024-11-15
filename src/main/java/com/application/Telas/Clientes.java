package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Clientes extends ControladorCliente {
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

    static int alterarClienteId;

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
        salvarClienteBotao.setText("SALVANDO...");
        salvarClienteBotao.setDisable(true);
        desabilitarCampos(true);

        this.adicionarCliente(nome.getText(), email.getText(), dataNascimento.getValue(), endereco.getText(),
                telefone.getText());

        salvarClienteBotao.setText("SALVAR");
        salvarClienteBotao.setDisable(false);
        desabilitarCampos(false);
        limparCampos();
    }

    public void alterarCliente() throws IOException {
        if (alterarClienteId <= 0)
            return;

        salvarClienteBotao.setText("SALVANDO...");
        salvarClienteBotao.setDisable(true);
        desabilitarCampos(true);

        this.alterarCliente(alterarClienteId, nome.getText(), email.getText(), dataNascimento.getValue(),
                endereco.getText(), telefone.getText());

        salvarClienteBotao.setText("SALVAR");
        salvarClienteBotao.setDisable(false);
        desabilitarCampos(false);
        limparCampos();
    }
}
