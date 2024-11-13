package com.application.Controladores.Livros;

import java.util.Date;
import com.application.Database.Database;
import com.application.ControladorTela;

public class ControladorLivros extends ControladorTela {
    public static Database db = Database.pegarInstancia();
    
  public void adicionarLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroDAO livro = new LivroDAO(livroId, titulo, autor, genero, quantidade, ano);
    livro.adicionarLivro(livroId,titulo, autor, genero, quantidade, ano);
  }

  public static void exibirLivro(int livroId){
    LivroDAO.exibirLivro(livroId);
  }
  
  public void alterarLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano){
    LivroDAO livro = new LivroDAO(livroId, titulo, autor, genero, quantidade, ano);
    livro.alterarLivro(livroId,titulo, autor, genero, quantidade, ano);
  }
  
  public static void removerLivro(int livroId) {
    LivroDAO.removerLivro(livroId);
    }
}
