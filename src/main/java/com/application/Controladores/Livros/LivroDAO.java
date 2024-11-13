package com.application.Controladores.Livros;

import java.util.Date;

import com.application.Database.Database;
import com.application.Modelos.LivroAbstrato;

public class LivroDAO extends LivroAbstrato {
  public static Database db = Database.pegarInstancia();

  public LivroDAO(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    this.id = db.idLivros;
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.quantidade = quantidade;
    this.ano = ano;
  }

  public void adicionarLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    db.livros.add(this);
    db.idLivros++;
  }

  public static void exibirLivro(int livroId) {
    db.livros.get(livroId);
  }

  public void alterarLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroAbstrato livro = db.livros.get(livroId);
    livro.titulo = titulo;
    livro.autor = autor;
    livro.genero = genero;
    livro.quantidade = 0;
    livro.ano = ano;
    db.livros.add(this);
  }

  public static void removerLivro(int livroId) {
    for (int c = 0; c< db.livros.size();c++){
        if (db.livros.get(c).id == livroId){
            db.livros.remove(c);
            break;
            }
        }
    }
}
