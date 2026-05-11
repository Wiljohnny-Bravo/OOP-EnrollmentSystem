package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class RegistrarTest {
    @Mock
    IStudentService IStudentService;

    @InjectMocks
    Registrar registrar;

    @Test
    void testRegistrar(){
        Student s1 = new Student( 01, "John Doe", "IT");
        String result = registrar.saveStudent(s1);

        assertEquals("Success", result);

        verify(IStudentService).addStudent(s1);

    }
}