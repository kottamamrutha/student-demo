package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
