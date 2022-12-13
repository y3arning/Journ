package com.example.demo.controllers;

import com.example.demo.entities.StudentDto;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class GroupController {

    private StudentService studentService;

    @Autowired
    public GroupController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping("/group/add")
    public String groupAdd (Model model) {
        return "group-add";
    }


    @PostMapping("/group/add")
    public String groupPostAdd(@RequestParam String title, @RequestParam String full_text, Model model) {
        studentService.insertStudent(studentService.getMaxId() + 1, full_text, title, 0);
        return "group-add";
    }

    @GetMapping("/group")
    public String groupMain (Model model) {
        return "group-main";
    }

    @PostMapping("/group")
    public String groupInfo(@RequestParam String title, Model model) {

        model.addAttribute("t", title);
        List<StudentDto> list = studentService.getStudents(title);
        model.addAttribute("n", list);

        return "gr-info";
    }

    @GetMapping("/failures")
    public String failures (Model model) {
        return "stud-values";
    }


    @PostMapping("/failures")
    public String groupFails(@RequestParam String full_text, Model model) {

        studentService.updateValue(full_text);

        return "stud-values";
    }

}
