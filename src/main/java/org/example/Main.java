package org.example;

import org.example.dao.AutorDAO;
import org.example.dao.EditoraDAO;
import org.example.dao.LivroDAO;
import org.example.model.Autor;
import org.example.model.Editora;
import org.example.model.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Autor autor1 = new Autor("George R. R. Martin");
        Autor autor2 = new Autor("Cleiton Rasta");

        Editora editora1 = new Editora("Bantam Books");
        Editora editora2 = new Editora("Casa do Código");

        // Criar os DAOs
        AutorDAO autorDAO = new AutorDAO();
        EditoraDAO editoraDAO = new EditoraDAO();
        LivroDAO livroDAO = new LivroDAO();

        // Salvar autores e editoras
        autorDAO.salvar(autor1);
        autorDAO.salvar(autor2);
        editoraDAO.salvar(editora1);
        editoraDAO.salvar(editora2);

        // Criar livros e associar autores e editoras
        Livro livro1 = new Livro("A Guerra dos Tronos : As Crônicas de Gelo e Fogo, volume 1", 2019, "978-0-553-10354-0", autor1, editora1);
        livroDAO.salvar(livro1);

        Livro livro2 = new Livro("Spring Boot - API", 2022, "978-3-16-148410-1", autor2, editora2);
        livroDAO.salvar(livro2);

        Livro livro3 = new Livro("A Ascensão do Dragão: Uma história ilustrada da dinastia Targaryen – Volume 1", 2024, "978-3-16-148410-2", autor1, editora2);
        livroDAO.salvar(livro3);

        int opcao;
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1 - Listar Autores");
            System.out.println("2 - Listar Editoras");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Livros por Autor");
            System.out.println("5 - Livros por Editora");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n========= AUTORES =========");
                    System.out.println("ID: " + autor1.getId() + " | Nome: " + autor1.getNome());
                    System.out.println("ID: " + autor2.getId() + " | Nome: " + autor2.getNome());
                    break;
                case 2:
                    System.out.println("\n========= EDITORAS =========");
                    System.out.println("ID: " + editora1.getId() + " | Nome: " + editora1.getNome());
                    System.out.println("ID: " + editora2.getId() + " | Nome: " + editora2.getNome());
                    break;
                case 3:
                    System.out.println("\n========= LIVROS =========");
                    System.out.println("ID: " + livro1.getId() + " | Título: " + livro1.getTitulo() + " | Autor: " + livro1.getAutor().getNome() + " | Editora: " + livro1.getEditora().getNome());
                    System.out.println("ID: " + livro2.getId() + " | Título: " + livro2.getTitulo() + " | Autor: " + livro2.getAutor().getNome() + " | Editora: " + livro2.getEditora().getNome());
                    System.out.println("ID: " + livro3.getId() + " | Título: " + livro3.getTitulo() + " | Autor: " + livro3.getAutor().getNome() + " | Editora: " + livro3.getEditora().getNome());
                    break;
                case 4:
                    System.out.println("\n========= LIVROS POR AUTOR =========");
                    System.out.println("Livros do " + autor1.getNome() + ":");
                    autorDAO.buscarLivrosPorAutor(autor1.getId()).forEach(l -> System.out.println("- " + l.getTitulo()));
                    System.out.println("\nLivros do " + autor2.getNome() + ":");
                    autorDAO.buscarLivrosPorAutor(autor2.getId()).forEach(l -> System.out.println("- " + l.getTitulo()));
                    break;
                case 5:
                    System.out.println("\n========= LIVROS POR EDITORA =========");
                    System.out.println("Livros da " + editora1.getNome() + ":");
                    editoraDAO.buscarLivrosPorEditora(editora1.getId()).forEach(l -> System.out.println("- " + l.getTitulo()));
                    System.out.println("\nLivros da " + editora2.getNome() + ":");
                    editoraDAO.buscarLivrosPorEditora(editora2.getId()).forEach(l -> System.out.println("- " + l.getTitulo()));
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}


