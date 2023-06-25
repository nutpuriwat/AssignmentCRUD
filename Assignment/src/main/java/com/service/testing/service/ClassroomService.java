package com.service.testing.service;

import com.service.testing.model.Classroom;
import com.service.testing.repository.ClassroomRepository;
import com.service.testing.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired private static ClassroomRepository classroomRepository;
    @Autowired private StudentRepository studentRepository;

    public List<Classroom> getClassroomList(){
        return classroomRepository.findAll();
    }

    public static Optional<Classroom> getClassroomById(long classroomId) {
        return classroomRepository.findById(classroomId);
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public void updateClassroom(Classroom classroom) {
        classroom.setId(classroom.getId());
        classroom.setName(classroom.getName());
        classroomRepository.save(classroom);
    }

    public void deleteClassroomById(long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        classroomRepository.deleteById(classroom.getId());
    }

    public void addStudentToClassroom(long classroomId, long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        classroom.addStudentToClassroom(studentId);
        classroomRepository.save(classroom);
    }

    public void deleteStudentFromClassroomById(long classroomId, long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        classroom.removeStudentFromClassroom(studentId);
        classroomRepository.save(classroom);
    }
}
