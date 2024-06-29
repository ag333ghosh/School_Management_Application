package School.School_micro.Controller;

import School.School_micro.Entity.Schools;
import School.School_micro.Service.ServiceImplemention.SchoolServiceIMpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@RestController
@RequestMapping("/School")
public class SchoolController {

    @Autowired
    private SchoolServiceIMpl schoolService;

    @PostMapping("/saveSchool")
    public ResponseEntity<Schools> SaveSchool(@RequestBody Schools school){
        Schools schools = schoolService.saveSchool(school);
        return new ResponseEntity<Schools>(school, HttpStatus.CREATED);
    }
    @GetMapping("/getAllSchools")
    public ResponseEntity<List<Schools>> getAllSchools(){
        return new ResponseEntity<>(schoolService.getAllSchools(),HttpStatus.OK);
    }
    int count=0;
    @GetMapping("/getSchoolById/{id}")
//    @Retry(name = "school_studentRetry",fallbackMethod = "school_studentFallBack")
//    @CircuitBreaker(name = "school_studentBreaker",fallbackMethod = "school_studentFallBack")
    @RateLimiter(name = "school_studentRateLimiter",fallbackMethod = "school_studentFallBack")
    public ResponseEntity<Schools> getSchoolById(@PathVariable int id){

        log.info("retryCount: {}",count);
        count++;

        return new ResponseEntity<>(schoolService.getSchoolById(id),HttpStatus.FOUND);
    }
    public ResponseEntity<Schools> school_studentFallBack(int id,Exception exception){

        log.info("FallBack method is execuing beacuse student service is down "+exception.getMessage());
        Schools dummySchool = Schools.builder().schoolName("dummy").studentList(null).state("dummy").id(11).build();
        return new ResponseEntity<Schools>(dummySchool,HttpStatus.NOT_FOUND);

    }
    @PutMapping("/updateSchool/{id}")
    public ResponseEntity<Schools> updateSchool(@PathVariable int id,@RequestBody Schools school){

        return new ResponseEntity<>(schoolService.updateSchool(id,school),HttpStatus.OK);
    }
    @DeleteMapping("/deleteSchool/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable int id){
        schoolService.deleteSchool(id);
    }


}
