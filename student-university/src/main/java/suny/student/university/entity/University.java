package suny.student.university.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="University")
public class University {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String univName;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> students = new ArrayList<>();
	


	public University() {
		super();
	}


	public University(String univName) {
		super();
		this.univName = univName;
	}


	public String getUnivName() {
		return univName;
	}


	public void setUnivName(String univName) {
		this.univName = univName;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
