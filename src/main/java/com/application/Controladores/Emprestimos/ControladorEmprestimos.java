package com.application.Controladores.Emprestimos;

import java.util.ArrayList;
import java.util.Date;

import com.application.ControladorTela;
import com.application.Modelos.EmprestimoAbstrato;

public class ControladorEmprestimos extends ControladorTela {
  public void emprestarLivro(int clienteId, int livroId) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId);
    emprestimo.emprestarLivro();
  }

  public void emprestarLivro(int clienteId, int livroId, Date dataDevolucao) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId, dataDevolucao);
    emprestimo.emprestarLivro();
  }

  public void devolverLivro(int emprestimoId) {
    EmprestimoDAO.devolverLivro(emprestimoId);
  }

  public EmprestimoAbstrato pegarEmprestimo(int emprestimoId) {
    return EmprestimoDAO.pegarEmprestimo(emprestimoId);
  }

  public ArrayList<EmprestimoAbstrato> pegarTodosEmprestimos() {
    return EmprestimoDAO.pegarTodosEmprestimos();
  }

  public ArrayList<EmprestimoAbstrato> pegarEprestimosPorCliente(int clienteId) {
    return EmprestimoDAO.pegarEprestimosPorCliente(clienteId);
  }
}
