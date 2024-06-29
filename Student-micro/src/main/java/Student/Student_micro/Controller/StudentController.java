package Student.Student_micro.Controller;

import Student.Student_micro.Entiey.Student;
import Student.Student_micro.Service.Impl.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;
    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

        Student saveStudent = studentService.save(student);
        return new ResponseEntity<>(saveStudent, HttpStatus.OK);
    }
    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return new ResponseEntity<String>("public user",HttpStatus.OK);
    }
    @GetMapping("/getAllStudentsBySchoolId/{id}")
    public ResponseEntity<List<Student>> getAllStudent(@PathVariable int id){

        return new ResponseEntity<>(studentService.findAllBySchoolId(id),HttpStatus.OK);

    }
    @PutMapping("/updateStudent/{rollno}")
    public ResponseEntity<Student> updateStudent(@PathVariable int rollno,@RequestBody Student student){
        return new ResponseEntity<>( studentService.updateStudent(rollno, student),HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{rollno}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteStudent(@PathVariable int rollno){
        studentService.deleteStudent(rollno);
    }
}
