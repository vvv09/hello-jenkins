package com.valunskii.springjenkinspipeline.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.valunskii.springjenkinspipeline.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
