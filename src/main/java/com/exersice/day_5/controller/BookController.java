package com.exersice.day_5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exersice.day_5.model.BookEntity;
import com.exersice.day_5.service.BookService;
@RestController
public class BookController {
	@Autowired
	BookService sser;
	@PostMapping("addstudent")
	public BookEntity add(@RequestBody BookEntity ss) {
		return sser.saveinfo(ss);
	}
	@PostMapping("addnstudent")
	public List<BookEntity> addndetails(@RequestBody List<BookEntity> ss){
		return sser.savedetails(ss);
	}
	
	@GetMapping("showdetails")
	public List<BookEntity> show(){
		return sser.showinfo();
		
	}
	//show by id
	@GetMapping("showdetbyid/{id}")
		public Optional<BookEntity> showid(@PathVariable int id){
			return sser.showbyid(id);
		}
	
	@PutMapping("update")
	public BookEntity modify(@RequestBody BookEntity ss ) {
		return sser.changeinfo(ss);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody BookEntity ss) {
		return sser.updateinfobyid(id,ss);
	}
	@DeleteMapping("deletedetail")
		public String del(@RequestBody BookEntity ss) {
			sser.deleteinfo(ss);
			return "Deleted successfully";
		}
	//pathvariable example
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id) {
		sser.deleteid(id);
	}
}