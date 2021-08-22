package com.valunskii.springjenkinspipeline;

import com.valunskii.springjenkinspipeline.domain.Student;
import com.valunskii.springjenkinspipeline.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

//@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = {SpringJenkinsPipelineApplication.class})
public class SomeIntegrationTest {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeAll
    public void setup() {
        Student student = new Student("Paul", "Smith", "64377473774", "me@mailprovider.com");
        studentRepository.save(student);
    }

    @Test
    public void whenInserting_andCount_thenWeDontGetZero() {
        long count = studentRepository.count();
        assertNotEquals(0, count);
    }

    @AfterAll
    public void clean() {
        studentRepository.deleteAll();
    }
}