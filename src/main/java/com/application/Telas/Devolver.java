package com.application.Telas;

import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Devolver extends ControladorEmprestimos {
  @FXML private TextField livroId;
  @FXML private TextField clienteId;
  @FXML private DatePicker dataEmprestimo;
  @FXML private TextField mensagemErro;
  @FXML private Button salvarBotao;

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
    dataEmprestimo.setValue(null);
  }

  private void desabilitarCampos(boolean desabilitar) {
    livroId.setDisable(desabilitar);
    dataEmprestimo.setDisable(desabilitar);
  }

  @FXML
  public void devolver() throws IOException {
    salvarBotao.setText("SALVANDO...");
    salvarBotao.setDisable(true);
    desabilitarCampos(true);

    if (livroId.getText().isEmpty()) {
      mensagemErro.setText("Preencha todos os campos!");
      salvarBotao.setText("SALVAR");
      salvarBotao.setDisable(false);
      desabilitarCampos(false);
      return;
    }

    int livroIdInt = Integer.parseInt(livroId.getText());
    int clienteIdInt = Integer.parseInt(clienteId.getText());

    if (dataEmprestimo.getValue() == null) {
      devolverLivro(livroIdInt, clienteIdInt);
    }

    salvarBotao.setText("SALVAR");
    salvarBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();
  }
}
