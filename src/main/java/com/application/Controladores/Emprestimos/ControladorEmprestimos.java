package com.application.Controladores.Emprestimos;

import com.application.ControladorTela;
import com.application.Modelos.EmprestimoAbstrato;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorEmprestimos extends ControladorTela {
  public void emprestarLivro(int clienteId, int livroId) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId);
    emprestimo.emprestarLivro();
  }
  public void emprestarLivro(int clienteId, int livroId, LocalDate dataEmprestimo) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId, dataEmprestimo);
    emprestimo.emprestarLivro();
  }  

  public void devolverLivro(int livroId, int clienteId) {
    EmprestimoDAO.devolverLivro(livroId, clienteId);
  }

  public EmprestimoAbstrato pegarEmprestimo(int emprestimoId) {
    return EmprestimoDAO.pegarEmprestimo(emprestimoId);
  }

  public ArrayList<EmprestimoAbstrato> pegarTodosEmprestimos() {
    return EmprestimoDAO.pegarTodosEmprestimos();
  }

  public ArrayList<EmprestimoAbstrato>
  pegarEprestimosPorCliente(int clienteId) {
    return EmprestimoDAO.pegarEprestimosPorCliente(clienteId);
  }
}
