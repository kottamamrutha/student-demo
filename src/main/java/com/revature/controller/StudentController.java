package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.StudentDto;
import com.revature.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v2")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<StudentDto>studentCreatetion(@RequestBody StudentDto dto){
		return new ResponseEntity<>(studentService.createStudent(dto),HttpStatus.OK);
	}
	@GetMapping("/allstudents")
	public ResponseEntity<List<StudentDto>>allStudents(){
		return new ResponseEntity<>(studentService.showAll(),HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDto>updateById(@RequestBody StudentDto dto,@PathVariable int id){
		return new ResponseEntity<>(studentService.updateById(dto, id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>delete(@PathVariable int id) {
		return new ResponseEntity<>(studentService.deleteById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<StudentDto>getById(@PathVariable int id){
	return new  ResponseEntity<>(studentService.getById(id),HttpStatus.OK); 
	}
}
