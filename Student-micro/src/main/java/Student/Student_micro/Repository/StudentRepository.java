package Student.Student_micro.Repository;

import Student.Student_micro.Entiey.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    //coustom queary
    List<Student> findAllBySchoolId(int id);
//    List<BigDecimal> findTopSalaries(Pageable pageable);
}
