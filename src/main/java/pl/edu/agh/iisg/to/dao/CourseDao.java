package pl.edu.agh.iisg.to.dao;

import org.hibernate.Session;
import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;
import java.util.Optional;

public class CourseDao extends GenericDao<Course> {

    public Optional<Course> create(final String name) {
        Course course = new Course(name);
        try {
            save(course);
            return Optional.of(course);
        } catch (PersistenceException e) {
            return Optional.empty();
        }
    }


    public Optional<Course> findById(final int id) {

        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return Optional.ofNullable(course);
    }

    public boolean enrollStudent(final Course course, final Student student) {
        if( course.studentSet().contains(student) || student.courseSet().contains(course))
            return false;
        course.studentSet().add(student);
        student.courseSet().add(course);
        return true;
    }

}
