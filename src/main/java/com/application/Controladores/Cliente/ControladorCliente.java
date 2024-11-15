package com.application.Controladores.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import com.application.ControladorTela;
import com.application.Modelos.ClienteAbstrato;

public class ControladorCliente extends ControladorTela {
  public void adicionarCliente(String nome, String email, LocalDate dataNascimento, String endereco, String telefone) {
    ClienteDAO cliente = new ClienteDAO(nome, email, dataNascimento, endereco, telefone);
    cliente.adicionarCliente();
  }

  public ClienteAbstrato pegarCliente(int clienteId) {
    return ClienteDAO.pegarCliente(clienteId);
  }

  public ArrayList<ClienteAbstrato> pegarTodosClientes() {
    return ClienteDAO.pegarTodosClientes();
  }

  public void alterarCliente(int id, String nome, String email, LocalDate dataNascimento, String endereco, String telefone) {
    ClienteDAO cliente = new ClienteDAO(nome, email, dataNascimento, endereco, telefone);
    cliente.alterarCliente(id);
  }

  public void removerCliente(int clienteId) {
    ClienteDAO.removerCliente(clienteId);
  }
}