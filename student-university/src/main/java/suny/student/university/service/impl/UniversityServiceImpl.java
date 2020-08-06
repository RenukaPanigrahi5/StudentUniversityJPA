package suny.student.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suny.student.university.entity.University;
import suny.student.university.repository.UniversityRepository;
import suny.student.university.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	private UniversityRepository universityRepo;

	@Override
	public University createUniversity(University univ) {
	   universityRepo.save(univ);
	   return  universityRepo.save(univ);
	}

}
