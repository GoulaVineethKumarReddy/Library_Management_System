package com.Task;

import java.util.Scanner;

public class LibraryApp extends Library{
	
	private void printInstructions() 
	{
		System.out.println("\nPlease select the operation you want to excecute : \n"
				+ "==> 0 : To exit \n"
				+ "==> 1 : To add a book to the Library \n"
				+ "==> 2 : To display all available Books \n"
				+ "==> 3 : To display all borrowed Books \n"
				+ "==> 4 : To borrow a book \n"
				+ "==> 5 : To return a book \n"
				+ "==> 6 : Display all members and the books borrowed by them \n");
	}
	
	private  void start()
	{
		Scanner scan = new Scanner(System.in);
		for(;;) {
			this.printInstructions();
			System.out.print("Command: ");
			int command = Integer.parseInt(scan.nextLine());
			if(command == 0) {
				System.out.println("You have selected to exit the app");
				System.out.println("Exciting the app....");
				break;
			}
			else if(command == 1) {
				System.out.println("You have selected to add a book to the library.");
				System.out.print("\nTitle :");
				String bookTitle = scan.nextLine().trim();
				System.out.print("Author :");
				String bookAuthor = scan.nextLine().trim();
				System.out.print("ISBN number :");
				int bookISBN = Integer.parseInt(scan.nextLine().trim());
				Book newBook = new Book(bookTitle,bookAuthor,bookISBN);
				this.addBookToLibrary(newBook);
			}
			else if(command == 2) {
				System.out.println("You have selected to view the list of books currently available in library");
				this.displayAvailableBooks();
			}
			else if(command == 3) {
				System.out.println("\nYou have selected to view the books borrowed from the Library");
				this.displayBorrowedBooks();
			}
			else if(command == 4) {
				System.out.println("You have selected to borrow a book from Library");
				System.out.println("Select 1 for new member \nSelect 2 if you are already a member");
				int input = Integer.parseInt(scan.nextLine());
				int memberID = -1;
				if(input == 1) {
					System.out.print("\nName: ");
					String memberName = scan.nextLine().trim();
					System.out.print("ID: ");
					memberID = Integer.parseInt(scan.nextLine());
					Member newMember = new Member(memberName,memberID);
					this.addMemberToLibrary(newMember); 
				}else {
					System.out.print("ID: ");
					memberID = Integer.parseInt(scan.nextLine());
				}
				System.out.println("Which Book do you want?");
				System.out.print("Enter Book ISBN number :");
				int borrowingBookISBN = Integer.parseInt(scan.nextLine());
				this.borrowBookByMember(memberID, borrowingBookISBN);
			}
			else if(command == 5) {
				System.out.println("You have selected to return book to the Library");
				System.out.print("Enter your ID : ");
				int memberID = Integer.parseInt(scan.nextLine());
				System.out.print("Enter book ISBN number : ");
				int returningBookISBN = Integer.parseInt(scan.nextLine());
				this.returnBookByMember(memberID, returningBookISBN);
			}
			else if(command == 6) {
				System.out.println("You have selected to view the all members and the books borrowed by them");
				this.displayMembersAndBooks();
			}
			else {
				System.out.println("Wrong operation , Try again");
			}
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		System.out.println("--x-- Welcome to my Library Management System --x--");
		LibraryApp libraryApp = new LibraryApp();
		//creating 6 books
		Book book1 = new Book("Java","Java-sir",1);
		Book book2 = new Book("Oracle","Oracle-sir",2);
		Book book3 = new Book("HTML","HTML-sir",3);
		Book book4 = new Book("CSS","CSS-sir",4);
		Book book5 = new Book("JavaScript","JavaScript-sir",5);
		Book book6 = new Book("PL/SQL","PL/SQL-sir",6);
		//adding 6 books to library
		libraryApp.addBookToLibrary(book1);  libraryApp.addBookToLibrary(book2);
		libraryApp.addBookToLibrary(book3);  libraryApp.addBookToLibrary(book4);
		libraryApp.addBookToLibrary(book5);  libraryApp.addBookToLibrary(book6);
		
		//creating 2 members
		Member member1 = new Member("V",1001);
		Member member2 = new Member("P",1002);
		//adding 2 members to library
		libraryApp.addMemberToLibrary(member1);
		libraryApp.addMemberToLibrary(member2);
		
		//displaying available books in library
		libraryApp.displayAvailableBooks();
		System.out.println();
		
		//displaying borrowed books in library
		libraryApp.displayBorrowedBooks();
		System.out.println();
		
		libraryApp.displayMembersAndBooks();
			
		//allowing a member to borrow a book
		libraryApp.borrowBookByMember(1001, 1);
		libraryApp.borrowBookByMember(1002, 2);
		libraryApp.borrowBookByMember(1001, 3);
		libraryApp.borrowBookByMember(1002, 5);
		
		libraryApp.displayMembersAndBooks();
		
		//allowing a member to return a book
		libraryApp.returnBookByMember(1001, 1);
		libraryApp.returnBookByMember(1002, 5);
		
		//all members and books they borrowed
		libraryApp.displayMembersAndBooks();
	}
}
