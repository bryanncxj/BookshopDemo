package com.example.demo.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Book {
	
	@Id
	private Long isbn;
	
	private String title;
	
	private String author;
	
	public Book() {
		
	}
	
	public Book(Long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	public Long getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
//	@Override
//    public boolean equals(Object o) {
//		if (this == o) {
//			return true;
//		}
//		if (!(o instanceof Book)) {
//            return false;
//        }
//		return id != null && id.equals(((Book) o).id);
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.isbn, this.title, this.author);
//	}
	
	@Override
	public String toString() {
		return "Book{" +
                "isbn=" + this.isbn +
                ", title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                '}';
	}

}
