package com.application.Database;

import java.util.ArrayList;

import com.application.Modelos.ClienteAbstrato;
import com.application.Modelos.EmprestimoAbstrato;
import com.application.Modelos.LivroAbstrato;

public class Database {
  public int idEmprestimo = 1;
  public int idCliente = 1;
  public int idLivros = 1;

  public ArrayList<EmprestimoAbstrato> emprestimos = new ArrayList<EmprestimoAbstrato>();
  public ArrayList<ClienteAbstrato> clientes = new ArrayList<ClienteAbstrato>();
  public ArrayList<LivroAbstrato> livros = new ArrayList<LivroAbstrato>();

  private static Database instance;

  public static Database pegarInstancia() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }
}
