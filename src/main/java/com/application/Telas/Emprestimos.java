package com.application.Telas;

import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import com.application.Modelos.VisualizarEmprestimo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class Emprestimos extends ControladorEmprestimos {
  @FXML private FlowPane emprestimosView;

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
  private void pesquisar(javafx.scene.input.KeyEvent event) throws IOException {
    String nome = ((javafx.scene.control.TextField)event.getSource()).getText();
    ArrayList<VisualizarEmprestimo> emprestimos =
        this.pegarTodosEmprestimos(nome);
    emprestimosView.getChildren().clear();
    for (VisualizarEmprestimo emprestimo : emprestimos) {
      carregarEmprestimo(emprestimo);
    }
  }

  private void carregarEmprestimo(VisualizarEmprestimo emprestimo)
      throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/com/application/emprestimo-item.fxml"));
    HBox emprestimoBox = loader.load();
    EmprestimoItem controller = loader.getController();

    controller.setEmprestimo(emprestimo);
    emprestimosView.getChildren().add(emprestimoBox);
  }

  private void carregarEmprestimos() throws IOException {
    ArrayList<VisualizarEmprestimo> emprestimos = this.pegarTodosEmprestimos();
    emprestimosView.getChildren().clear();
    for (VisualizarEmprestimo emprestimo : emprestimos) {
      carregarEmprestimo(emprestimo);
    }
  }

  @FXML
  public void initialize() throws IOException {
    carregarEmprestimos();
  }
}
