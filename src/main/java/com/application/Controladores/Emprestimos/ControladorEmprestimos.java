package com.application.Controladores.Emprestimos;

import java.util.ArrayList;
import java.util.Date;

import com.application.ControladorTela;
import com.application.Database.Database;
import com.application.Modelos.EmprestimoAbstrato;

public class ControladorEmprestimos extends ControladorTela {
  Database db = Database.pegarInstancia();

  public void emprestarLivro(int clienteId, int livroId) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId);
    emprestimo.emprestarLivro();
  }

  public void emprestarLivro(int clienteId, int livroId, Date dataDevolucao) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId, dataDevolucao);
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
