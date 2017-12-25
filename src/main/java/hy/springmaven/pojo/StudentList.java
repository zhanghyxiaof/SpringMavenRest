package hy.springmaven.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students = new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
