package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

public class GradeDao extends GenericDao<Grade> {

    public boolean markStudent(final Student student, final Course course, final float grade) {
        Grade studentCourseGrade = new Grade(student, course, grade);
        if (student.gradeSet().contains(studentCourseGrade) || course.gradeSet().contains(studentCourseGrade)) {
            return false;
        }
        student.gradeSet().add(studentCourseGrade);
        course.gradeSet().add(studentCourseGrade);
        return true;
    }


}
