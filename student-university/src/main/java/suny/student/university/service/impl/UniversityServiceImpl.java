package suny.student.university.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import suny.student.university.entity.Student;
import suny.student.university.entity.University;
import suny.student.university.repository.UniversityRepository;
import suny.student.university.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	private UniversityRepository universityRepo;

	@Override
	public University createUniversity(University univ) {
		List<Student> univStudList = univ.getStudents();
		for (Student student : univStudList) {
			student.setUniversity(univ);
		}
	   return  universityRepo.save(univ);
	}
	
	@Override
	public List<University> createListOfUniversity(List<University> univ) {
		List<University> univList = new ArrayList<>();
		for (University university : univ) {
			University univObj=createUniversity(university);
			 univList.add(univObj);
			}
		return univList;
	}
	
	@Override 
	public List<String> studListByUniversityId(Long univId){
		University univById = universityRepo.findById(univId).orElse(null);
		if(univById!=null){
			List<Student>studentListByUnivId = univById.getStudents();
			 List<String> studNameList = new ArrayList<>();
	       for (Student student : studentListByUnivId) {
			     String studNames = student.getStudentName();
			     studNameList.add(studNames);
			     }
	       return studNameList;
		}
		return null;
	 }
//univ Name as input
//student count in that university
	//@Override
	public Map<String,Integer> univNameAndStudCount(String univName) {
		Map<String,Integer> hm = new HashMap<>();
		University univByName = universityRepo.findByUnivName(univName);
		List<Student>studentListByUnivName = univByName.getStudents();
		for(Student student : studentListByUnivName) {
			if(hm.containsKey(univName)) {
				hm.put(univName, studentListByUnivName.size());
			}
		       else {
		    	   hm.put(univName, studentListByUnivName.size());
		       }
		       
		 }
		return hm;
	}

	@Override
	public Map<String, List<String>> univNameAndListOfStud(String univName) {
		Map<String,List<String>> hm = new HashMap<>();
		University univByName = universityRepo.findByUnivName(univName);
		List<Student>studentListByUnivName = univByName.getStudents();
		 for(Student student : studentListByUnivName) {
			if(hm.containsKey(univName)) {
				hm.get(student.getUniversity().getUnivName()).add(student.getStudentName());
			}
		       else {
		    	   List<String> studNameList = new ArrayList<>();
		    	   studNameList.add(student.getStudentName());
		    	   hm.put(univName, studNameList);
		       }
		       
		 }
			 return hm;
	}

}
	
	