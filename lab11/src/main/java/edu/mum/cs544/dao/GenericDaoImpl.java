package edu.mum.cs544.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {
    @PersistenceContext
    private EntityManager em;

    public GenericDaoImpl() {
    }

    public Class<T> daoType;

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + daoType.getName()).getResultList();
    }

    @Override
    public void add(T t) {
        em.persist(t);
    }

    @Override
    public T get(int id) {
        return em.find(daoType, id);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public void delete(int id) {
        T t = em.getReference(daoType, id);
        em.remove(t);
    }
}
