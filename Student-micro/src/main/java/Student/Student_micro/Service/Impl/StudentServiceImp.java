package Student.Student_micro.Service.Impl;

import Student.Student_micro.Entiey.Student;
import Student.Student_micro.Exception.ResourceNotFound;
import Student.Student_micro.Repository.StudentRepository;
import Student.Student_micro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {

        Student studentObject = studentRepository.save(student);
        if(studentObject.getName().isEmpty()){
            throw new ResourceNotFound("blank data can not be save, please provide specific data.");
        }
        return studentObject;
    }

    @Override
    public Student updateStudent(int rollno, Student student) {
        Student updatedStudent = studentRepository.getReferenceById(rollno);

        updatedStudent.setName(student.getName());
        updatedStudent.setStandard(student.getStandard());
        updatedStudent.setRollNo(rollno);
        updatedStudent.setSchoolId(student.getSchoolId());

        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(int rollno) {

        Student studentObject = studentRepository.getReferenceById(rollno);
        if(studentObject==null){
            throw new ResourceNotFound("Object is not found in DB with given id : "+rollno);
        }
        studentRepository.delete(studentObject);

    }

    @Override
    public List<Student> findAllBySchoolId(int id) {

        return studentRepository.findAllBySchoolId(id);

    }

    @Override
    public Student getStudentByRollNo(int rollno) {
        Student student = studentRepository.getReferenceById(rollno);
        return student;
    }
}
