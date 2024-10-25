package com.application.interfaces;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public abstract class AbstratoEmprestimo {
  public int id;
  public int livro;
  public int usuario;
  public Date dataEmprestimo = new Date();
  public Date dataDevolucao = Date.from(LocalDate.now().plusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
}
