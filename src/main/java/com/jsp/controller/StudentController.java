package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/studentload")
	public ModelAndView loadme() {
		ModelAndView modelAndView = new ModelAndView("StudentSave.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
	}

	@RequestMapping("/studentsave")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		studentService.create(student);
		ModelAndView modelAndView = new ModelAndView("HOME.jsp");
		modelAndView.addObject("save", student.getName() + " saved sucessfully");
		return modelAndView;

	}

	@RequestMapping("/viewAllStudents")
	public ModelAndView viewAll() {
		List<Student> students = studentService.readAllStudents();
		ModelAndView modelAndView = new ModelAndView("ViewAllStudents.jsp");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView updateById(@RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("UpdateStudent.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping("/studentupdated")
	public ModelAndView updatedFinally(@ModelAttribute Student student) {
		studentService.update(student, student.getId());
		ModelAndView modelAndView = new ModelAndView("HOME.jsp");
		modelAndView.addObject("updated", "student " + student.getId() + " updated");
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteById(@RequestParam(name = "id") int id) {
		studentService.delete(id);
		ModelAndView modelAndView = new ModelAndView("DeleteStudent.jsp");
		modelAndView.addObject("deleted", "student with " + id + " deleted");
		return modelAndView;
	}
}
