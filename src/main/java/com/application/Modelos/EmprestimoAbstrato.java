package com.application.Modelos;

import java.time.LocalDate;

public abstract class EmprestimoAbstrato {
  private int id;
  private int livroId;
  private int clienteId;
  private LocalDate dataEmprestimo = LocalDate.now();
  // private Date dataDevolucao =
  //     Date.from(LocalDate.now()
  //                   .plusMonths(1)
  //                   .atStartOfDay(ZoneId.systemDefault())
  //                   .toInstant());
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getLivroId() { return livroId; }

  public void setLivroId(int livroId) { this.livroId = livroId; }

  public int getClienteId() { return clienteId; }

  public void setClienteId(int clienteId) { this.clienteId = clienteId; }

  public LocalDate getDataEmprestimo() { return dataEmprestimo; }

  public void setDataEmprestimo(LocalDate dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  // public Date getDataDevolucao() {
  //   return dataDevolucao;
  // }

  // public void setDataDevolucao(Date dataDevolucao) {
  //   this.dataDevolucao = dataDevolucao;
  // }
}
