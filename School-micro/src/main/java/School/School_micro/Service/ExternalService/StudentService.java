package School.School_micro.Service.ExternalService;

import School.School_micro.Entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Student-micro",url = "http://localhost:8081/Student")
public interface StudentService {
      @GetMapping("/getAllStudentsBySchoolId/{id}")
      List<Student> getAllStudentsBySchoolId(@PathVariable int id);

}
