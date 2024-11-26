package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.ClienteAbstrato;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ClienteItem extends ControladorCliente {

  @FXML private HBox clienteBox;

  @FXML private Label nomeCliente;

  @FXML private Text idCliente;

  private ClienteAbstrato cliente;

  public void setCliente(ClienteAbstrato cliente) {
    this.cliente = cliente;
    nomeCliente.setText(cliente.getNome());
    idCliente.setText(String.valueOf(cliente.getId()));
  }

  @FXML
  private void removerCliente() throws IOException {
    this.removerCliente(cliente.getId());
    this.irPara("clientes");
  }

  @FXML
  private void editarCliente() {
    Cliente.alterarClienteId = cliente.getId();
    try {
      this.irPara("criar-cliente");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
