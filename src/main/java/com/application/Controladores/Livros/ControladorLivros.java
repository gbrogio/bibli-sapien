package com.application.Controladores.Livros;

import java.util.Date;

import com.application.ControladorTela;

public class ControladorLivros extends ControladorTela {
  public void adicionarLivro(String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroDAO livro = new LivroDAO(titulo, autor, genero, quantidade, ano);
    livro.adicionarLivro();
  }

  public void removerLivro(int livroId) {
  }
}