package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Book;

@Component
public class BookValidator implements Validator {

	//this validator is for book class
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Book.class);
	}
	//errors is a collection of error
	//1st object to be validated..here for book object, second is for errors (collection)
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "book.id.required", "Book ID is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "book.title.required", "Title is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "book.price.required", "Price is required!!!");
		Book b= (Book) obj;
		if(b.getPrice()<0) {
			errors.rejectValue("price", "Invalid.price", "Price should be greater than zero");
		}
	}

}
