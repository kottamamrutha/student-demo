package com.revature.service;

import java.util.List;

import com.revature.dto.StudentDto;

public interface StudentService {
	public StudentDto createStudent(StudentDto dto);
	public List<StudentDto> showAll();
	public StudentDto getById(int id);
	public StudentDto updateById(StudentDto dto,int id);
	public String deleteById(int id);
}
