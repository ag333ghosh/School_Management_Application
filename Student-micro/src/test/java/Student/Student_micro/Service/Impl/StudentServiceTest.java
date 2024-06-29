package Student.Student_micro.Service.Impl;

import Student.Student_micro.Entiey.Student;
import Student.Student_micro.Repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


//@SpringBootTest
//@ExtendWith(MockitoExtension.class) create mock instances of the class you want to test
public class StudentServiceTest {

    @InjectMocks
    private StudentServiceImp studentService;

    @Mock
    private StudentRepository repository;

    public void init(){
        Student s1= Student.builder().schoolId(1).rollNo(11).standard(11).name("Ami eleven e pori").build();
        Student s2= Student.builder().schoolId(2).rollNo(22).standard(12).name("Ami twelve e pori").build();

        when(repository.save(s1)).thenReturn(s1);
        when(repository.findAllBySchoolId(ArgumentMatchers.anyInt())).thenReturn(List.of(s1,s2));
        when(repository.getReferenceById(ArgumentMatchers.anyInt())).thenReturn(s1);

    }





    @BeforeEach
    void setUp(){

//    Purpose:
//    The purpose of this line is to initialize mock objects (annotated with Mockito annotations) within a test class.
//    It allows you to create mock instances of classes or interfaces that you want to use during testing.

        MockitoAnnotations.openMocks(StudentServiceTest.class);

    }


    @Test
    public void getStudentByRollNoTest(){
        Student save1 = studentService.getStudentByRollNo(12);
        Assertions.assertEquals(save1.getName(),"Amit Mandal");
    }


}

