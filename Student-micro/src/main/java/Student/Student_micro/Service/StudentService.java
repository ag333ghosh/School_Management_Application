package Student.Student_micro.Service;

import Student.Student_micro.Entiey.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);

    public Student updateStudent(int rollno,Student student);

    public void deleteStudent(int rollno);

    public List<Student> findAllBySchoolId(int id);

    public Student getStudentByRollNo(int rollno);




}
