package Student.Student_micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroApplication.class, args);
	}

}
