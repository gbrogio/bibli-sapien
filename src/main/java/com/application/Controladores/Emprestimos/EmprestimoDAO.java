package com.application.Controladores.Emprestimos;

import com.application.Database.Database;
import com.application.Modelos.ClienteAbstrato;
import com.application.Modelos.EmprestimoAbstrato;
import com.application.Modelos.LivroAbstrato;
import com.application.Modelos.VisualizarEmprestimo;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoDAO extends EmprestimoAbstrato {
  public static Database db = Database.pegarInstancia();

  public EmprestimoDAO(int clienteId, int livroId) {
    this.setClienteId(clienteId);
    this.setLivroId(livroId);
    this.setId(db.idEmprestimo);
  }

  public EmprestimoDAO(int clienteId, int livroId, LocalDate dataEmprestimo) {
    this.setClienteId(clienteId);
    this.setLivroId(livroId);
    this.setDataEmprestimo(dataEmprestimo);
    this.setId(db.idEmprestimo);
  }

  public boolean emprestarLivro() {
    boolean clienteEncontrado = false;
    for (ClienteAbstrato client : db.clientes) {
      if (client.getId() == this.getClienteId()) {
        clienteEncontrado = true;
        break;
      }
    }
    if (!clienteEncontrado)
      return false;

    boolean livroEncontrado = false;
    for (LivroAbstrato livro : db.livros) {
      if (livro.getId() == this.getLivroId()) {
        livroEncontrado = true;
        break;
      }
    }
    if (!livroEncontrado)
      return false;

    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).getLivroId() == this.getLivroId() &&
          db.emprestimos.get(i).getClienteId() == this.getClienteId()) {
        return false;
      }
    }

    db.emprestimos.add(this);
    db.idEmprestimo++;

    return true;
  }

  static Boolean devolverLivro(int livroId, int clienteId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).getLivroId() == livroId &&
          db.emprestimos.get(i).getClienteId() == clienteId) {
        db.emprestimos.remove(i);
        return true;
      }
    }

    return false;
  }

  static EmprestimoAbstrato pegarEmprestimo(int emprestimoId) {
    for (int i = 0; i < db.emprestimos.size(); i++) {
      if (db.emprestimos.get(i).getId() == emprestimoId) {
        return db.emprestimos.get(i);
      }
    }
    return null;
  }

  static ArrayList<VisualizarEmprestimo> pegarTodosEmprestimos(String nome) {
    ArrayList<VisualizarEmprestimo> emprestimos =
        new ArrayList<VisualizarEmprestimo>();
    for (int i = 0; i < db.emprestimos.size(); i++) {
      int clienteId = db.emprestimos.get(i).getClienteId();
      int livroId = db.emprestimos.get(i).getLivroId();
      ClienteAbstrato clienteAtual = null;
      LivroAbstrato livroAtual = null;

      for (ClienteAbstrato cliente : db.clientes) {
        if (cliente.getId() == clienteId) {
          clienteAtual = cliente;
          break;
        }
      }

      for (LivroAbstrato livro : db.livros) {
        if (livro.getId() == livroId) {
          livroAtual = livro;
          break;
        }
      }

      if (clienteAtual == null || livroAtual == null) {
        continue;
      }

      if (clienteAtual.getNome().toLowerCase().contains(nome.toLowerCase()) ||
          livroAtual.getTitulo().toLowerCase().contains(nome.toLowerCase())) {
        VisualizarEmprestimo emprestimo = new VisualizarEmprestimo();
        emprestimo.setId(db.emprestimos.get(i).getId());
        emprestimo.setNomeCliente(clienteAtual.getNome());
        emprestimo.setTituloLivro(livroAtual.getTitulo());
        emprestimo.setDataEmprestimo(db.emprestimos.get(i).getDataEmprestimo());
        emprestimos.add(emprestimo);
      }
    }
    return emprestimos;
  }

  static ArrayList<VisualizarEmprestimo> pegarTodosEmprestimos() {
    ArrayList<VisualizarEmprestimo> emprestimos =
        new ArrayList<VisualizarEmprestimo>();
    for (int i = 0; i < db.emprestimos.size(); i++) {
      int clienteId = db.emprestimos.get(i).getClienteId();
      int livroId = db.emprestimos.get(i).getLivroId();
      ClienteAbstrato clienteAtual = null;
      LivroAbstrato livroAtual = null;

      for (ClienteAbstrato cliente : db.clientes) {
        if (cliente.getId() == clienteId) {
          clienteAtual = cliente;
          break;
        }
      }

      for (LivroAbstrato livro : db.livros) {
        if (livro.getId() == livroId) {
          livroAtual = livro;
          break;
        }
      }

      if (clienteAtual == null || livroAtual == null) {
        continue;
      }

      VisualizarEmprestimo emprestimo = new VisualizarEmprestimo();
      emprestimo.setId(db.emprestimos.get(i).getId());
      emprestimo.setNomeCliente(clienteAtual.getNome());
      emprestimo.setTituloLivro(livroAtual.getTitulo());
      emprestimo.setDataEmprestimo(db.emprestimos.get(i).getDataEmprestimo());
      emprestimos.add(emprestimo);
    }
    return emprestimos;
  }
}