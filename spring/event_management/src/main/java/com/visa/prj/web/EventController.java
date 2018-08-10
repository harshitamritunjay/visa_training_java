package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.visa.prj.entity.Event;
import com.visa.prj.service.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventservice;
	
	@RequestMapping("eventform.do")
	String getEventForm(Model model) {
		model.addAttribute("event", new Event(0,"EVENT NAME",new Date(),"Bangalore"));
		return "eventForm.jsp";
	}
	
	@RequestMapping("addEvent.do")
	public String addEvent(@ModelAttribute("event") Event event, BindingResult errors, Model model) {
		eventservice.addEvent(event);
		//model.addAttribute("msg","Event added successfully!!!");
		return "index.jsp?msg=Event Added Successfully";
	}
	
	@RequestMapping("eventRegisterForm.do")
	public String getRegistrationForm(Model model) {
		model.addAttribute("events", eventservice.getOpenEvents());
		return "register.jsp";
	}
	
	@RequestMapping("register.do")
	public String register(HttpServletRequest req) {
		//we want only two paramaters from UI i.e primitives, hence is obtained one by one rather than using dto(object) 
		String email = req.getParameter("email");
		String evt= req.getParameter("evt");
		eventservice.register(email,evt);
		return "index.jsp?msg=Registration Successfull!!!";
	}
	@InitBinder
	public void registerBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
}
