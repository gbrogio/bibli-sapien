package com.application.Controladores.Livros;

import java.util.Date;
import com.application.Database.Database;
import com.application.ControladorTela;

public class ControladorLivros extends ControladorTela {
    Database db = Database.pegarInstancia();
    
  public void adicionarLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroDAO livro = new LivroDAO(livroId, titulo, autor, genero, quantidade, ano);
    livro.adicionarLivro(titulo, autor, genero, quantidade, ano);
  }

  public void exibirLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano){
    LivroDAO livro = new LivroDAO(livroId, titulo, autor, genero, quantidade, ano);
    livro.exibirLivro(livroId, titulo, autor, genero, quantidade, ano);
  }
  
  public void alterarLivro(int livroId){
      
  }
  
  public void removerLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroDAO livro = new LivroDAO(livroId, titulo, autor, genero, quantidade, ano);
    livro.removerLivro(livroId);
}
}
