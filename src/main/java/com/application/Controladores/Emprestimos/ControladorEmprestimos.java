package com.application.Controladores.Emprestimos;

import com.application.ControladorTela;
import com.application.Modelos.VisualizarEmprestimo;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorEmprestimos extends ControladorTela {
  public boolean emprestarLivro(int clienteId, int livroId) {
    EmprestimoDAO emprestimo = new EmprestimoDAO(clienteId, livroId);
    return emprestimo.emprestarLivro();
  }
  public boolean emprestarLivro(int clienteId, int livroId,
                                LocalDate dataEmprestimo) {
    EmprestimoDAO emprestimo =
        new EmprestimoDAO(clienteId, livroId, dataEmprestimo);
    return emprestimo.emprestarLivro();
  }

  public Boolean devolverLivro(int livroId, int clienteId) {
    return EmprestimoDAO.devolverLivro(livroId, clienteId);
  }

  public ArrayList<VisualizarEmprestimo> pegarTodosEmprestimos(String nome) {
    return EmprestimoDAO.pegarTodosEmprestimos(nome);
  }
  public ArrayList<VisualizarEmprestimo> pegarTodosEmprestimos() {
    return EmprestimoDAO.pegarTodosEmprestimos();
  }
}
