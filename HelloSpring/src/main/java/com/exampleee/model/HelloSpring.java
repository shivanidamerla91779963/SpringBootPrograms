package com.exampleee.model;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class HelloSpring {

	
	Date d=new Date();
	@GetMapping("/msg")
	public String hello()
	{
		return "hello shivani welcome to springboot";
	}
	@GetMapping("/date")
	public Date dateEx()
	{
		return d;
	}
	@GetMapping("/localdate")
	public String displayDate()
	{
		LocalDate d=LocalDate.now();
		DateTimeFormatter d1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String s1=d1.format(d);
		return s1;
	}
}

