package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Address;
import com.visa.prj.entity.Book;

@Controller
public class BookController {

	@Autowired
	private BookValidator validator;

	// modelandview can also be used
	@RequestMapping("bookform.do")
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "bookform.jsp";
	}

	@RequestMapping("addBook.do")
	public String addBook(@ModelAttribute("book") Book b, BindingResult errors) {
		// errors will be added into the collection
		validator.validate(b, errors);
		if (errors.hasErrors()) {
			return "bookform.jsp";
		} else {
			System.out.println(b.getTitle());
			System.out.println(b.getPrice());
			System.out.println(b.getCategory());
			System.out.println(b.getPublishedDate());
			System.out.println(b.getPublisherAddress().getStreet());
			System.out.println(b.getPublisherAddress().getCity());
			return "redirect:index.jsp";
		}
	}

	// we need to tell spring if string needs to be converted into date then this
	// must be done
	@InitBinder
	public void registerBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		binder.registerCustomEditor(Address.class, new AddressPropertyEditor());
	}
}
