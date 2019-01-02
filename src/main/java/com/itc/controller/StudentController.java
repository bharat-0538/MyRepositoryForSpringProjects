package com.itc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itc.dto.StudentDTO;
import com.itc.service.StudentService;
import com.itc.vo.StudentVO;

@Controller
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping(value = "index.htm")
	public ModelAndView form() {
		System.out.println("first method........!!!!!!!");
		return new ModelAndView("form", "command", new StudentVO());
	}

	@RequestMapping(value = "form.htm", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("vo") StudentVO vo, Model model) {
		System.out.println("Controller" + vo);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(vo, dto);
		String msg = service.saveStudent(dto);
		System.out.println("message passing for confirmation of adding data");
		model.addAttribute("msg", msg);
		return new ModelAndView("form", "command", vo);
	}
	@RequestMapping(value = "selectAll.htm")
	public ModelAndView selectAll() {
		List list=service.selectAll(); 
		System.out.println("select Data....."+list);   
		return new ModelAndView("selectAll","list",list);
	}
	@RequestMapping(value="select.htm")
	public ModelAndView selectBysno(HttpServletRequest req,Model model) {
		Integer sno=Integer.parseInt(req.getParameter("sno"));
		StudentVO vo=new StudentVO();
		StudentDTO dto=service.selectBySno(sno);
		BeanUtils.copyProperties(dto, vo);
		model.addAttribute("vo", vo);
		return new ModelAndView("form","command",new StudentVO());
	}
	@RequestMapping(value="delete.htm/{sno1}",method=RequestMethod.GET)
	public ModelAndView deleteStudentBySno(@PathVariable int sno1) {
		//int sno=Integer.parseInt(sno1);
		String msg=service.deleteBySno(sno1);
		List list=service.selectAll(); 
		return new ModelAndView("selectAll","list",list);
	}
	/*@RequestMapping(value="csv.htm")
	public ModelAndView csv() {
		
		return new ModelAndView("csv");
	}*/
	@RequestMapping(value="edit.htm/{sno}")
	public ModelAndView edit(@PathVariable int sno) {
		StudentDTO dto=service.selectBySno(sno);
		System.out.println("Edit Method Returned DTO"+dto);
		StudentVO vo=new StudentVO();
		BeanUtils.copyProperties(dto, vo);
		return new ModelAndView("editForm","command",vo);
	}
	@RequestMapping(value="save.htm")
	public ModelAndView upadte(@ModelAttribute("vo")StudentVO vo) {
		System.out.println("Again update save Vo"+vo);
		StudentDTO dto=new StudentDTO();
		BeanUtils.copyProperties(vo, dto);
		String msg=service.updateStudent(dto);
		System.out.println(msg);
		List list=service.selectAll(); 
		return new ModelAndView("selectAll","list",list);
	}
}
