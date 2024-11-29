package com.application.Controladores.Livros;

import com.application.Database.Database;
import com.application.Modelos.LivroAbstrato;
import java.time.LocalDate;
import java.util.ArrayList;

public class LivrosDAO extends LivroAbstrato {
  public static Database db = Database.pegarInstancia();

  public LivrosDAO(String titulo, String autor, String genero, int quantidade,
                   LocalDate ano) {
    this.setTitulo(titulo);
    this.setAutor(autor);
    this.setGenero(genero);
    this.setQuantidade(quantidade);
    this.setAno(ano);
  }

  public void adicionarLivro() {
    this.setId(db.idLivros);
    db.livros.add(this);
    db.idLivros++;
  }

  static void removerLivro(int idLivro) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).getId() == idLivro) {
        db.livros.remove(i);
        db.emprestimos.removeIf(emprestimo -> emprestimo.getLivroId() == idLivro);
        break;
      }
    }
  }

  static LivroAbstrato pegarLivro(int idLivro) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).getId() == idLivro) {
        return db.livros.get(i);
      }
    }
    return null;
  }

  public void alterarLivro(int clienteId) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).getId() == clienteId) {
        this.setId(db.livros.get(i).getId());
        db.livros.set(i, this);
      }
    }
  }

  static ArrayList<LivroAbstrato> pegarTodosLivros() { return db.livros; }

  static ArrayList<LivroAbstrato> pegarTodosLivros(String nome) {
    ArrayList<LivroAbstrato> livros = new ArrayList<LivroAbstrato>();
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).getTitulo().toLowerCase().contains(
              nome.toLowerCase())) {
        livros.add(db.livros.get(i));
      }
    }
    return livros;
  }
}
