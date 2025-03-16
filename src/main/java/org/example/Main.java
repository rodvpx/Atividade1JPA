package org.example;

import org.example.dao.LivroDAO;
import org.example.model.Autor;
import org.example.model.Editora;
import org.example.model.Livro;


public class Main {
    public static void main(String[] args) {
        // Criar instâncias de Autor e Editora
        Autor autor1 = new Autor("Autor 1");
        Autor autor2 = new Autor("Autor 2");

        Editora editora1 = new Editora("Editora 1");
        Editora editora2 = new Editora("Editora 2");

        // Criar um livro e associar autores e editoras
        Livro livro = new Livro("Java for Beginners", 2022, "978-3-16-148410-0", autor1, editora2);

        // Criar o DAO para salvar o livro
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.salvar(livro);

        // Buscar o livro pelo ID (depois de salvar, o livro terá um ID gerado)
        Livro livroBuscado = livroDAO.buscarPorId(livro.getId());
        System.out.println("Livro encontrado: " + livroBuscado.getTitulo());
    }
}

