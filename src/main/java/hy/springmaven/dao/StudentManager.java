package hy.springmaven.dao;

import hy.springmaven.pojo.Student;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class StudentManager {
	Map<String, Student> students = new ConcurrentHashMap<String, Student>();
   
    public synchronized void addStudent(Student student){
       if(students.containsKey(student.getId()))
           return;
       students.put(student.getId(), student);
    }
   
    public synchronized void deleteStudent(String id){
       if(students.containsKey(id))
           students.remove(id);
    }
   
    public synchronized void updateStudent(String id,Student student){
       deleteStudent(id);
       if(student.getId()==null || student.getId().equals(""))
           student.setId(id);
       addStudent(student);
    }
   
    public synchronized Student getStudent(String id){
       return students.get(id);
    }
 
    /*public synchronized StudentList getStudent() {
       StudentList sl = new StudentList();
       for(String key : students.keySet())
       {
           sl.getStudents().add(students.get(key));
       }
       return sl;
    }*/
   
}
