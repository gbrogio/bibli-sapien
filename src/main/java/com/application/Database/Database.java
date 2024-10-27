package com.application.Database;

import java.util.ArrayList;
import com.application.interfaces.EmprestimoAbstrato;
import com.application.interfaces.LivroAbstrato;
import com.application.interfaces.ClienteAbstrato;

public class Database {
  public int idEmprestimo = 1;

  public ArrayList<EmprestimoAbstrato> emprestimos = new ArrayList<EmprestimoAbstrato>();
  public ArrayList<ClienteAbstrato> clientes = new ArrayList<ClienteAbstrato>();
  public ArrayList<LivroAbstrato> livros = new ArrayList<LivroAbstrato>();

  private static Database instance;

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }
}
