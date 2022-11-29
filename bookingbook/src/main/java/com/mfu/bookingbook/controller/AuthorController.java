package com.mfu.bookingbook.controller;

import com.mfu.bookingbook.repository.*;
import com.mfu.bookingbook.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

	@Autowired
	private AuthorRepository AuthorRepo;

	@GetMapping("/getAllAuthors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		try {
			List<Author> AuthorList = new ArrayList<>();
			AuthorRepo.findAll().forEach(AuthorList::add);

			if (AuthorList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(AuthorList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAuthorById/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
		Optional<Author> AuthorData = AuthorRepo.findById(id);

		if (AuthorData.isPresent()) {
			return new ResponseEntity<>(AuthorData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author authorObj = AuthorRepo.save(author);

		return new ResponseEntity<>(authorObj, HttpStatus.CREATED);
	}

	@PutMapping("/updateAuthorById/{id}")
	public ResponseEntity<Author> updateAuthorById(@PathVariable Long id, @RequestBody Author newAuthorData) {
		Optional<Author> oldAuthorData = AuthorRepo.findById(id);

		if (oldAuthorData.isPresent()) {
			Author updatedAuthorData = oldAuthorData.get();
			updatedAuthorData.setName(newAuthorData.getName());

			Author authorObj = AuthorRepo.save(updatedAuthorData);
			return new ResponseEntity<>(authorObj, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteAuthorById/{id}")
	public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable Long id) {
		try {
			AuthorRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}