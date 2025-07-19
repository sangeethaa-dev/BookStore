package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.*;
import com.example.bookstore.dao.*;



@Service
public class BookService {

	@Autowired
	BookResp r;
	//insert
	public Book get1(Book b)
	{
		return r.save(b);
	}
	//select all
	
	public List<Book> get2()
	{
		return r.findAll();
    }
	//particular select
	public Optional<Book> get3(Long id)
	{
		return r.findById(id);
	}
	//delete
	public void get4(Long id)
	{
		r.deleteById(id);
	}
	
	
	
	
}