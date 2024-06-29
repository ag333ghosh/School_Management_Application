package Student.Student_micro.Service.Impl;

import Student.Student_micro.Entiey.Student;
import Student.Student_micro.Repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
public class StudentServiceImpTest {

//    @Autowired
    @InjectMocks
    private StudentServiceImp studentService;

    @Mock
//    @MockBean
    public StudentRepository repository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }



    @ParameterizedTest
    @ValueSource( strings = {
            "1","2","3"
    })
    public void findAllBySchoolIdTest(int id){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(Student.builder().schoolId(1).name("Amit").rollNo(15).standard(8).build());
        studentList.add(Student.builder().schoolId(2).name("Sumit").rollNo(16).standard(9).build());
        studentList.add(Student.builder().schoolId(3).name("Tapan").rollNo(17).standard(10).build());

        when(repository.findAllBySchoolId(id)).thenReturn( studentList);

        List<Student> allBySchoolId = repository.findAllBySchoolId(id);

        Assertions.assertNotNull(allBySchoolId);
    }






    /*
    @Test
    public void findAllBySchoolIdTest(){

        Assertions.assertEquals(4,2+2);
       Assertions.assertNotNull(repository.findAllBySchoolId(1));
        List<Student> allBySchoolId = repository.findAllBySchoolId(1);
        Assertions.assertTrue(!(allBySchoolId.isEmpty()));
    }
    */


    /*
    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "3"
    })
    public void findAllBySchoolIdTest(int id){

        List<Student> allBySchoolId = repository.findAllBySchoolId(id);

        Assertions.assertNotNull(allBySchoolId);
    }
     */

    /*
    @ParameterizedTest
    @ValueSource( ints = {
            1,2,3
    })
    public void findAllBySchoolIdTest(int id){

        List<Student> allBySchoolId = repository.findAllBySchoolId(id);

        Assertions.assertNotNull(allBySchoolId);
    }
     */

//    @ParameterizedTest
//    @ValueSource( strings = {
//            "1","2","3"
//    })
//    public void findAllBySchoolIdTest(int id){
//
//        List<Student> allBySchoolId = repository.findAllBySchoolId(id);
//
//        Assertions.assertNotNull(allBySchoolId);
//    }



    @Disabled
    @ParameterizedTest
    @CsvSource({
             "5,2,7",
            "15,3,18"
    })
    public void test(int a, int b, int c){
        Assertions.assertEquals(c,a+b);
    }

    @BeforeAll /* runs once before any test method. */
    public static void beforeAllTest(){
        System.out.println("Before All [only one time at a class]");
    }

    @AfterAll /* runs once after any test method. */
    public static void afterAllTest(){
        System.out.println("After All [only one time at a class]");
    }

    @BeforeEach /*  runs before each test method. */
    public void beforeEachTest(){
        System.out.println("Before Each method [can execute more than one time]");
    }

    @AfterEach /*  runs after each test method. */
    public void afterEachTest(){
        System.out.println("After Each method [can execute more than one time]");
    }



}
