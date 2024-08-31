package com.curso.v0.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="editorial")
    private String editorial;

    @Column(name="author")
    private String author;
    
    @Column(name="place_of_origin")
    private String place_of_origin;
    
    @Column(name="price")
    private double price;

    // define constructors
    public Book() {

    }

	public Book(String title, String editorial, String author, String place_of_origin, double d) {
		this.title = title;
		this.editorial = editorial;
		this.author = author;
		this.place_of_origin = place_of_origin;
		this.price = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPlace_of_origin() {
		return place_of_origin;
	}

	public void setPlace_of_origin(String place_of_origin) {
		this.place_of_origin = place_of_origin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", editorial=" + editorial + ", author=" + author
				+ ", place_of_origin=" + place_of_origin + ", price=" + price + "]";
	}
}
