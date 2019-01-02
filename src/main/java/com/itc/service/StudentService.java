package com.itc.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.bo.StudentBO;
import com.itc.dao.StudentDAO;
import com.itc.dto.StudentDTO;
import com.itc.vo.StudentVO;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class StudentService {
	@Autowired
	private StudentDAO dao;

	public String saveStudent(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		System.out.println("going to pass bo to dao......DTOSERVICE" + dto);
		int n = dao.saveStudentDetails(bo);
		if (n == 0) {
			return "Data is not inserted .......";
		} else {
			return "Data is inserted into db.......";
		}
	}
	public List<StudentBO> selectAll(){
		List<StudentBO> list=dao.getAllStudent();
		return list;
	}
	public StudentDTO selectBySno(Integer sno) {
		StudentBO bo=dao.getBySno(sno);
		StudentDTO dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	public String deleteBySno(Integer sno) {
		int result=dao.deleteById(sno);
		if(result==0) {
			return "Record is not deleted";
		}
		else {
			return "Record is deleted";
		}
	}
	public String updateStudent(StudentDTO dto) {
		StudentBO bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		int result=dao.updateStudentBySno(bo);
		if(result==0) {
			return "Data is not updated";
		}
		else {
			return"Data is updated";
		}
	}
}
