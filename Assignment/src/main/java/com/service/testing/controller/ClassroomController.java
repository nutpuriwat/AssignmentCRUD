package com.service.testing.controller;

import com.service.testing.model.Classroom;
import com.service.testing.model.Student;
import com.service.testing.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/getClassroomList")
    public List<Classroom> getClassroomList() {
        return classroomService.getClassroomList();
    }

    @GetMapping("getClassroom/{classroomId}")
    public Optional<Classroom> getClassroomById(@PathVariable long classroomId){
        return ClassroomService.getClassroomById(classroomId);
    }

    @PostMapping("/addClassroom")
    public String addClassroom(@RequestBody Classroom classroom) {
        classroomService.addClassroom(classroom);
        return "Success addClassroom.";
    }

    @PutMapping("/updateClassroom/{classroomId}")
    public String updateClassroom(@PathVariable long classroomId, @RequestBody Classroom classroom){
        classroom.setId(classroomId);
        classroomService.updateClassroom(classroom);
        return "Success updateClassroom";
    }

    @DeleteMapping("/deleteClassroom/{classroomId}")
    public String deleteClassroomById(@PathVariable long classroomId, @RequestBody Classroom classroom){
        classroomService.deleteClassroomById(classroomId);
        return "Success deleteClassroomById";
    }

    @PostMapping("/addStudentToClassroom/{classroomId}/{studentId}")
    public String addStudentToClassroom(@PathVariable long classroomId, @PathVariable long studentId){
        classroomService.addStudentToClassroom(classroomId, studentId);
        return "Success addStudentToClassroom";
    }

    @DeleteMapping("/deleteStudentFromClassroomById/{classroomId}/{studentId}")
    public String deleteStudentFromClassroomById(@PathVariable long classroomId, @PathVariable long studentId){
        classroomService.deleteStudentFromClassroomById(classroomId, studentId);
        return "Success deleteStudentFromClassroomById";
    }
}
