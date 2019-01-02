package com.itc.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itc.bo.StudentBO;
import com.itc.dto.StudentDTO;

@Repository
public class StudentDAO {
	private static final String SELECT_BY_SNO = "SELECT * FROM student_0538 WHERE sno=? ";
	private static final String SELECT_ALL_STUDENT = "SELECT * FROM student_0538";
	private static final String DELETE_STUDENT_SNO="DELETE FROM student_0538 WHERE sno=?";
	private static final String UPDATE_QRY_SNO="UPDATE student_0538 SET  sname=?,mail_id=?,marks1=?,marks2=?,marks3=? WHERE sno=?";
	@Autowired
	private JdbcTemplate jt;

	public int saveStudentDetails(StudentBO bo) {
		final String INSERT_QRY = "INSERT INTO student_0538 values(?,?,?,?,?,?)";
		System.out.println("DAO CLASS..........." + bo);
		int n = jt.update(INSERT_QRY, bo.getSno(), bo.getSname(), bo.getMailId(), bo.getMarks1(), bo.getMarks2(),
				bo.getMarks3());
		return n;
	}

	public StudentBO getBySno(Integer sno) {
		StudentBO bo = jt.queryForObject(SELECT_BY_SNO, new Object[] { sno },
				new BeanPropertyRowMapper(StudentBO.class));
		return bo;
	}

	public List<StudentBO> getAllStudent() {
		List<StudentBO> list = jt.query(SELECT_ALL_STUDENT, new BeanPropertyRowMapper(StudentBO.class));
		return list;
	}
	public int deleteById(Integer sno) {
		int result=jt.update(DELETE_STUDENT_SNO,sno);
		return result;
	}
	public int updateStudentBySno(StudentBO bo) {
		System.out.println("DAO Bo "+bo);
   int result=		jt.update(UPDATE_QRY_SNO,bo.getSname(),bo.getMailId(),bo.getMarks1(),bo.getMarks2(),bo.getMarks3(),bo.getSno());
	return result;
	}
}
