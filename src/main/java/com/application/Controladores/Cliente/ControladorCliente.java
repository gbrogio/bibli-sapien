package com.application.Controladores.Cliente;

import java.util.Date;
import com.application.Database.Database;
import com.application.ControladorTela;
import com.application.Modelos.ClienteAbstrato;

public class ControladorCliente extends ControladorTela {
    Database db = Database.pegarInstancia();
    private ClienteAbstrato ClienteAbstrato;
    
    public void adicionarCliente(String nome, String email, Date dataNascimento, String endereco, String telefone) {
      ClienteDAO cliente = new ClienteDAO(nome, email, dataNascimento, endereco, telefone);
      cliente.adicionarCliente();
    }

    public void exibirCliente(int clienteId, String titulo, String autor, String genero, int quantidade, Date ano){
        db.clientes.get(clienteId);
    }
  
    public void alterarCliente(int clienteId) {
    for (int i = 0; i < db.clientes.size(); i++) {
      if (db.clientes.get(i).id == clienteId) {
        db.clientes.set(i, ClienteAbstrato);
      }
    }
  }  
  
    public void removerCliente(int clienteId) {
        for (int i = 0; i < db.clientes.size(); i++) {
          if (db.clientes.get(i).id == clienteId) {
            db.clientes.remove(i);
            break;
          }
        }
      }
  
}