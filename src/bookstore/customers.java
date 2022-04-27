package bookstore;

public class customers {
	String name;
	String bookname;
	String email;
	
	public customers(String name, String bookname, String email) {
		this.name = name;
		this.bookname = bookname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

}
