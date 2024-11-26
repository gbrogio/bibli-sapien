package com.application.Telas;

import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Emprestimos extends ControladorEmprestimos {

  @FXML private TextField livroId;
  @FXML private TextField clienteId;
  @FXML private DatePicker dataEmprestimo;
  @FXML private TextField mensagemErro;
  @FXML private Button salvarEmprestimoBotao;

  static int alterarEmprestimoId;
    
  @FXML
  public void irParaEmprestimos() throws IOException {
    this.irPara("emprestimos");
  }

  @FXML
  public void irParaEmprestarEmprestimos() throws IOException {
    this.irPara("emprestimos-emprestar");
    Emprestimos.alterarEmprestimoId = 0;
  }

  private void limparCampos() {
    livroId.setText("");
    clienteId.setText("");
    dataEmprestimo.setValue(null);
  }

  private void desabilitarCampos(boolean desabilitar) {
    livroId.setDisable(desabilitar);
    clienteId.setDisable(desabilitar);
    dataEmprestimo.setDisable(desabilitar);
  }

  @FXML
  public void emprestimoEmprestar() throws IOException {
    if(alterarEmprestimoId > 0){
        return;
    }
    
    mensagemErro.setText("");
    
    if(validarEntrada()){
        return;
    }
    
    salvarEmprestimoBotao.setText("SALVANDO...");
    salvarEmprestimoBotao.setDisable(true);
    desabilitarCampos(true);

    this.emprestarLivro(Integer.parseInt(livroId.getText()), Integer.parseInt(clienteId.getText()), dataEmprestimo.getValue());
    
    salvarEmprestimoBotao.setText("SALVAR");
    salvarEmprestimoBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();
    this.irParaEmprestarEmprestimos();
  }
  
  public boolean validarEntrada(){
      
    if (dataEmprestimo.getValue() == null || dataEmprestimo.getValue().isAfter(java.time.LocalDate.now())) {
      mensagemErro.setText("Ano Invalido");
      return true;
    }

    int livroNegativo = Integer.parseInt(livroId.getText());
    if(livroNegativo < 0) {
      mensagemErro.setText("Livro invalido");
      return true;
    }
    
    int clienteNegativo = Integer.parseInt(clienteId.getText());
    if(clienteNegativo < 0){
        mensagemErro.setText("Clinte com Id negativo não existe.");
    }
    if(clienteNegativo > 100){
        mensagemErro.setText("Id Invalido");
    }
  
      return false;
  }
  @FXML
  public void initialize() {
    if (alterarEmprestimoId > 0) {
      salvarEmprestimoBotao.setOnAction(event -> {
        try {
          this.emprestimoEmprestar();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
  }  
}
