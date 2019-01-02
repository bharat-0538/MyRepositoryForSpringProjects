package com.itc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itc.bo.StudentBO;

public class StudentRowMapper  implements RowMapper<StudentBO>{

	public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentBO bo=new StudentBO();
		bo.setSno(rs.getInt(1));
		bo.setSname(rs.getString(2));
		bo.setMailId(rs.getString(3));
		bo.setMarks1(rs.getString(4));
		bo.setMarks2(rs.getString(5));
		bo.setMarks3(rs.getString(6));
		return bo;
	}
}
