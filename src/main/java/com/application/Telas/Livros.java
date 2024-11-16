package com.application.Telas;

import com.application.Controladores.Livros.ControladorLivros;
import com.application.Modelos.LivroAbstrato;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Livros extends ControladorLivros {
  @FXML private FlowPane livrosView;

  @FXML
  public void irParaLivros() throws IOException {
    this.irPara("livros");
  }

  @FXML
  public void irParaCriarLivros() throws IOException {
    this.irPara("criar-livro");
  }

  @FXML
  private void pesquisar(javafx.scene.input.KeyEvent event) throws IOException {
    String nome = ((javafx.scene.control.TextField)event.getSource()).getText();
    ArrayList<LivroAbstrato> livros = this.pegarTodosLivros(nome);
    livrosView.getChildren().clear();
    for (LivroAbstrato livro : livros) {
      carregarLivros(livro);
    }
  }

  private void carregarLivros(LivroAbstrato livro) throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/com/application/livro-item.fxml"));
    VBox livroBox = loader.load();
    LivroItem controller = loader.getController();

    controller.setLivro(livro);
    livrosView.getChildren().add(livroBox);
  }

  private void carregarLivros() throws IOException {
    ArrayList<LivroAbstrato> livros = pegarTodosLivros();
    livrosView.getChildren().clear();
    for (LivroAbstrato livro : livros) {
      carregarLivros(livro);
    }
  }

  @FXML
  public void initialize() throws IOException {
    carregarLivros();
  }
}
