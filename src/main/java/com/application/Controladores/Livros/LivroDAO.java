package com.application.Controladores.Livros;

import java.util.Date;

import com.application.Database.Database;
import com.application.Modelos.LivroAbstrato;

public class LivroDAO extends LivroAbstrato {
  Database db = Database.pegarInstancia();

  public LivroDAO(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    this.id = db.idLivros;
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.quantidade = quantidade;
    this.ano = ano;
  }

  public void adicionarLivro(String titulo, String autor, String genero, int quantidade, Date ano){
    db.livros.add(this);
    db.idLivros++;}
  
  public void exibirLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano){
    db.livros.get(livroId);
  }
  
  public void alterarLivro(int livroId){
  
  }
  
  public void removerLivro(int livroId){
    db.livros.remove(this);
  }
}
