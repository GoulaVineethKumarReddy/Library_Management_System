package com.Task;

public class Library {
	public Book[] books;
	private Member[] members;
	
	public Library() {
		books = new Book[10000];
		members = new Member[100];
	}
	
	public void addBookToLibrary(Book book) {
		for(int i=0;i<books.length;i++) {
			if(books[i]==null) {
				books[i] = book;
				return;
			}
		}
	}
	
	public void addMemberToLibrary(Member member) {
		for(int i=0;i<members.length;i++) {
			if(members[i]==null) {
				members[i] = member;
				return;
			}
		}
	}
	
	public void displayAvailableBooks() {
		System.out.println("\n===>Available Books : ");
		for(int i=0;i<books.length;i++) {
			if(books[i]!=null && books[i].isAvailable()) {
				System.out.println("    "+books[i]);
			}
		}
	}
	
	public void displayBorrowedBooks() {
		System.out.println("\nBorrowed Books : ");
		for(int i=0;i<books.length;i++) {
			if(books[i]!=null && !books[i].isAvailable()) {
				System.out.println("    "+books[i]);
			}
		}
	}
	
	public void borrowBookByMember(int memberID , int bookISBN) {
		for(int i=0;i<members.length;i++) {
			if(members[i]!=null && members[i].getID()==memberID) {
				for(int j=0;j<books.length;j++) {
					if(books[j]!=null && books[j].getISBN()==bookISBN) {
						if(books[j].isAvailable()) {
							members[i].borrows(books[j]);
							books[j].borrows();
							return;
						}
					}
				}
			}
		}
	}
	
	public void returnBookByMember(int memberID , int bookISBN) {
		for(int i=0;i<members.length;i++) {
			if(members[i]!=null && members[i].getID()==memberID) {
				for(int j=0;j<books.length;j++) {
					if(books[j]!=null && books[j].getISBN()==bookISBN) {
						if(!books[j].isAvailable()) {
							members[i].returns(books[j].getISBN());
							books[j].returns();
							return;
						}else {
							System.out.println("You can't return a book which isn't borrowed");
						}
					}
				}
			}
		}
		
	}
	
	public void displayMembersAndBooks() {
		System.out.println("\n====>All members and the books they borrowed : ");
		for(int i=0;i<members.length;i++) {
			if(members[i]!=null) {
				System.out.println(members[i]);
			}
		}
	}
	
}
