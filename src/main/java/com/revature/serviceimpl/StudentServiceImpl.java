package com.revature.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.StudentDto;
import com.revature.model.Student;
import com.revature.repo.StudentRepo;
import com.revature.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public StudentDto createStudent(StudentDto dto) {
		// TODO Auto-generated method stub
		Student s=repo.save(modelMapper.map(dto, Student.class));
		s.setId(dto.getId());
		s.setName(dto.getName());
		s.setBranch(dto.getBranch());
		return modelMapper.map(s, StudentDto.class);
	}
	@Override
	public List<StudentDto> showAll() {
		List<Student> s=repo.findAll();
		return s.stream().map(st->modelMapper.map(st, StudentDto.class)).collect(Collectors.toList());
	}
	@Override
	public StudentDto updateById(StudentDto sDto,int id) {
			Student s=repo.findById(id).get();
			s.setName(sDto.getName());
			s.setBranch(sDto.getBranch());
			repo.save(s);
			return modelMapper.map(s, StudentDto.class);
		
	}
	@Override
	public String deleteById(int id) {
		
		return "deleted";
	}
	@Override
	public StudentDto getById(int id) {
		Student s=repo.findById(id).get();
		
		return modelMapper.map(s, StudentDto.class);
	}
	

}
