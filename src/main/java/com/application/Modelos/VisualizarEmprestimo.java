package com.application.Modelos;

import java.time.LocalDate;

public class VisualizarEmprestimo {
  private int id;
  private String tituloLivro;
  private String nomeCliente;
  private LocalDate dataEmprestimo;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public LocalDate getDataEmprestimo() { return dataEmprestimo; }

  public void setDataEmprestimo(LocalDate dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public String getTituloLivro() { return tituloLivro; }

  public void setTituloLivro(String tituloLivro) {
    this.tituloLivro = tituloLivro;
  }

  public String getNomeCliente() { return nomeCliente; }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }
}
