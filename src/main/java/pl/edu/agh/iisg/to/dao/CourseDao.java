package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import java.util.Optional;

public class CourseDao extends GenericDao<Course> {

    public Optional<Course> create(final String name) {
        //TODO [5] Implementacja stworzenia obiektu w bazie danych
        return Optional.empty();
    }

    public Optional<Course> findById(final int id) {
        //TODO [6] Implementacja znajdowania kursu poprzez id
        return Optional.empty();
    }

    public boolean enrollStudent(final Course course, final Student student) {
        //TODO [7] Implementacja dodawania studenta do zajęć
        return false;
    }

}
