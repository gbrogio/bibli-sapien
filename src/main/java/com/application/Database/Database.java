package com.application.Database;

import java.util.ArrayList;

import com.application.interfaces.Emprestimo;

public class Database {
  public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

  private static Database instance;

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    return instance;
  }
}
