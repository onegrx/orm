package pl.edu.agh.iisg.to.dao;

import org.hibernate.Session;
import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;
import java.util.*;

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
        Map<Course, Float> finalReport = new HashMap<>();
        Map<Course, Float> report = new HashMap<>();
        Map<Course, Integer> gradesNumbers = new HashMap<>();
        student.gradeSet().forEach(gr -> {

            float sum = report.getOrDefault(gr.course(), 0f);
            report.put(gr.course(), sum + gr.grade());
            int count = gradesNumbers.getOrDefault(gr.course(), 0);
            gradesNumbers.put(gr.course(), count + 1);

        });
        report.forEach((course, gradeSum) -> {
            float mean = gradeSum / gradesNumbers.get(course);
            finalReport.put(course, mean);
        });
        return finalReport;
    }

}
