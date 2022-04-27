import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UABhospitalsystem {
	
	private String filepath;
	private ArrayList<employee> listofArrayList  = new ArrayList<employee>();

	public UABhospitalsystem(String filepath) {
		this.filepath=filepath;
	
	}

	public void load () throws FileNotFoundException {

		File file = new File("uabEmployee.txt");
		Scanner in = new Scanner(file);

		while (in.hasNextLine()){
			Scanner in1 = new Scanner(in.nextLine());

			String name ;
			String type;
			int blazerid ;
			int num =0;
			String specials = null ;
			String operations = null;


			assert in1.hasNext(); 
			type = in1.next();

			assert in1.hasNext(); 
			name = in1.next();

			assert in1.hasNextInt();
			blazerid = in1.nextInt();


			if (in1.hasNextInt()) {
				num = in1.nextInt();

			}

			if (in1.hasNext()) {

				specials = in1.next();

			}

			if (in1.hasNext()) {

				operations = in1.next();

			}

			if (type.equals("D")) {
				doctors  doc = new doctors(name,type, blazerid, specials);
				this.listofArrayList.add(doc);

			}

			else if (type.equals("E") || (type.equals("H"))) {
				hospitalemployees1  hosp = new hospitalemployees1(name,type, blazerid);
				this.listofArrayList.add(hosp);

			}

			else if (type.equals("N")) {
				Nurse  nurse = new Nurse(name,type, blazerid, num);
				this.listofArrayList.add(nurse);

			}

			else if (type.equals("A")) {
				Administrator  admin= new Administrator(name, type, blazerid, specials);
				this.listofArrayList.add(admin);

			}

			else if (type.equals("J")) {
				Janitor  Janitor = new Janitor(name, type,  blazerid, specials, operations);
				this.listofArrayList.add(Janitor);

			}

			else if (type.equals("R")) {
				Receptionist recep = new Receptionist(name,type, blazerid, specials, operations);
				this.listofArrayList.add(recep);

			}	

			else if (type.equals("S")) {
				Surgeons surgeons = new Surgeons(name,type, blazerid, specials,operations);
				this.listofArrayList.add(surgeons);


			}
			else {
				this.listofArrayList.add(new employee(name, type, blazerid));
			}
		}
	}

	public void print() {

		ArrayList<String> a = new ArrayList<String>();
		a.add("Doctor");
		a.add("Nurse");
		a.add("Administrator");
		a.add("Hospital employees");
		a.add("Janitor");
		a.add("Receptionist");
		a.add("Surgeons");

		System.out.println("Total number of employee = " + listofArrayList.size() + "\n");


		for (int y = 0; y < a.size(); y++) {

			int count =0;

			for (int x =0; x < listofArrayList.size(); x++) {
				if (a.get(y).toString() == listofArrayList.get(x).getType()) {
					count ++;

				if (this.listofArrayList.get(x).noteString() == null && this.listofArrayList.get(x).note() == null ) {
					System.out.println( " Name = " + listofArrayList.get(x).getName().toString() +  
							"   Blazerid = " + listofArrayList.get(x).getBlazerid());
					}

				if(this.listofArrayList.get(x).noteString() != null && this.listofArrayList.get(x).note() != null) {
					System.out.println( " Name = " + listofArrayList.get(x).getName().toString() +  
							"   Blazerid = " + listofArrayList.get(x).getBlazerid() + listofArrayList.get(x).noteString() + " "
							+ listofArrayList.get(x).note() );
					}

				if (this.listofArrayList.get(x).noteString() == null && this.listofArrayList.get(x).note() != null ) {
					System.out.println( " Name = " + listofArrayList.get(x).getName().toString() +   
							"   Blazerid = " + listofArrayList.get(x).getBlazerid() + listofArrayList.get(x).note());
					}
				if (this.listofArrayList.get(x).noteString() != null && this.listofArrayList.get(x).note() == null ) {
					System.out.println( " Name = " + listofArrayList.get(x).getName().toString() +   
							"   Blazerid = " + listofArrayList.get(x).getBlazerid() + listofArrayList.get(x).noteString());
					}
				}
			}
			System.out.println(a.get(y).toString() + " = " +  count + "\n");
			System.out.println("**********************************************");
		}	
	}

	public void setemployeelist() {

		System.out.println("**********************************************");

		System.out.println("	welcome to the UAB Employee System");

		System.out.println("**********************************************");

		System.out.println("The UAB Hospital System has the following employees:" +"\n");

	}

	public void add () {
		String type;
		String name = null ;
		int Blazerid = 0;
		int num;
		String special;
		String Operation;

		Scanner sc = new Scanner(System.in);
		System.out.println("whom do you want to add, enter their type, name, blazerid and speciality ? ");
		type = sc.nextLine();
		name = sc.nextLine();
		Blazerid= Integer.parseInt(sc.nextLine());

		employee e;
		if(type.equals("Doctors")){
			special = sc.nextLine();
			e = new doctors (name,type, Blazerid, special);
			listofArrayList.add(e);

		}
		if(type.equals("Administrator")){
			special = sc.nextLine();
			e = new Administrator(name, type, Blazerid, special);
			listofArrayList.add(e);
		}
		if(type.equals("Nurse")){
			num = Integer.parseInt(sc.nextLine());
			e = new Nurse(name, type, Blazerid, num);
			listofArrayList.add(e);
		}
		if(type.equals("Janitor")){

			special = sc.nextLine();
			Operation = sc.nextLine();
			e = new Janitor(name,type, Blazerid, special, Operation);
			listofArrayList.add(e);
		}
		if(type.equals("Receptionist")){
			special = sc.nextLine();
			Operation = sc.nextLine();
			e = new Receptionist(name, type, Blazerid, special, Operation);
			listofArrayList.add(e);
		}
		if(type.equals("Surgeons")){
			special = sc.nextLine();
			Operation = sc.nextLine();
			e = new Surgeons(name, type, Blazerid, special, Operation);
			listofArrayList.add(e);
		}
		else {
			e= new employee(name, type, Blazerid);
		}


	}

	public void remove () {
		String type;
		int Blazerid = 0;


		Scanner sc = new Scanner(System.in);
		System.out.println("whom do you want to remove enter their type and blazerid ? ");
		type = sc.nextLine();
		Blazerid= Integer.parseInt(sc.nextLine());
		for(int i= 0 ; i < listofArrayList.size() ; i ++) {
			if (Blazerid == (listofArrayList.get(i).getBlazerid())) {
				listofArrayList.remove(i);
			}

		}

	}
	public void updateDB() throws IOException {
		FileWriter fw = new FileWriter("uabEmployee.txt");
		for (int i = 0 ; i <listofArrayList.size() ; i++) {
			if (this.listofArrayList.get(i).noteString() == null && this.listofArrayList.get(i).note() == null ) { 
				fw.write(listofArrayList.get(i).getType().charAt(0) +" "+listofArrayList.get(i).getName()+" "+listofArrayList.get(i).getBlazerid() 
						+  "\n");
			}
			if(this.listofArrayList.get(i).noteString() != null && this.listofArrayList.get(i).note() != null) {
				fw.write(listofArrayList.get(i).getType().charAt(0)+" "+ listofArrayList.get(i).getName().toString() +" "+ 
						listofArrayList.get(i).getBlazerid()+" "+listofArrayList.get(i).noteString().split("=")[1]+" "+listofArrayList.get(i).note().split("=")[1] + "\n");
			}

			if (this.listofArrayList.get(i).noteString() == null && this.listofArrayList.get(i).note() != null ) {
				fw.write(listofArrayList.get(i).getType().charAt(0)+" "+listofArrayList.get(i).getName().toString() +" "+
						listofArrayList.get(i).getBlazerid() +" "+listofArrayList.get(i).note().split("=")[1]+ "\n");
			}

			if (this.listofArrayList.get(i).noteString() != null && this.listofArrayList.get(i).note() == null ) {
				fw.write(listofArrayList.get(i).getType().charAt(0)+" "+listofArrayList.get(i).getName().toString() +   
						" " + listofArrayList.get(i).getBlazerid()+" "+listofArrayList.get(i).noteString().split("=")[1]+ "\n");
			}

		}
		fw.close();
	}
}

