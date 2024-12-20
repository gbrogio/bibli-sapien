package com.application.Controladores.Livros;

import com.application.ControladorTela;
import com.application.Modelos.LivroAbstrato;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorLivros extends ControladorTela {
  public void adicionarLivro(String titulo, String autor, String genero,
                             int quantidade, LocalDate ano) {
    LivrosDAO cliente = new LivrosDAO(titulo, autor, genero, quantidade, ano);
    cliente.adicionarLivro();
  }

  public static LivroAbstrato pegarLivro(int livroId) {
    return LivrosDAO.pegarLivro(livroId);
  }

  public ArrayList<LivroAbstrato> pegarTodosLivros() {
    return LivrosDAO.pegarTodosLivros();
  }

  public ArrayList<LivroAbstrato> pegarTodosLivros(String nome) {
    return LivrosDAO.pegarTodosLivros(nome);
  }

  public void alterarLivro(int id, String titulo, String autor, String genero,
                           int quantidade, LocalDate ano) {
    LivrosDAO cliente = new LivrosDAO(titulo, autor, genero, quantidade, ano);
    cliente.alterarLivro(id);
  }

  public void removerLivro(int livroId) { LivrosDAO.removerLivro(livroId); }
}
