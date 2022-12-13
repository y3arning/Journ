package com.example.demo.services;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entities.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<StudentDto> getStudents(String title){
        return studentDAO.getStudents(title);
    }

    @Transactional
    public void insertStudent( long id,
                               String fulltext,
                               String title,
                               int value ){
        studentDAO.insertStudent(id, fulltext, title, value);
    }

    @Transactional
    public void updateValue(String full_text){
        studentDAO.updateValue(full_text);
    }


    public long getMaxId(){
        return studentDAO.getMaxId();
    }


}
