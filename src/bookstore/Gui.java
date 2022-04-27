package bookstore;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


class Gui implements ActionListener {

	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JTextArea t = new JTextArea();
	FileWriter  fWriter;
	JScrollPane scroll = new JScrollPane(t);
	
	Gui() throws IOException {

		JFrame frame= new JFrame();
		frame.setLayout(null);
		frame.setSize(1500,1500);
		frame.setTitle("BookStore");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.DARK_GRAY);

		//background image
		ImageIcon image = new ImageIcon(ImageIO.read(new File("books.jpg")));
		JLabel jl = new JLabel(image);
		frame.setContentPane(jl);

		b1 = new JButton("List of Books");
		b2 = new JButton("Number Of Customers");
		b3 = new JButton("Rented Books");
		b4 = new JButton("Do You want to rent ?");
		b5 = new JButton("Search a Customer ?");
		b6 = new JButton("Search a Book ?");
		b7 = new JButton("Add a Customer?");
		b8 = new JButton("Add a Book ?");

		//font of textarea and buttons
		Font font = new Font("Georgia", Font.BOLD, 15);
		t.setFont(font);
		t.setForeground(Color.blue);

		//adding font to buttons
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		b6.setFont(font);
		b7.setFont(font);
		b8.setFont(font);

		scroll.setBounds(700, 180, 400, 450);
		b1.setBounds(350,180,190,40);
		b2.setBounds(350,240,190,40);
		b3.setBounds(350,300,190,40);
		b4.setBounds(350,360,190, 40);
		b5.setBounds(350,420,190, 40);
		b6.setBounds(350,480,190, 40);
		b7.setBounds(350,540,190, 40);
		b8.setBounds(350,600,190, 40);

