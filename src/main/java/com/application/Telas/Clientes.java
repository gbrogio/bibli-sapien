package com.application.Telas;

import com.application.Controladores.Cliente.ControladorCliente;
import com.application.Modelos.ClienteAbstrato;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Clientes extends ControladorCliente {
  @FXML private FlowPane clientsView;

  @FXML
  public void irParaClientes() throws IOException {
    this.irPara("clientes");
  }

  @FXML
  public void irParaCriarCliente() throws IOException {
    this.irPara("criar-cliente");
    Cliente.alterarClienteId = 0;
  }

  @FXML
  private void pesquisar(javafx.scene.input.KeyEvent event) throws IOException {
    String nome = ((javafx.scene.control.TextField)event.getSource()).getText();
    ArrayList<ClienteAbstrato> clientes = pegarTodosClientes(nome);
    clientsView.getChildren().clear();
    for (ClienteAbstrato cliente : clientes) {
      carregarCliente(cliente);
    }
  }

  private void carregarCliente(ClienteAbstrato cliente) throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/com/application/cliente-item.fxml"));
    VBox clienteBox = loader.load();
    ClienteItem controller = loader.getController();

    controller.setCliente(cliente);
    clientsView.getChildren().add(clienteBox);
  }

  private void carregarClientes() throws IOException {
    ArrayList<ClienteAbstrato> clientes = pegarTodosClientes();
    clientsView.getChildren().clear();
    for (ClienteAbstrato cliente : clientes) {
      carregarCliente(cliente);
    }
  }

  @FXML
  public void initialize() throws IOException {
    carregarClientes();
  }
}
