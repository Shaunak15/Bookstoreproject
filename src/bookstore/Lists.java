package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Lists {
	private String filepath;
	private ArrayList<Books> allBooks  = new ArrayList<Books>();
	
	
	public Lists (String filepath) {
		this.setFilepath(filepath);
	
	}
	public ArrayList<Books> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(ArrayList<Books> allBooks) {
		this.allBooks = allBooks;
	}
	
	public String getFilepath() {
		return filepath;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public void load () throws FileNotFoundException {
		
		File file = new File("books.txt");
		Scanner in = new Scanner(file);
		
		while (in.hasNextLine()){
			Scanner in1 = new Scanner(in.nextLine());
			in1.useDelimiter("  ");
			
			String title ;
			String author = null;
			String publisher = null;
			String pages  ;
			String numbooks ;
			
			assert in1.hasNext(); 
			title = in1.next();
			
			assert in1.hasNext(); 
			author = in1.next();
			
			assert in1.hasNext();
     		pages = in1.next();
			
			assert in1.hasNext();
			publisher = in1.next();

			assert in1.hasNext();
			numbooks = in1.next();
			
			Books bsBooks = new Books(title, author, pages , publisher, numbooks);
			getAllBooks().add(bsBooks);
			
		
		}
	}
		public void print() {
			for(int i =0; i < getAllBooks().size() ; i++) {
				System.out.println("Title :" + getAllBooks().get(i).getTitle());
				System.out.println("Author  :" + getAllBooks().get(i).getAuthor());
				System.out.println("pages :" + getAllBooks().get(i).getPages());
				System.out.println("publisher :" + getAllBooks().get(i).getPublisher());
				System.out.println("number of books :" + getAllBooks().get(i).getNumbooks());
			}
			
		}
	


		
	}

