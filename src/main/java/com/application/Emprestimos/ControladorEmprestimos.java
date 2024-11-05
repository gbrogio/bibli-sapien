package com.application.Emprestimos;


import java.util.ArrayList;
import java.util.Date;

import com.application.ControladorTela;
import com.application.Database.Database;
import com.application.interfaces.EmprestimoAbstrato;

class Emprestimo extends EmprestimoAbstrato {
  Database db = Database.pegarInstancia();

  Emprestimo(int clienteId, int livroId) {
    this.clienteId = clienteId;
    this.livroId = livroId;
    this.id = db.idEmprestimo;
  }

  Emprestimo (int clienteId, int livroId, Date dataDevolucao) {
    this.clienteId = clienteId;
    this.livroId = livroId;
    this.dataDevolucao = dataDevolucao;
    this.id = db.idEmprestimo;
  }

  public void emprestarLivro() {
    db.emprestimos.add(this);
    db.idEmprestimo++;
  }
}

public class ControladorEmprestimos extends ControladorTela {
  Database db = Database.pegarInstancia();

  public void emprestarLivro(int clienteId, int livroId) {
    Emprestimo emprestimo = new Emprestimo(clienteId, livroId);
    emprestimo.emprestarLivro();
  }

  public void emprestarLivro(int clienteId, int livroId, Date dataDevolucao) {
    Emprestimo emprestimo = new Emprestimo(clienteId, livroId, dataDevolucao);
    emprestimo.emprestarLivro();
  }

  public void devolverLivro(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).id == emprestimoId) {
        db.emprestimos.remove(i);
        break;
      }
    }
  }

  public EmprestimoAbstrato acharEmprestimo(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).id == emprestimoId) {
        return db.emprestimos.get(i);
      }
    }
    return null;
  }

  public ArrayList<EmprestimoAbstrato> acharEprestimosPorCliente(int clienteId) {
    ArrayList<EmprestimoAbstrato> emprestimos = new ArrayList<EmprestimoAbstrato>();
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).clienteId == clienteId) {
        emprestimos.add(db.emprestimos.get(i));
      }
    }
    return emprestimos;
  }
}
