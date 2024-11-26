package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.VisualizarEmprestimo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EmprestimoItem extends ControladorCliente {

  @FXML private HBox clienteBox;

  @FXML private Label nomeCliente;
  @FXML private Label tituloLivro;
  @FXML private Label dataEmprestimo;

  public void setEmprestimo(VisualizarEmprestimo emprestimoDados) {
    this.nomeCliente.setText(emprestimoDados.getNomeCliente());
    this.tituloLivro.setText(emprestimoDados.getTituloLivro());
    this.dataEmprestimo.setText(emprestimoDados.getDataEmprestimo().toString());
  }
}
