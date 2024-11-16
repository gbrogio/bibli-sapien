package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.ClienteAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Cliente extends ControladorCliente {
  @FXML private TextField nome;
  @FXML private TextField email;
  @FXML private TextField telefone;
  @FXML private TextField endereco;
  @FXML private DatePicker dataNascimento;
  @FXML private Button salvarClienteBotao;

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

    this.adicionarCliente(nome.getText(), email.getText(),
                          dataNascimento.getValue(), endereco.getText(),
                          telefone.getText());

    salvarClienteBotao.setText("SALVAR");
    salvarClienteBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();

    this.irParaClientes();
  }

  @FXML
  public void alterarCliente() throws IOException {
    if (alterarClienteId <= 0)
      return;

    salvarClienteBotao.setText("SALVANDO...");
    salvarClienteBotao.setDisable(true);
    desabilitarCampos(true);

    this.alterarCliente(alterarClienteId, nome.getText(), email.getText(),
                        dataNascimento.getValue(), endereco.getText(),
                        telefone.getText());

    salvarClienteBotao.setText("SALVAR");
    salvarClienteBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();

    this.irParaClientes();
  }

  private void preencherCampos(int clienteId) {
    ClienteAbstrato cliente = this.pegarCliente(clienteId);
    nome.setText(cliente.nome);
    email.setText(cliente.email);
    telefone.setText(cliente.telefone);
    endereco.setText(cliente.endereco);
    dataNascimento.setValue(cliente.dataNascimento);
  }

  @FXML
  public void initialize() {
    if (alterarClienteId > 0) {
      this.preencherCampos(alterarClienteId);
      salvarClienteBotao.setOnAction(event -> {
        try {
          this.alterarCliente();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } else {
      salvarClienteBotao.setOnAction(event -> {
        try {
          this.criarCliente();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
  }
}
