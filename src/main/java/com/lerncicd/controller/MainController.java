package com.lerncicd.controller;

import com.lerncicd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MainController {



    private final StudentService studentService;

    @Autowired
    public MainController (final StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("student", studentService.getStudentById(1L).get());
        return mv;
    }
}
