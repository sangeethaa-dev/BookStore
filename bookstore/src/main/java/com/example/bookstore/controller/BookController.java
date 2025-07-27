package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.service.*;
import com.example.bookstore.model.*;



@RestController
@RequestMapping("/api/books")

public class BookController {

@Autowired
BookService s;


@GetMapping
public List<Book> besant1()
{
	return s.get2();
}
@PostMapping
public ResponseEntity<Book> besant2(@RequestBody Book b)
{
	
	Book b1=s.get1(b);
	return ResponseEntity.status(HttpStatus.CREATED).body(b1);
}

@GetMapping("/{id}")
public ResponseEntity<Book> besant3(@PathVariable Long id) {
    Optional<Book> b = s.get3(id);
    return b.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> besant4(@PathVariable Long id) {
    if (!s.get3(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    s.get4(id);
    return ResponseEntity.noContent().build();
}

@PutMapping("/{id}")
public ResponseEntity<Book> besant5(@PathVariable Long id, @RequestBody Book book) {
    if (!s.get3(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    book.setId(id);
    Book ub = s.get1(book);
    return ResponseEntity.ok(ub);
}







	
	
	
}
