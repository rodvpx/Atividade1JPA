package org.example.dao;

import org.example.model.Autor;
import org.example.model.Livro;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class AutorDAO {
    public void salvar(Autor autor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(autor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public Autor buscarPorId(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Autor.class, id);
        } finally {
            session.close();
        }
    }

    public void excluir(Autor autor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(autor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public List<Livro> buscarLivrosPorAutor(UUID autorId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Livro> query = session.createQuery(
                    "FROM Livro WHERE autor.id = :autorId",  // Nome do parâmetro na query
                    Livro.class
            );
            query.setParameter("autorId", autorId);  // Nome deve ser igual aqui ✅
            return query.getResultList();
        } finally {
            session.close();
        }
    }


}