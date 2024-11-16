package com.application.Modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class EmprestimoAbstrato {
  public int id;
  public int livroId;
  public int clienteId;
  public Date dataEmprestimo = new Date();
  public Date dataDevolucao =
      Date.from(LocalDate.now()
                    .plusMonths(1)
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant());
}
