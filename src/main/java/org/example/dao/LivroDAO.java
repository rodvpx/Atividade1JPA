package org.example.dao;

import org.example.model.Livro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.util.HibernateUtil;

import java.util.UUID;

public class LivroDAO {

    public void salvar(Livro livro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            if (livro.getAutor() != null) {
                session.saveOrUpdate(livro.getAutor());
            }

            if (livro.getEditora() != null) {
                session.saveOrUpdate(livro.getEditora());
            }

            session.save(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e); // Lança uma exceção para tratamento mais alto
        } finally {
            session.close();
        }
    }

    public Livro buscarPorId(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Livro livro = null;

        try {
            transaction = session.beginTransaction();
            livro = session.get(Livro.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e); // Lança uma exceção para tratamento mais alto
        } finally {
            session.close();
        }

        return livro;
    }

    public void excluir(Livro livro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e); // Lança uma exceção para tratamento mais alto
        } finally {
            session.close();
        }
    }
}
