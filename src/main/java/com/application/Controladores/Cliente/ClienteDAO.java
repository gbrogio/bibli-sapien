package com.application.Controladores.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

import com.application.Database.Database;
import com.application.Modelos.ClienteAbstrato;

public class ClienteDAO extends ClienteAbstrato {
  public static Database db = Database.pegarInstancia();

  public ClienteDAO(String nome, String email, LocalDate dataNascimento, String endereco, String telefone) {
    this.nome = nome;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.telefone = telefone;
  }

  public void adicionarCliente() {
    this.id = db.idCliente;
    db.clientes.add(this);
    db.idCliente++;
  }

  static void removerCliente(int idCliente) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).id == idCliente) {
        db.clientes.remove(i);
        break;
      }
    }
  }

  static ClienteAbstrato pegarCliente(int idCliente) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).id == idCliente) {
        return db.clientes.get(i);
      }
    }
    return null;
  }

  public void alterarCliente(int clienteId) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).id == clienteId) {
        this.id = db.clientes.get(i).id;
        db.clientes.set(i, this);
      }
    }
  }

  static ArrayList<ClienteAbstrato> pegarTodosClientes() {
    return db.clientes;
  }
}
