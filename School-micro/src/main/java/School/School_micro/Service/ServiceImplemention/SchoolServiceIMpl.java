package School.School_micro.Service.ServiceImplemention;

import School.School_micro.Entity.Schools;
import School.School_micro.Entity.Student;
import School.School_micro.Exception.CustomException.EmptyObjectException.EmptyObjectException;
import School.School_micro.Exception.ResourceNotFound;
import School.School_micro.Repository.SchoolRepository;
import School.School_micro.Service.ExternalService.StudentService;
import School.School_micro.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceIMpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentService studentService;
    @Override
    public Schools saveSchool(Schools school) {

        if(school.getSchoolName().isEmpty() || school.getSchoolName().length() == 0){
            throw new EmptyObjectException("Please provide name");
        }

        return schoolRepository.save(school);
    }

    @Override
    public List<Schools> getAllSchools() {

        return  schoolRepository.findAll();
    }

    @Override
    public Schools getSchoolById(int id) {

        Schools school = schoolRepository.getReferenceById(id);

        List<Student> allStudentsBySchoolId = studentService.getAllStudentsBySchoolId(id);



        return Schools.builder()
                .id(school.getId())
                .schoolName(school.getSchoolName())
                .state(school.getState())
                .studentList(allStudentsBySchoolId)
                .build();
    }

    @Override
    public Schools updateSchool(int id,Schools school) {

        Schools updatedSchool = schoolRepository.findById(id).orElseThrow(()->new ResourceNotFound("user is not found with the given id."));

        updatedSchool.setSchoolName(school.getSchoolName());
        updatedSchool.setState(school.getState());
        updatedSchool.setId(id);


        return schoolRepository.save(updatedSchool);

    }

    @Override
    public void deleteSchool(int id) {

        Schools school = schoolRepository.findById(id).orElseThrow(() -> new ResourceNotFound("REsource not found"));
        schoolRepository.delete(school);

    }
}

