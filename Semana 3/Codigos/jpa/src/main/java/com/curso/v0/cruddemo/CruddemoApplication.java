package com.curso.v0.cruddemo;

import com.curso.v0.dao.BookDAO;
import com.curso.v0.entity.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

// Searches for the elements and entities in the designated packages
@SpringBootApplication(scanBasePackages = "com.curso.v0")
@EntityScan(basePackages = "com.curso.v0.entity")
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Testing of all methods
	@Bean
	public CommandLineRunner commandLineRunner(BookDAO bookDAO) {

		return runner -> {
			createBook(bookDAO);

			createMultipleBooks(bookDAO);

			readBook(bookDAO);

			updateBook(bookDAO);

			queryForBooks(bookDAO);

			queryForBooksByAuthor(bookDAO);

//			deleteBook(bookDAO);
//
//			deleteAllBooks(bookDAO);
		};
	}

	// Deletes all records on the table
	private void deleteAllBooks(BookDAO bookDAO) {

		System.out.println("Deleting all books");
		int numRowsDeleted = bookDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
		
	}

	// Deletes the specified book record
	private void deleteBook(BookDAO bookDAO) {

		int bookId = 1;
		System.out.println("Deleting book id: " + bookId);
		bookDAO.delete(bookId);
	}

	// Changes the author of a specific book based on id
	private void updateBook(BookDAO bookDAO) {

		int bookId = 4;
		System.out.println("Getting book with id: " + bookId);
		Book myBook = bookDAO.findById(bookId);

		// change author to "John Doe"
		System.out.println("Updating book ...");
		myBook.setAuthor("John Doe");
		
		bookDAO.update(myBook);

		// display the updated student
		System.out.println("Updated book: " + myBook);
	}

	// Gets the books of a specific author
	private void queryForBooksByAuthor(BookDAO studentDAO) {

		System.out.println("Find by author: John Doe");
		List<Book> theBooks = studentDAO.findByAuthor("John Doe");

		for (Book tempBook : theBooks) {
			System.out.println(tempBook);
		}
	}

	// Gets all the books
	private void queryForBooks(BookDAO bookDAO) {

		List<Book> theBooks = bookDAO.findAll();

		for (Book tempBook : theBooks) {
			System.out.println(tempBook);
		}
	}

	// Creates and looks for a new book
	private void readBook(BookDAO bookDAO) {

		System.out.println("Creating new book object ...");
		Book tempBook = new Book("The Quantum Computer Revolution", "FutureTech", "Daniel Kim", "San Francisco", 89.99);

		System.out.println("Saving the book ...");
		bookDAO.save(tempBook);

		int theId = tempBook.getId();
		System.out.println("Saved book. Generated id: " + theId);

		System.out.println("Retrieving book with id: " + theId);
		Book myBook = bookDAO.findById(theId);

		System.out.println("Found the student: " + myBook);
	}

	// Creates and saves multiple book records
	private void createMultipleBooks(BookDAO bookDAO) {

		System.out.println("Creating 3 book objects ...");
		Book tempBook1 = new Book("Computer Networks", "NetBooks Publishing", "Tom Harris", "Denver", 52.45);
		Book tempBook2 = new Book("Artificial Intelligence Fundamentals", "AI Press", "Laura Lee", "Seattle", 78.60);
		Book tempBook3 = new Book("The Quantum Computer Revolution", "FutureTech", "Daniel Kim", "San Francisco", 89.99);

		System.out.println("Saving the books ...");
		bookDAO.save(tempBook1);
		bookDAO.save(tempBook2);
		bookDAO.save(tempBook3);
	}

	// Creates a single instance of a book
	private void createBook(BookDAO bookDao) {

		System.out.println("Creating new book object ...");
		Book tempBook = new Book("Data Structures and Algorithms", "TechKnowledge", "Nancy Adams", "San Jose", 67.30);

		System.out.println("Saving the student ...");
		bookDao.save(tempBook);

		System.out.println("Saved student. Generated id: " + tempBook.getId());
	}
}







