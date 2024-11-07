package com.application.Controladores.Livros;

import java.util.Date;
import com.application.Database.Database;
import com.application.ControladorTela;

public class ControladorLivros extends ControladorTela {
    Database db = Database.pegarInstancia();
    
  public void adicionarLivro(String titulo, String autor, String genero, int quantidade, Date ano) {
    LivroDAO livro = new LivroDAO(titulo, autor, genero, quantidade, ano);
    livro.adicionarLivro();
  }

  public void exibirLivro(int livroId, String titulo, String autor, String genero, int quantidade, Date ano){
      db.livros.get(livroId);
  }
  
  public void alterarLivro(int livroId){
      
  }
  
  public void removerLivro(int livroId) {
      for(int c=0; c<db.livros.size(); c++){
          if(db.livros.get(c).id == livroId){
              db.livros.remove(c);
              break;
          }
      }
  }
}