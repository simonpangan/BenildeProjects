package Book;

public class BookChild {

	public static void main(String[] args) {
		BookInformation book1 = new BookInformation();
		BookInformation book2 = new BookInformation();
		
		
		book1.setBookTitle("Hit Refresh");
		book1.setAuthorFname("Satya");
		book1.setAuthorLname("Nadella");
		book1.setPublisher("Harper Business");
		book1.setIsbn("12345");
		book1.setCategory("Business");
		
		book1.getFullName();	
		System.out.println("Item 1: ");
		System.out.println();
		System.out.println("Book Title: " + book1.getBookTitle());
		System.out.println("Author First Name: " + book1.getAuthorFname());
		System.out.println("Author Last Name: " + book1.getAuthorLname());
		System.out.println("Publisher: " + book1.getPublisher());
		System.out.println("ISBN: " + book1.getIsbn());
		System.out.println("Category: " + book1.getCategory());
		System.out.println();
		System.out.println("Full Name: " + book1.getFullName());
		
		book2.setBookTitle("Strengths Finder");
		book2.setAuthorFname("Tom");
		book2.setAuthorLname("Rath");
		book2.setPublisher("Gallup Press");
		book2.setIsbn("67890");
		book2.setCategory("Leadership");
		
		book1.getFullName();	
		System.out.println();
		System.out.println("Item 2: ");
		System.out.println();
		System.out.println("Book Title: " + book2.getBookTitle());
		System.out.println("Author First Name: " + book2.getAuthorFname());
		System.out.println("Author Last Name: " + book2.getAuthorLname());
		System.out.println("Publisher: " +book2.getPublisher());
		System.out.println("ISBN: " + book2.getIsbn());
		System.out.println("Category: " + book2.getCategory());
		System.out.println();
		System.out.println("Full Name: " + book2.getFullName());
		
		
	}

}
