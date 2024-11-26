package com.application.Modelos;

import java.time.LocalDate;

public abstract class LivroAbstrato {
  private int id;
  private String titulo;
  private String autor;
  private String genero;
  private LocalDate ano;
  private int quantidade;
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getTitulo() { return titulo; }

  public void setTitulo(String titulo) { this.titulo = titulo; }

  public String getAutor() { return autor; }

  public void setAutor(String autor) { this.autor = autor; }

  public String getGenero() { return genero; }

  public void setGenero(String genero) { this.genero = genero; }

  public LocalDate getAno() { return ano; }

  public void setAno(LocalDate ano) { this.ano = ano; }

  public int getQuantidade() { return quantidade; }

  public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
