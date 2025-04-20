package com.Task;

public class Member {
	private String name;
	private int ID;
	private Book[] borrowedBooks;
	
	public Member(String name, int iD) {
		this.name = name;
		ID = iD;
		borrowedBooks = new Book[100];
	}
	
	public int getID() {
		return ID;
	}
	
	public void borrows(Book book) {
		for(int i=0;i<borrowedBooks.length;i++) {
			if(borrowedBooks[i]==null) {
				borrowedBooks[i] = book;
				System.out.println(this.name +" has borrowed "+book.getTitle()+" from library.");
				return;
			}
		}
	}
	
	public Book returns(int isbn) {
		for(int i=0;i<borrowedBooks.length;i++) {
			if(borrowedBooks[i]!=null &&  borrowedBooks[i].getISBN()==isbn) {
				Book book = borrowedBooks[i];
				borrowedBooks[i] = null;
				System.out.println(this.name+" has returned "+book.getTitle()+" to library.");
 				return book;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String list = "";
		for(int i=0;i<borrowedBooks.length;i++) {
			if(borrowedBooks[i]!=null) {
				list +="     "+borrowedBooks[i]+"\n";
			}
		}
		String member = "---->"+this.name+"("+this.ID+")\n"+list;
		return member;
	}
}