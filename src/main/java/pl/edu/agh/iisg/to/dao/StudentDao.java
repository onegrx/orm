package pl.edu.agh.iisg.to.dao;

import org.hibernate.Session;
import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
        Student student = new Student(firstName, lastName, indexNumber);
        try {
            save(student);
            return Optional.of(student);
        } catch (PersistenceException e) {
            return Optional.empty();
        }
    }

    public Optional<Student> findById(final int id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return Optional.ofNullable(student);
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
        Session session = sessionFactory.openSession();
        Student student =
                session.createQuery("select s from Student s where s.indexNumber = :index", Student.class)
                .setParameter("index", indexNumber).getSingleResult();
        session.close();
        return Optional.ofNullable(student);
    }

    public List<Student> findAllByLastName(final String lastName) {
        Session session = sessionFactory.openSession();
        List<Student> students =
                session.createQuery("select s from Student s where s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName).getResultList();
        session.close();
        //Hibernate returns an empty list if no results are found instead of null
        return students;
    }

    public Map<Course, Float> createReport(final Student student) {
        //TODO [10] Implementacja tworzenia raportu dla studenta w każdym kursie z średnią ocen
        return Collections.emptyMap();
    }

}
