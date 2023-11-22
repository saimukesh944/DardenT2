package com.example.Task2.repository;

import com.example.Task2.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {
	Student findById(int id);
}
