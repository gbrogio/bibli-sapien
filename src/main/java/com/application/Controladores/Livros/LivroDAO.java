package com.application.Controladores.Livros;

import java.util.Date;

import com.application.Database.Database;
import com.application.Modelos.LivroAbstrato;

public class LivroDAO extends LivroAbstrato {
  Database db = Database.pegarInstancia();

  public LivroDAO(String titulo, String autor, String genero, int quantidade, Date ano) {
    this.id = db.idLivros;
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.quantidade = quantidade;
    this.ano = ano;
  }

  public void adicionarLivro() {
    db.livros.add(this);
    db.idLivros++;
  }
}