		frame.add(scroll);
		t.setBackground(Color.getHSBColor(160,99, 255));
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		frame.add(b7);
		frame.add(b8);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {

		Lists ls = new Lists("books.txt");
		try {
			ls.load();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		if (e.getSource()== b1) {
			ArrayList<String> bkArrayList = new ArrayList<String>();

			for (Books bs : ls.getAllBooks()) {
				bkArrayList.add("Title: "+ bs.getTitle()+"\n");
				bkArrayList.add("Author: "+ bs.getAuthor()+ "\n");
				bkArrayList.add("Pages: " +bs.getPages() +"\n");
				bkArrayList.add("Publisher: " + bs.getPublisher() + "\n");
				bkArrayList.add("Number of books: "+bs.getNumbooks() + "\n");	
			}
			StringBuilder s = new StringBuilder("\n");
			int j=0;
			for(int x= 0; x< bkArrayList.size() ; x+=5) {
				j+= 1;
				s.append("Book : " + j + " "+ "\n" + bkArrayList.get(x));
				s.append(bkArrayList.get(x+1));
				s.append(bkArrayList.get(x+2));
				s.append(bkArrayList.get(x+3));
				s.append(bkArrayList.get(x+4));
				s.append("\n");
			}
			t.setText(s.toString());
		}

		Listsofcustomers loc = new Listsofcustomers("customers.txt");
		try {
			loc.load();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		if (e.getSource()== b2) {
			ArrayList<String> lcArrayList = new ArrayList<String>();

			for (customers cs : loc.getAllCustomers()) {
				lcArrayList.add("Name: "+ cs.getName()+"\n");
				lcArrayList.add("Bookname: "+ cs.getBookname()+ "\n");
				lcArrayList.add("email: " + cs.getEmail() +"\n");
			}

			StringBuilder h = new StringBuilder("\n");
			int k=0;
			for(int y= 0; y< lcArrayList.size() ; y+=3) {

				k+= 1;
				h.append( k + ")" + " " + lcArrayList.get(y));
				h.append(lcArrayList.get(y+1));
				h.append(lcArrayList.get(y+2));
				h.append("\n");
			}
			t.setText(h.toString());
		}

		ListofRent lor = new ListofRent("Rented.txt");
		try {
			lor.load();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ArrayList<String> rdArrayList = new ArrayList<String>();
		if (e.getSource() == b3) {

			for (Rented rd : lor.getAllrentCustomers()) {
				rdArrayList.add( rd.getlastName()+"\n");
				rdArrayList.add("Bookname: "+ rd.getBookname()+ "\n");
				rdArrayList.add("Author: " + rd.getauthor() +"\n");
			}

			StringBuilder p = new StringBuilder("\n");
			int l=0;
			for(int z= 0; z< rdArrayList.size() ; z+=3) {

				l+= 1;
				p.append( l + ") " + "lastname" + " " + rdArrayList.get(z));
				p.append(rdArrayList.get(z+1));
				p.append(rdArrayList.get(z+2));
				p.append("\n");
			}
			t.setText(p.toString());
		}

		ArrayList<String> rentbookArrayList = new ArrayList<String>();
		if (e.getSource()== b4) {

			String lastname = JOptionPane.showInputDialog(null,"Enter lastname of the customer :");
			String bookname = JOptionPane.showInputDialog(null,"Enter name of the book :");
			String author = JOptionPane.showInputDialog(null,"Enter author of the book :"); 

			rentbookArrayList.add((lastname));
			rentbookArrayList.add((bookname));
			rentbookArrayList.add((author) );

			StringBuilder m = new StringBuilder("\n");
			int l=0;
			for(int z= 0; z< rentbookArrayList.size() ; z+=3) {
				l+= 1;
				m.append( l + ") " + "Lastname :" + " " +rentbookArrayList.get(z) + "\n");
				m.append("Book :" + " " + rentbookArrayList.get(z+1)+ "\n");
				m.append("Author :" + " " + rentbookArrayList.get(z+2)+ "\n");
				m.append("\n");
			}
			t.setText(m.toString());
			try {
				fWriter = new FileWriter("Rented.txt", true);
				if (rentbookArrayList.get(0) != null && rentbookArrayList.get(1) != null && rentbookArrayList.get(2) != null) {
					fWriter.append("\n" + rentbookArrayList.get(0) +"  " +
							rentbookArrayList.get(1)+ "  " + rentbookArrayList.get(2));
				}
				fWriter.close();
			}
			catch (IOException e2) {
				System.out.println("catch happened");
				e2.printStackTrace();
			}
		}

		if (e.getSource()== b5) {
			ArrayList<String> searchArrayList = new ArrayList<String>();

			String name = JOptionPane.showInputDialog(null,"Enter name of the customer :");

			if (!name.equals(null)) {
				if(name.equals("Shaunak Patel") ) {
					searchArrayList.add(loc.getAllCustomers().get(0).getName().toString() + "\n");
					searchArrayList.add(loc.getAllCustomers().get(0).getBookname().toString()+ "\n");
					searchArrayList.add(loc.getAllCustomers().get(0).getEmail().toString()+ "\n");
				}
				else if(name.equals("John Parker") ) {
					searchArrayList.add(loc.getAllCustomers().get(1).getName().toString() + "\n");
					searchArrayList.add(loc.getAllCustomers().get(1).getBookname().toString()+ "\n");
					searchArrayList.add(loc.getAllCustomers().get(1).getEmail().toString()+ "\n");
				}
				else if(name.equals("Jill Aniston") ) {
					searchArrayList.add(loc.getAllCustomers().get(2).getName().toString() + "\n");
					searchArrayList.add(loc.getAllCustomers().get(2).getBookname().toString()+ "\n");
					searchArrayList.add(loc.getAllCustomers().get(2).getEmail().toString()+ "\n");
				}
				else if(name.equals("Peter Stone") ) {
					searchArrayList.add(loc.getAllCustomers().get(3).getName().toString() + "\n");
					searchArrayList.add(loc.getAllCustomers().get(3).getBookname().toString()+ "\n");
					searchArrayList.add(loc.getAllCustomers().get(3).getEmail().toString()+ "\n");
				}
				else if  (!"Shaunak Patel".equals(name) ) {
					String name1 = JOptionPane.showInputDialog(null,"There is no customer of that name or you might Spell the name of the"
							+ " customer name wrong" + "\n"+ "Please enter the name again :");
					if(name1.equals("Shaunak Patel") ) {
						searchArrayList.add(loc.getAllCustomers().get(0).getName().toString() + "\n");
						searchArrayList.add(loc.getAllCustomers().get(0).getBookname().toString()+ "\n");
						searchArrayList.add(loc.getAllCustomers().get(0).getEmail().toString()+ "\n");
					}
					if(name1.equals("John Parker") ) {
						searchArrayList.add(loc.getAllCustomers().get(1).getName().toString() + "\n");
						searchArrayList.add(loc.getAllCustomers().get(1).getBookname().toString()+ "\n");
						searchArrayList.add(loc.getAllCustomers().get(1).getEmail().toString()+ "\n");
					}
					if(name1.equals("Jill Aniston") ) {
						searchArrayList.add(loc.getAllCustomers().get(2).getName().toString() + "\n");
						searchArrayList.add(loc.getAllCustomers().get(2).getBookname().toString()+ "\n");
						searchArrayList.add(loc.getAllCustomers().get(2).getEmail().toString()+ "\n");
					}
					if(name1.equals("Peter Stone") ) {
						searchArrayList.add(loc.getAllCustomers().get(3).getName().toString() + "\n");
						searchArrayList.add(loc.getAllCustomers().get(3).getBookname().toString()+ "\n");
						searchArrayList.add(loc.getAllCustomers().get(3).getEmail().toString()+ "\n");
					}		
				}

				StringBuilder g = new StringBuilder("\n");
				int l=0;
				for(int z= 0; z< searchArrayList.size() ; z+=3) {
					l+= 1;
					g.append( l + ") " + "name :" + " " +searchArrayList.get(z));
					g.append("Bookname :" + " " + searchArrayList.get(z+1));
					g.append("Email :" + " " + searchArrayList.get(z+2));
					g.append("\n");

				}
				t.setText(g.toString());	
			}

		}

		if (e.getSource()== b6) {
			ArrayList<String> searchBookArrayList = new ArrayList<String>();

			String bookname = JOptionPane.showInputDialog(null,"Enter name of the book :");
			if (bookname != null) {  
				if(bookname.equals("The Great Gatsby")) {
					searchBookArrayList.add(ls.getAllBooks().get(0).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(0).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(0).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(0).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(0).getNumbooks().toString()+ "\n");
				}

				else if(bookname.equals("Macbeth")) {
					searchBookArrayList.add(ls.getAllBooks().get(1).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(1).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(1).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(1).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(1).getNumbooks().toString()+ "\n");
				}

				else if(bookname.equals("As you like it") ) {
					searchBookArrayList.add(ls.getAllBooks().get(2).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(2).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(2).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(2).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(2).getNumbooks().toString()+ "\n");
				}

				else if(bookname.equals("Sanjay Dutt") ) {
					searchBookArrayList.add(ls.getAllBooks().get(3).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(3).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(3).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(3).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(3).getNumbooks().toString()+ "\n");
				}
				else if(bookname.equals("The 100") ) {
					searchBookArrayList.add(ls.getAllBooks().get(4).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(4).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(4).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(4).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(4).getNumbooks().toString()+ "\n");
				}
				else if(bookname.equals("Looking for Alaska") ) {
					searchBookArrayList.add(ls.getAllBooks().get(5).getTitle().toString() + "\n");
					searchBookArrayList.add(ls.getAllBooks().get(5).getAuthor().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(5).getPages().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(5).getPublisher().toString()+ "\n");
					searchBookArrayList.add(ls.getAllBooks().get(5).getNumbooks().toString()+ "\n");
				}
				else if  (!"Macbeth".equals(bookname) ) {
					String bookname2 = JOptionPane.showInputDialog(null,"We do not have that book or Spell "
							+ "the name of the book wrong, " + "\n" + "Please enter the name again :");
					if(bookname2.equals("The Great Gatsby") ) {
						searchBookArrayList.add(ls.getAllBooks().get(0).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(0).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(0).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(0).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(0).getNumbooks().toString()+ "\n");
					}
					if(bookname2.equals("Macbeth") ) {
						searchBookArrayList.add(ls.getAllBooks().get(1).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(1).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(1).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(1).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(1).getNumbooks().toString()+ "\n");
					}
					if (bookname2.equals("As you like it") ) {
						searchBookArrayList.add(ls.getAllBooks().get(2).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(2).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(2).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(2).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(2).getNumbooks().toString()+ "\n");
					}
					if (bookname2.equals("Sanjay Dutt") ) {
						searchBookArrayList.add(ls.getAllBooks().get(3).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(3).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(3).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(3).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(3).getNumbooks().toString()+ "\n");
					}
					if (bookname2.equals("The 100") ) {
						searchBookArrayList.add(ls.getAllBooks().get(4).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(4).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(4).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(4).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(4).getNumbooks().toString()+ "\n");
					}
					if (bookname2.equals("Looking for Alaska") ) {
						searchBookArrayList.add(ls.getAllBooks().get(5).getTitle().toString() + "\n");
						searchBookArrayList.add(ls.getAllBooks().get(5).getAuthor().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(5).getPages().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(5).getPublisher().toString()+ "\n");
						searchBookArrayList.add(ls.getAllBooks().get(5).getNumbooks().toString()+ "\n");
					}
				}

				StringBuilder g = new StringBuilder("\n");
				int l=0;
				for(int z= 0; z< searchBookArrayList.size() ; z+=5) {
					l+= 1;
					g.append( l + ") " + "Bookname :" + " " +searchBookArrayList.get(z));
					g.append("Author :" + " " + searchBookArrayList.get(z+1));
					g.append("Page :" + " " + searchBookArrayList.get(z+2));
					g.append("Publisher :" + " " + searchBookArrayList.get(z+3));
					g.append("Number of books :" + " " + searchBookArrayList.get(z+4));
					g.append("\n");

				}
				t.setText(g.toString());	
			}
		}
		
		if (e.getSource()== b7) {
			ArrayList<String> addcustomerArrayList = new ArrayList<String>();

			String name = JOptionPane.showInputDialog(null,"Enter name of the customer :");
			String bookname = JOptionPane.showInputDialog(null,"Enter name of the book :");
			String email = JOptionPane.showInputDialog(null,"Enter email of the customer :");

			addcustomerArrayList.add((name));
			addcustomerArrayList.add((bookname));
			addcustomerArrayList.add((email) );

			StringBuilder m = new StringBuilder("\n");
			int l=0;
			for(int z= 0; z< addcustomerArrayList.size() ; z+=3) {
				l+= 1;
				m.append( l + ") " + "Name :" + " " +addcustomerArrayList.get(z) + "\n");
				m.append("Book :" + " " + addcustomerArrayList.get(z+1)+ "\n");
				m.append("Email :" + " " + addcustomerArrayList.get(z+2)+ "\n");
				m.append("\n");
			}

			t.setText(m.toString());

			try {
				fWriter = new FileWriter("customers.txt", true);
				if (addcustomerArrayList.get(0) != null && addcustomerArrayList.get(1) != null && addcustomerArrayList.get(2) != null) {
					fWriter.append("\n" + addcustomerArrayList.get(0) +"  " +
							addcustomerArrayList.get(1)+ "  " + addcustomerArrayList.get(2));
				}
				fWriter.close();
			}
			catch (IOException e2) {
				System.out.println("catch happened");
				e2.printStackTrace();
			}
		}

		if (e.getSource()== b8) {
			ArrayList<String> addbookArrayList = new ArrayList<String>();
			
			String bookname = JOptionPane.showInputDialog(null,"Enter name of the book :");
			String author = JOptionPane.showInputDialog(null,"Enter name of the author :");
			String pages = JOptionPane.showInputDialog(null,"Enter total pages of the book :");
			String publishers = JOptionPane.showInputDialog(null,"Enter name of the book's publishers :");
			String numberofbooks = JOptionPane.showInputDialog(null,"Enter total number of the book in inventory:");

			addbookArrayList.add((bookname));
			addbookArrayList.add((author));
			addbookArrayList.add((pages) );
			addbookArrayList.add((publishers));
			addbookArrayList.add((numberofbooks) );

			StringBuilder m = new StringBuilder("\n");
			int l=0;
			for(int z= 0; z< addbookArrayList.size() ; z+=5) {
				l+= 1;
				m.append( l + ") " + "Bookname :" + " " +addbookArrayList.get(z) + "\n");
				m.append("Author :" + " " + addbookArrayList.get(z+1)+ "\n");
				m.append("Pages :" + " " + addbookArrayList.get(z+2)+ "\n");
				m.append("Publishers :" + " " + addbookArrayList.get(z+3)+ "\n");
				m.append("Number of books :" + " " + addbookArrayList.get(z+4)+ "\n");
				m.append("\n");
			}

			t.setText(m.toString());

			try {
				fWriter = new FileWriter("books.txt", true);
				if (addbookArrayList.get(0) != null && addbookArrayList.get(1) != null
						&& addbookArrayList.get(2) != null && addbookArrayList.get(3) != null 
						&& addbookArrayList.get(4) != null) {
					fWriter.append("\n" + addbookArrayList.get(0) +"  " +
							addbookArrayList.get(1)+ "  " + addbookArrayList.get(2) +"  " +
							addbookArrayList.get(3)+ "  " + addbookArrayList.get(4));
				}
				fWriter.close();
			}
			catch (IOException e2) {
				System.out.println("catch happened");
				e2.printStackTrace();
			}
		}
	}
}
