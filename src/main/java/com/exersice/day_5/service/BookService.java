package com.exersice.day_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exersice.day_5.model.BookEntity;
import com.exersice.day_5.repository.BookRepository;


@Service
public class BookService {
	@Autowired
	BookRepository sr;
	
	public BookEntity saveinfo(BookEntity ss) {
		return sr.save(ss);
	}
	public List<BookEntity> savedetails(List<BookEntity> ss){
		return (List<BookEntity>)sr.saveAll(ss);
	}
	public List<BookEntity> showinfo(){
		return sr.findAll();
	}
	//get by id
	public Optional<BookEntity> showbyid(int id){
		return sr.findById(id);
	}
	
	public BookEntity changeinfo(BookEntity ss) {
		return sr.saveAndFlush(ss);
	}
	//update by id
	public String updateinfobyid(int id,BookEntity ss) {
		sr.saveAndFlush(ss);
		if(sr.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid id";
		}
	}
	public void deleteinfo(BookEntity ss) {
		sr.delete(ss);
	}
	//delete by pathvariable
	public void deleteid(int id) {
		sr.deleteById(id);
	}
}