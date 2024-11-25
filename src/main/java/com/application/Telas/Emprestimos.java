package com.application.Telas;

import com.application.Controladores.Emprestimos.ControladorEmprestimos;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
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
    Timer timer = new Timer();
    salvarEmprestimoBotao.setText("SALVANDO...");
    salvarEmprestimoBotao.setDisable(true);
    desabilitarCampos(true);

    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        Platform.runLater(() -> {
          salvarEmprestimoBotao.setText("SALVAR");
          salvarEmprestimoBotao.setDisable(false);
          desabilitarCampos(false);
          limparCampos();
        });
        timer.cancel();
      }
    }, 2000);
  }
}
