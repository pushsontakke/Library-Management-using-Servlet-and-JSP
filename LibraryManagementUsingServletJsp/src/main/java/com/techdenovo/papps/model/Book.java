package com.techdenovo.papps.model;

public class Book {
	private long id;
	private String bookName;
	private String authorName;
	private String isbn;
	
	public Book() {}
	
	public Book(long id, String bookName, String authorName, String isbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", isbn=" + isbn + "]";
	}
	
	
	
}
