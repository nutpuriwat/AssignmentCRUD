package com.service.testing.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Classroom {
    @Id
    private long id;
    private String name;

    private List<Long> students = new ArrayList<>();

    public void addStudentToClassroom(long studentId){
        students.add(studentId);
    }

    public void  removeStudentFromClassroom(long studentId){
        students.remove(studentId);
    }
}
