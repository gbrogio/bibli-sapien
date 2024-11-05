package com.application.Telas;

import java.io.IOException;

import com.application.ControladorTela;

import javafx.fxml.FXML;

public class Menu extends ControladorTela {

  @FXML  
  public void irParaEmprestimos() throws IOException {
    this.irPara("emprestimos");
  }

  @FXML  
  public void irParaLivros() throws IOException {
    this.irPara("livros");
  }

  @FXML  
  public void irParaClientes() throws IOException {
    this.irPara("clientes");
  }
}
