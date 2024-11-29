package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.ClienteAbstrato;
import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Cliente extends ControladorCliente {
  @FXML private TextField nome;
  @FXML private TextField email;
  @FXML private TextField telefone;
  @FXML private TextField endereco;
  @FXML private DatePicker dataNascimento;
  @FXML private Button salvarClienteBotao;
  @FXML private Text mensagemErro;

  static int alterarClienteId;

  @FXML
  public void irParaClientes() throws IOException {
    this.irPara("clientes");
  }

  @FXML
  public void irParaCriarCliente() throws IOException {
    this.irPara("criar-cliente");
    Cliente.alterarClienteId = 0;
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

    mensagemErro.setText("");

    if (validarEntrada()) {
      return;
    }

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

  public boolean validarEntrada() {
    String emailValidar = email.getText();
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]{2,}\\.[a-zA-Z]{2,}$";

    if (emailValidar == null || !Pattern.matches(emailRegex, emailValidar)) {
      mensagemErro.setText("Email Incorreto");
      return true;
    }

    String telefoneText = telefone.getText();
    if (telefoneText == null || telefoneText.length() != 11 ||
        !Pattern.matches("[0-9]+", telefoneText)) {
      mensagemErro.setText("Telefone Incorreto");
      return true;
    }

    if (dataNascimento.getValue() == null ||
        dataNascimento.getValue().isAfter(
            java.time.LocalDate.now().minusYears(5))) {
      mensagemErro.setText("Data de Nascimento Incorreto");
      return true;
    }

    return false;
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
    ClienteAbstrato cliente = ControladorCliente.pegarCliente(clienteId);
    nome.setText(cliente.getNome());
    email.setText(cliente.getEmail());
    telefone.setText(cliente.getTelefone());
    endereco.setText(cliente.getEndereco());
    dataNascimento.setValue(cliente.getDataNascimento());
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
