package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.ClienteAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ClienteItem extends ControladorCliente {

  @FXML private HBox clienteBox;

  @FXML private Text nomeCliente;

  @FXML private Text idCliente;

  private ClienteAbstrato cliente;

  public void setCliente(ClienteAbstrato cliente) {
    this.cliente = cliente;
    nomeCliente.setText(cliente.nome);
    idCliente.setText(String.valueOf(cliente.id));
  }

  @FXML
  private void removerCliente() throws IOException {
    this.removerCliente(cliente.id);
    this.irPara("clientes");
  }

  @FXML
  private void editarCliente() {
    Cliente.alterarClienteId = cliente.id;
    try {
      this.irPara("criar-cliente");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
