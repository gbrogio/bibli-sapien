package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import com.application.Controladores.Livros.ControladorLivros;
import com.application.Modelos.ClienteAbstrato;
import com.application.Modelos.LivroAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Devolver extends ControladorEmprestimos {
  @FXML private TextField livroId;
  @FXML private TextField clienteId;
  // @FXML private DatePicker dataEmprestimo;
  @FXML private Text mensagemErro;
  @FXML private Button salvarBotao;
  @FXML private Text livroDetalhes;
  @FXML private Text clienteDetalhes;

  @FXML
  public void irParaEmprestimos() throws IOException {
    this.irPara("emprestimos");
  }

  @FXML
  public void irParaDevolverEmprestimo() throws IOException {
    this.irPara("devolver-emprestimo");
  }

  @FXML
  public void irParaCriarEmprestimo() throws IOException {
    this.irPara("criar-emprestimo");
  }

  @FXML
  void pegarDetalhesLivro() {
    if (livroId.getText().isEmpty()) {
      livroDetalhes.setText("");
      return;
    }

    LivroAbstrato livro =
        ControladorLivros.pegarLivro(Integer.parseInt(livroId.getText()));
    if (livro == null) {
      livroDetalhes.setText("Livro não encontrado.");
      return;
    }

    livroDetalhes.setText("Livro: " + livro.getTitulo() + " - " +
                          livro.getAutor());
  }

  @FXML
  void pegarDetalhesCliente() {
    if (clienteId.getText().isEmpty()) {
      clienteDetalhes.setText("");
      return;
    }

    ClienteAbstrato cliente =
        ControladorCliente.pegarCliente(Integer.parseInt(clienteId.getText()));
    if (cliente == null) {
      clienteDetalhes.setText("Cliente não encontrado.");
      return;
    }

    clienteDetalhes.setText("Cliente: " + cliente.getNome());
  }

  private void limparCampos() {
    livroId.setText("");
    clienteId.setText("");
    // dataEmprestimo.setValue(null);
    clienteDetalhes.setText("");
    livroDetalhes.setText("");
  }

  private void desabilitarCampos(boolean desabilitar) {
    livroId.setDisable(desabilitar);
    clienteId.setDisable(desabilitar);
    // dataEmprestimo.setDisable(desabilitar);
  }

  @FXML
  public void devolver() throws IOException {
    salvarBotao.setText("SALVANDO...");
    salvarBotao.setDisable(true);
    desabilitarCampos(true);

    if (livroId.getText().isEmpty() || clienteId.getText().isEmpty()) {
      mensagemErro.setText("Preencha todos os campos!");
      salvarBotao.setText("SALVAR");
      salvarBotao.setDisable(false);
      desabilitarCampos(false);
      return;
    }

    int livroIdInt = Integer.parseInt(livroId.getText());
    int clienteIdInt = Integer.parseInt(clienteId.getText());

    Boolean sucesso = devolverLivro(livroIdInt, clienteIdInt);

    salvarBotao.setText("SALVAR");
    salvarBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();

    if (sucesso) {
      irParaEmprestimos();
    } else {
      mensagemErro.setText("Não foi possível realizar a devolução!");
    }
  }
}
