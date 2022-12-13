package com.example.demo.dao;

import com.example.demo.dao.mappers.StudentMapper;
import com.example.demo.entities.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO {
    private StudentMapper studentMapper;

    @Autowired
    public StudentDAO(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getStudents(String title){
        return studentMapper.getStudents(title);
    }



    public void insertStudent( long id,
                               String fulltext,
                               String title,
                               int value ){
        studentMapper.insertStudent(id, fulltext, title, value);
    }

    public void updateValue(String full_text){
        studentMapper.updateValue(full_text);
    }

    public long getMaxId(){
        Long id = studentMapper.getMaxId();
        return id == null ? 0L : id;
    }


}
