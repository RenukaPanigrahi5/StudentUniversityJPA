package suny.student.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suny.student.university.entity.Student;
import suny.student.university.repository.StudentRepository;
import suny.student.university.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public String getUnivNameByStudName(String studentName) {
		Student studObj =studentRepo.findByStudentName(studentName);
		return studObj.getUniversity().getUnivName();
	}


}
