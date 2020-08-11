package suny.student.university;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import suny.student.university.entity.Student;
import suny.student.university.entity.University;
import suny.student.university.repository.UniversityRepository;

@SpringBootApplication
@EnableSwagger2
public class StudentUniversityApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StudentUniversityApplication.class, args);
		
		ConfigurableApplicationContext b = SpringApplication.run(StudentUniversityApplication.class, args);
		loadIntialUnivData(b);
	}
	
	private static void loadIntialUnivData(ConfigurableApplicationContext b ) {
		UniversityRepository repo = b.getBean(UniversityRepository.class);
	    University d =new University("suny");
		Student s1 = new Student("abc",d);
		Student s2 = new Student("def",d);
		List<Student> ie = new ArrayList<>();
		ie.add(s1);
		ie.add(s2);
		d.setStudents(ie);
	    //repo.save(d);
	    //repo.save(d1);
	    ObjectMapper mapper = new ObjectMapper();
	     String jsonString;
		try {
			jsonString = mapper.writeValueAsString(d);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	}
	


