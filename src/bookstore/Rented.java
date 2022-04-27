package bookstore;

public class Rented {
	String lastname;
	String bookname;
	String author;
	public  Rented(String lastname, String bookname, String author) {
		this.lastname = lastname;
		this.bookname = bookname;
		this.author = author;
	}

	public String getlastName() {
		return lastname;
	}

	public void setlastName(String lastname) {
		this.lastname = lastname;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
}
