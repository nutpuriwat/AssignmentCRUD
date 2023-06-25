package com.service.testing.controller;

import com.service.testing.model.Student;
import com.service.testing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentList")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/getStudent/{studentId}")
    public Optional<Student> getStudentById(@PathVariable long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Success addStudent.";
    }

    @PutMapping("updateStudent/{studentId}")
    public String updateStudent(@PathVariable long studentId, @RequestBody Student student){
        student.setId(studentId);
        studentService.updateStudent(student);
        return "Success updateStudent";
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable long studentId){
        studentService.deleteStudent(studentId);
        return "Success deleteStudent";
    }

}
