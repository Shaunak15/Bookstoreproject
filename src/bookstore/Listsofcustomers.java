package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Listsofcustomers {
	private String filepath1;
	private ArrayList<customers> allCustomers  = new ArrayList<customers>();

	public  Listsofcustomers (String filepath1) {
		this.setFilepath(filepath1);
	}
	
	public String getFilepath() {
		return filepath1;
	}
	
	public void setFilepath(String filepath1) {
		this.filepath1 = filepath1;
	}
	
	public ArrayList<customers> getAllCustomers() {
		return allCustomers;
	}

	public void setAllCustomers(ArrayList<customers> allCustomers) {
		this.allCustomers = allCustomers;
	}
	
	public void load () throws FileNotFoundException {
		
		File file = new File("customers.txt");
		Scanner in = new Scanner(file);
		
		while (in.hasNextLine()){
			Scanner in1 = new Scanner(in.nextLine());
			in1.useDelimiter("  ");
			
			String name ;
			String bookname;
			String email;
			
			assert in1.hasNext(); 
			name = in1.next();
			
			assert in1.hasNext(); 
			bookname = in1.next();
			
			assert in1.hasNext(); 
			email = in1.next();
			
			customers lc = new customers(name , bookname, email);
			getAllCustomers().add(lc);
		
		}
	}
		public void print() {
			for(int i =0; i < getAllCustomers().size() ; i++) {
				System.out.println("Name :" + getAllCustomers().get(i).getName());
				System.out.println("Bookname  :" + getAllCustomers().get(i).getBookname());	
				System.out.println("Email  :" + getAllCustomers().get(i).getEmail());
			}	
		}
}
