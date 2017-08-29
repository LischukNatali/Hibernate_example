package com.skillsup.hibernate.Build.dao;

import com.skillsup.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl<E> implements GenericDAO<E> {
    Map<Long, E> entities = new HashMap<>();

    @Override
    public E save(E entity, Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Long) session.save(entity);

            session.getTransaction().commit();
            entities.put(id, entity);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session!=null || session.isOpen()) {
                session.close();
                HibernateUtil.closeSessionFactory();
            }

        }
        return entity;
    }

    @Override
    public void update(E entity, Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            entities.put(id, entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session!=null && session.isOpen()) {
                session.close();
                HibernateUtil.closeSessionFactory();
            }
        }
    }

    @Override
    public void delete(E entity, Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            entities.remove(id, entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session!=null && session.isOpen()) {
                session.close();
                HibernateUtil.closeSessionFactory();

            }
        }
    }

    @Override
    public E findById(Class<E> cls, Long id) {
        Session session = null;
        E entity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            entity = (E) session.load(cls, id);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session!=null && session.isOpen()) {
                session.close();
            }
        }
        return entity;
    }

    @Override
    public List<E> findAll(Class<E> cls) {
        Session session = null;
        List <E> entity = new ArrayList<E>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            entity = session.createCriteria(cls).list();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session!=null && session.isOpen()) {
                session.close();
            }
        }
            return entity;
    }
}
