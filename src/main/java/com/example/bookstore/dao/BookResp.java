package com.example.bookstore.dao;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bookstore.model.*;
public interface BookResp extends JpaRepository<Book,Long>{

}