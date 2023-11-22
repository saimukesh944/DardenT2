package com.example.Task2.Controller;

import com.example.Task2.entity.Student;
import com.example.Task2.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/All")
    public List<Student> GetAll(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return  studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
