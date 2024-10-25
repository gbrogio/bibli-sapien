package com.application.Database;

import java.util.ArrayList;
import com.application.interfaces.AbstratoEmprestimo;
import com.application.interfaces.Livro;
import com.application.interfaces.Usuario;

public class Database {
  public int idEmprestimo = 1;

  public ArrayList<AbstratoEmprestimo> emprestimos = new ArrayList<AbstratoEmprestimo>();
  public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
  public ArrayList<Livro> livros = new ArrayList<Livro>();

  private static Database instance;

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }
}
