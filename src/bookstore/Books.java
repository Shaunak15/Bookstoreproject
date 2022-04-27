package bookstore;

public class Books {
	private String title;
	private String author;
	private String pages;
	private String publisher;
	private String numbooks;
	
	public Books(String title, String author, String pages, String publisher, String numbooks) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.publisher = publisher;
		this.numbooks = numbooks;
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

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getNumbooks() {
		return numbooks;
	}

	public void setNumbooks(String numbooks) {
		this.numbooks = numbooks;
	}
	
	
	
}
