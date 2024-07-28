package com.akashsoam.bootJpaExample.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "authors")
public class Author {

	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
	@jakarta.persistence.Column(name = "author_id")
	private int id;
	private String name;
    private String language;
    
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;
    
    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author() {
    	super();
    }
    
	public Author(int id, String name, String language, Book book) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.book = book;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", language=" + language + ", book=" + book +"]";
	}
}
