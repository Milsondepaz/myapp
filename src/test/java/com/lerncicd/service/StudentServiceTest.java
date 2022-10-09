package com.lerncicd.service;

import com.lerncicd.db.entity.Student;
import com.lerncicd.db.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    public void setup(){
        student = Student.builder()
                .id(1L)
                .firstName("Milson")
                .lastName("antonio")
                .course("Ciencia da Computacao")
                .build();
    }

    @DisplayName("JUnit test for save student method")
    @Test
    public void givenStudentObject_whenSave_thenReturnStudent(){
        given(studentRepository.save(student)).willReturn(student);
        Student studentDB = studentService.saveStudent(student);
        assertThat(studentDB).isNotNull();
        assertThat(studentDB.getFirstName()).isEqualTo("Milson");
    }


}