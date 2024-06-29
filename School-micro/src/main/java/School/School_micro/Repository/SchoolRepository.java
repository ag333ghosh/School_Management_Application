package School.School_micro.Repository;

import School.School_micro.Entity.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<Schools,Integer> {
    //custom queary

}
