package pl.edu.agh.iisg.to.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;

public abstract class GenericDao<T> {

    protected static final SessionFactory sessionFactory = new Configuration()
            .configure() // configures settings from hibernate.cfg.xml
            .buildSessionFactory();

    public void save(final T object) throws PersistenceException {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction tx = session.beginTransaction();
            session.save(object);
            session.merge(object);
            tx.commit();
        }
    }

    public void update(final T object) throws PersistenceException {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction tx = session.beginTransaction();
            session.update(object);
            session.merge(object);
            tx.commit();
        }
    }

}
