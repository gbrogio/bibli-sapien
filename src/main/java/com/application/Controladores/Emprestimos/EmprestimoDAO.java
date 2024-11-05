package com.application.Controladores.Emprestimos;

import java.util.Date;

import com.application.Database.Database;
import com.application.Modelos.EmprestimoAbstrato;

public class EmprestimoDAO extends EmprestimoAbstrato {
  Database db = Database.pegarInstancia();

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
}