package com.service.testing.service;

import com.service.testing.model.Student;
import com.service.testing.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(long studentId) {
        return studentRepository.findById(studentId);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        student.setId(student.getId());
        student.setName(student.getName());
        student.setGpa(student.getGpa());
        studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
//        Student student = studentRepository.findById(studentId).get();
//        studentRepository.deleteById(student.getId());
        studentRepository.deleteById(studentId);
    }
}
