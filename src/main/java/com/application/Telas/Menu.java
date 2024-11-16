package com.application.Telas;

import com.application.ControladorTela;
import java.io.IOException;
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
