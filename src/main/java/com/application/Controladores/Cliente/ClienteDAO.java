package com.application.Controladores.Cliente;

import com.application.Database.Database;
import com.application.Modelos.ClienteAbstrato;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO extends ClienteAbstrato {
  public static Database db = Database.pegarInstancia();

  public ClienteDAO(String nome, String email, LocalDate dataNascimento,
                    String endereco, String telefone) {
    this.setNome(nome);
    this.setEmail(email);
    this.setDataNascimento(dataNascimento);
    this.setEndereco(endereco);
    this.setTelefone(telefone);
  }

  public void adicionarCliente() {
    this.setId(db.idCliente);
    db.clientes.add(this);
    db.idCliente++;
  }

  static void removerCliente(int idCliente) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).getId() == idCliente) {
        db.clientes.remove(i);
        db.emprestimos.removeIf(emprestimo -> emprestimo.getClienteId() == idCliente);
        break;
      }
    }
  }

  static ClienteAbstrato pegarCliente(int idCliente) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).getId() == idCliente) {
        return db.clientes.get(i);
      }
    }
    return null;
  }

  public void alterarCliente(int clienteId) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).getId() == clienteId) {
        this.setId(db.clientes.get(i).getId());
        db.clientes.set(i, this);
      }
    }
  }

  static ArrayList<ClienteAbstrato> pegarTodosClientes() { return db.clientes; }

  static ArrayList<ClienteAbstrato> pegarTodosClientes(String nome) {
    ArrayList<ClienteAbstrato> clientes = new ArrayList<ClienteAbstrato>();
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).getNome().toLowerCase().contains(
              nome.toLowerCase())) {
        clientes.add(db.clientes.get(i));
      }
    }
    return clientes;
  }
}
