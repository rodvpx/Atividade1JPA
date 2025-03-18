package org.example.dao;

import org.example.model.Editora;
import org.example.model.Livro;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class EditoraDAO {
    public void salvar(Editora editora) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(editora);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public Editora buscarPorId(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Editora.class, id);
        } finally {
            session.close();
        }
    }

    public void excluir(Editora editora) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(editora);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public List<Livro> buscarLivrosPorEditora(UUID editoraId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Livro> livros = null;
        try {
            Query query = session.createQuery(
                    "SELECT l FROM Livro l WHERE l.editora.id = :editora_id", Livro.class);
            query.setParameter("editora_id", editoraId);
            livros = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return livros;
    }

}