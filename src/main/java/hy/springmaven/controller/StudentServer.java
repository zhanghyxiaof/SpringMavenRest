package hy.springmaven.controller;

import hy.springmaven.dao.StudentManager;
import hy.springmaven.pojo.Student;
import hy.springmaven.pojo.StudentList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/students")
public class StudentServer {
    private StudentManager manager;

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public String createStudent(@RequestBody Student student){
       manager.addStudent(student);
       return student.getId();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable String id){
    	Student student = new Student();
    	student.setId(id);
    	student.setName("henry");
    	student.setAge(15);
    	return student;
       //return manager.getStudent(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public StudentList getStudent(){
    	StudentList students = new StudentList();
    	Student student = new Student();
    	student.setId("11");
    	student.setName("henry");
    	student.setAge(55);
    	students.getStudents().add(student);
    	return students;
       //return manager.getStudent();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    @ResponseBody
    public void updateStudent(@RequestBody Student student,@PathVariable String id){
       manager.updateStudent(id, student);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@PathVariable String id){
       manager.deleteStudent(id);
    }

    @Autowired
    public void setManager(StudentManager manager) {
       this.manager = manager;
    }
}