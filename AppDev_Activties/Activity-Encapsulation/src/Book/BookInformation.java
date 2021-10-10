package Book;

public class BookInformation {
	private String bookTitle;
	private String authorFname;
	private String authorLname;
	private String publisher;
	private String isbn;
	private String category;
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorFname() {
		return authorFname;
	}
	public void setAuthorFname(String authorFname) {
		this.authorFname = authorFname;
	}
	public String getAuthorLname() {
		return authorLname;
	}
	public void setAuthorLname(String authorLname) {
		this.authorLname = authorLname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String  getFullName() {
		return authorFname + " "+ authorLname;
		
	}

	
	
}
