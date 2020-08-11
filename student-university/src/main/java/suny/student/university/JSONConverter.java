package suny.student.university;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import suny.student.university.entity.Student;
import suny.student.university.entity.University;

public class JSONConverter {


	public static void main(String[] args) {
		University u =new University("tys");
		Student e1 = new Student("dfg",u);
		Student e2 = new Student("dfgu",u);
		List<Student> ie = new ArrayList<Student>();
		ie.add(e1);
		ie.add(e2);
		u.setStudents(ie);
		ObjectMapper mapper = new ObjectMapper();
	     String jsonString;
		try {
			jsonString = mapper.writeValueAsString(u);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	}

}
