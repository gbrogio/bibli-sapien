package com.application.Controladores.Emprestimos;

import com.application.Database.Database;
import com.application.Modelos.EmprestimoAbstrato;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoDAO extends EmprestimoAbstrato {
  public static Database db = Database.pegarInstancia();

  public EmprestimoDAO(int clienteId, int livroId) {
    this.clienteId = clienteId;
    this.livroId = livroId;
    this.id = db.idEmprestimo;
  }

  public EmprestimoDAO(int clienteId, int livroId, Date dataDevolucao) {
    this.clienteId = clienteId;
    this.livroId = livroId;
    this.dataDevolucao = dataDevolucao;
    this.id = db.idEmprestimo;
  }

  public void emprestarLivro() {
    db.emprestimos.add(this);
    db.idEmprestimo++;
  }

  static void devolverLivro(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).id == emprestimoId) {
        db.emprestimos.remove(i);
        break;
      }
    }
  }

  static EmprestimoAbstrato pegarEmprestimo(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).id == emprestimoId) {
        return db.emprestimos.get(i);
      }
    }
    return null;
  }

  static ArrayList<EmprestimoAbstrato> pegarTodosEmprestimos() {
    return db.emprestimos;
  }

  static ArrayList<EmprestimoAbstrato>
  pegarEprestimosPorCliente(int clienteId) {
    ArrayList<EmprestimoAbstrato> emprestimos =
        new ArrayList<EmprestimoAbstrato>();
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).clienteId == clienteId) {
        emprestimos.add(db.emprestimos.get(i));
      }
    }
    return emprestimos;
  }
}