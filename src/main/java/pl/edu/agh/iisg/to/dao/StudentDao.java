package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
        //TODO [1] Implementacja stworzenia obiektu w bazie danych
        return Optional.empty();
    }

    public Optional<Student> findById(final int id) {
        //TODO [2] Implementacja znajdowania studenta poprzez id
        return Optional.empty();
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
        //TODO [3] Implementacja znajdowania studenta poprzez index
        return Optional.empty();
    }

    public List<Student> findAllByLastName(final String lastName) {
        //TODO [4] Implementaca znajdowania studentów dla podanego nazwiska
        return Collections.emptyList();
    }

    public Map<Course, Float> createReport(final Student student) {
        //TODO [10] Implementacja tworzenia raportu dla studenta w każdym kursie z średnią ocen
        return Collections.emptyMap();
    }

}
