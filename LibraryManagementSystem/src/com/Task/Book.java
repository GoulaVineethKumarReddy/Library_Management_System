package com.Task;

public class Book {
	private String title;
	private String author;
	private int ISBN;
	private boolean isAvailable;
	
	public Book(String title, String author, int iSBN) {
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.isAvailable = true;
	}
	
	public void borrows() {
		isAvailable = false;
	}
	public String getTitle() {
		return title;
	}

	public void returns() {
		isAvailable = true;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public int getISBN() {
		return ISBN;
	}
	@Override
	public String toString() {
		return this.title+" by "+this.author+" ("+this.ISBN+")";
	}
}
