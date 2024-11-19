package com.application.Telas;

import com.application.Controladores.Livros.ControladorLivros;
import com.application.Modelos.LivroAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Livro extends ControladorLivros {
  @FXML private TextField titulo;
  @FXML private TextField autor;
  @FXML private DatePicker ano;
  @FXML private TextField quantidade;
  @FXML private TextField genero;
  @FXML private Button salvarLivroBotao;
  @FXML private Text mensagemErro;

  static int alterarLivroId;

  @FXML
  public void irParaLivros() throws IOException {
    this.irPara("livros");
  }

  @FXML
  public void irParaCriarLivros() throws IOException {
    this.irPara("criar-livro");
  }

  private void limparCampos() {
    titulo.setText("");
    autor.setText("");
    ano.setValue(null);
    quantidade.setText("");
    genero.setText("");
  }

  private void desabilitarCampos(boolean desabilitar) {
    titulo.setDisable(desabilitar);
    autor.setDisable(desabilitar);
    ano.setDisable(desabilitar);
    quantidade.setDisable(desabilitar);
    genero.setDisable(desabilitar);
  }

}
  @FXML
  public void criarLivro() throws IOException {
    if (alterarLivroId > 0)
      return;

      mensagemErro.setText("");

    if(validarEntrada()){
        return;
    }
  
    salvarLivroBotao.setText("SALVANDO...");
    salvarLivroBotao.setDisable(true);
    desabilitarCampos(true);

    this.adicionarLivro(titulo.getText(), autor.getText(), genero.getText(),
                        Integer.parseInt(quantidade.getText()), ano.getValue());

    salvarLivroBotao.setText("SALVAR");
    salvarLivroBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();
    this.irParaLivros();
  }

    public boolean validarEntrada(){
    if(ano.getValue() == null || ano.getValue().isAfter(java.time.LocalDate.now()){
        mensagemErro.setText("Ano Invalido");
        return true;
    } 

    int quantidadeInt = Integer.parseInt(quantidade.getText());
    if (quantidadeInt <= 0){
        mensagemErro.setText("Quantidade Invalido");
        return true;
    }

    return false;
 }

  @FXML
  public void alterarLivro() throws IOException {
    if (alterarLivroId <= 0)
      return;

    salvarLivroBotao.setText("SALVANDO...");
    salvarLivroBotao.setDisable(true);
    desabilitarCampos(true);

    this.alterarLivro(alterarLivroId, titulo.getText(), autor.getText(),
                      genero.getText(), Integer.parseInt(quantidade.getText()),
                      ano.getValue());

    alterarLivroId = 0;

    salvarLivroBotao.setText("SALVAR");
    salvarLivroBotao.setDisable(false);
    desabilitarCampos(false);
    limparCampos();
    this.irParaLivros();
  }

  private void preencherCampos(int livroId) {
    LivroAbstrato livro = this.pegarLivro(livroId);
    titulo.setText(livro.titulo);
    autor.setText(livro.autor);
    genero.setText(livro.genero);
    quantidade.setText(String.valueOf(livro.quantidade));
    ano.setValue(livro.ano);
  }

  @FXML
  public void initialize() {
    if (alterarLivroId > 0) {
      this.preencherCampos(alterarLivroId);
      salvarLivroBotao.setOnAction(event -> {
        try {
          this.alterarLivro();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } else {
      salvarLivroBotao.setOnAction(event -> {
        try {
          this.criarLivro();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
  }
}
