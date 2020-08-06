package suny.student.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import suny.student.university.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
