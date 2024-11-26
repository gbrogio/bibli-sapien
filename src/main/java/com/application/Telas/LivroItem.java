package com.application.Telas;

import com.application.Controladores.Livros.ControladorLivros;
import com.application.Modelos.LivroAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LivroItem extends ControladorLivros {

  @FXML private HBox livroBox;

  @FXML private Label nomeLivro;

  @FXML private Text idLivro;

  private LivroAbstrato livro;

  public void setLivro(LivroAbstrato livro) {
    this.livro = livro;
    nomeLivro.setText(livro.getTitulo());
    idLivro.setText(String.valueOf(livro.getId()));
  }

  @FXML
  private void removerLivro() throws IOException {
    this.removerLivro(livro.getId());
    this.irPara("livros");
  }

  @FXML
  private void editarLivro() {
    Livro.alterarLivroId = livro.getId();
    try {
      this.irPara("criar-livro");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
