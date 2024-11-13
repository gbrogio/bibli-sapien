package com.application.Controladores.Cliente;

import java.util.ArrayList;
import java.util.Date;

import com.application.Database.Database;
import com.application.Modelos.ClienteAbstrato;

public class ClienteDAO extends ClienteAbstrato {
    Database db = Database.pegarInstancia();

    public ClienteDAO(String nome, String email, Date dataNascimento, String endereco, String telefone){
        this.id = db.idCliente;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void adicionarCliente() {
        db.clientes.add(this);
        db.idCliente++;
      }  

    public void removerCliente(int idCliente) {
        for (int i = 0; i < db.clientes.size(); i++) {
          if (db.clientes.get(i).id == idCliente) {
            db.clientes.remove(i);
            break;
          }
        }
      }

    public ClienteAbstrato pegarCliente(int idCliente) {
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
        db.clientes.set(i, this);
      }
    }
  }

  public ArrayList<ClienteAbstrato> pegarTodosClientes(){
    return db.clientes;
  }
}

