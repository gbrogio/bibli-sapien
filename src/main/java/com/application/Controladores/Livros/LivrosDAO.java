package com.application.Controladores.Livros;

import java.time.LocalDate;
import java.util.ArrayList;
import com.application.Database.Database;
import com.application.Modelos.LivroAbstrato;

public class LivrosDAO extends LivroAbstrato {
  public static Database db = Database.pegarInstancia();

  public LivrosDAO(String titulo, String autor, String genero, int quantidade, LocalDate ano) {
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.quantidade = quantidade;
    this.ano = ano;
  }

  public void adicionarLivro() {
    this.id = db.idLivros;
    db.livros.add(this);
    db.idLivros++;
  }

  static void removerLivro(int idLivro) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).id == idLivro) {
        db.livros.remove(i);
        break;
      }
    }
  }

  static LivroAbstrato pegarLivro(int idLivro) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).id == idLivro) {
        return db.livros.get(i);
      }
    }
    return null;
  }

  public void alterarLivro(int clienteId) {
    for (int i = 0; i < db.livros.size(); i++) {
      if (db.livros.get(i).id == clienteId) {
        this.id = db.clientes.get(i).id;
        db.livros.set(i, this);
      }
    }
  }

  static ArrayList<LivroAbstrato> pegarTodosLivros() {
    return db.livros;
  }
}
