package com.application.screens;

import java.io.IOException;

import com.application.Livros.ControladorLivros;
import com.application.Database.Database;
import javafx.fxml.FXML;

public class Livros extends ControladorLivros {
    Database db = Database.getInstance();

    @FXML  
    public void irParaLivros() throws IOException {
        this.irPara("livros");
    }

    @FXML  
    public void irParaCriarLivro() throws IOException {
        this.irPara("criar-livro");
    }

    @FXML
    public void criarLivro() throws IOException {
    }
}

