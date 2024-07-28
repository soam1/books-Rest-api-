package com.akashsoam.bootJpaExample.entity;


//import jakarta.annotation.*;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;
	private String name;
	
	@OneToOne(cascade	= CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Book() {
		super();
	}

	public Book(int id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

//	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@XmlElement
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author.getName() + "]";
	}
}
