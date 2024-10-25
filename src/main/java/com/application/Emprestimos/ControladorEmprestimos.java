package com.application.Emprestimos;


import java.util.ArrayList;
import java.util.Date;

import com.application.Database.Database;
import com.application.interfaces.AbstratoEmprestimo;

class Emprestimo extends AbstratoEmprestimo {
  Database db = Database.getInstance();

  Emprestimo(int usuarioId, int livroId) {
    this.usuario = usuarioId;
    this.livro = livroId;
    this.id = db.idEmprestimo;
  }

  Emprestimo (int usuarioId, int livroId, Date dataEmprestimo, Date dataDevolucao) {
    this.usuario = usuarioId;
    this.livro = livroId;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.id = db.idEmprestimo;
  }

  public void emprestarLivro() {
    db.emprestimos.add(this);
    db.idEmprestimo++;
  }
}

public class ControladorEmprestimos {
  Database db = Database.getInstance();

  public void emprestarLivro(int usuarioId, int livroId) {
    Emprestimo emprestimo = new Emprestimo(usuarioId, livroId);
    emprestimo.emprestarLivro();
  }

  public void emprestarLivro(int usuarioId, int livroId, Date dataEmprestimo, Date dataDevolucao) {
    Emprestimo emprestimo = new Emprestimo(usuarioId, livroId, dataEmprestimo, dataDevolucao);
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

  public AbstratoEmprestimo acharEmprestimo(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).id == emprestimoId) {
        return db.emprestimos.get(i);
      }
    }
    return null;
  }

  public ArrayList<AbstratoEmprestimo> acharEprestimosPorUsuario(int usuarioId) {
    ArrayList<AbstratoEmprestimo> emprestimos = new ArrayList<AbstratoEmprestimo>();
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).usuario == usuarioId) {
        emprestimos.add(db.emprestimos.get(i));
      }
    }
    return emprestimos;
  }
}
