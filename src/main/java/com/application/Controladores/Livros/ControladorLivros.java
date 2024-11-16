package com.application.Controladores.Livros;

import java.time.LocalDate;
import java.util.ArrayList;
import com.application.ControladorTela;
import com.application.Modelos.LivroAbstrato;

public class ControladorLivros extends ControladorTela {
public void adicionarLivro(String titulo, String autor, String genero, int quantidade, LocalDate ano) {
    LivrosDAO cliente = new LivrosDAO(titulo, autor, genero, quantidade, ano);
    cliente.adicionarLivro();
  }

  public LivroAbstrato pegarLivro(int clienteId) {
    return LivrosDAO.pegarLivro(clienteId);
  }

  public ArrayList<LivroAbstrato> pegarTodosLivros() {
    return LivrosDAO.pegarTodosLivros();
  }

  public void alterarLivro(int id, String titulo, String autor, String genero, int quantidade, LocalDate ano) {
    LivrosDAO cliente = new LivrosDAO(titulo, autor, genero, quantidade, ano);
    cliente.alterarLivro(id);
  }

  public void removerLivro(int clienteId) {
    LivrosDAO.removerLivro(clienteId);
  }
}
