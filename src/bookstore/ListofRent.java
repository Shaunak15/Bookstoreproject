package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListofRent {
	private String filepath1;
	private ArrayList<Rented> allrentCustomers  = new ArrayList<Rented>();

	public  ListofRent (String filepath1) {
		this.setFilepath(filepath1);
	}

	public String getFilepath() {
		return filepath1;
	}

	public void setFilepath(String filepath1) {
		this.filepath1 = filepath1;
	}

	public ArrayList<Rented> getAllrentCustomers() {
		return allrentCustomers;
	}

	public void setAllrentCustomers(ArrayList<Rented> allrentCustomers) {
		this.allrentCustomers = allrentCustomers;
	}

	public void load () throws FileNotFoundException {

		File file = new File("Rented.txt");
		Scanner in = new Scanner(file);
		
		while (in.hasNextLine()) {
			 Scanner in1 = new Scanner(in.nextLine());
				in1.useDelimiter("  ");

			String lastname ;
			String bookname;
			String author;

			assert in1.hasNext(); 
			lastname = in1.next();

			assert in1.hasNext(); 
			bookname = in1.next();

			assert in1.hasNext(); 
			author = in1.next();


			Rented rd = new Rented(lastname , bookname, author);
			getAllrentCustomers().add(rd);
		}
	}


	public void print() {
		for(int i =0; i < getAllrentCustomers().size() ; i++) {
			System.out.println("Name :" + getAllrentCustomers().get(i).getlastName());
			System.out.println("Bookname  :" + getAllrentCustomers().get(i).getBookname());	
			System.out.println("author  :" + getAllrentCustomers().get(i).getauthor());
		}	
	}



}

