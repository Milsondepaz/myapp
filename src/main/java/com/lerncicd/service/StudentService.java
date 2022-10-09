package com.lerncicd.service;

import com.lerncicd.db.entity.Student;
import com.lerncicd.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private Student milson;
    private Student marciano;


    @Autowired
    public StudentService (final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void studentBuild (){
        milson = new Student(1L, "Milson", "Antonio", "Ciencia da Computacao");
        marciano = new Student(2L, "Marcio", "Cacola Antonio", "Engenharia de Software");
        studentRepository.save(marciano);
        studentRepository.save(milson);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional <Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
