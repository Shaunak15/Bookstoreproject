import java.io.IOException;
import java.util.Scanner;

public class hospitalemployees  {


	public static void main(String[] args) throws IOException {
		UABhospitalsystem UABhs =  new UABhospitalsystem ("uabEmployee.txt");

		UABhs.load();

		boolean okay = false;
		int key;
		while (!okay) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("\n(1)Employee list , (2)Add employee, (3)Remove employee, (4)Update the database , (0)Exit");
			key = scanner.nextInt();

			switch (key) {
			case 0:
				okay = true;
				System.out.println( "Thank you for visiting UAB employee System");
				break;


			case 1:
				UABhs.setemployeelist();
				UABhs.print();
		
				
				break;
			case 2:
				UABhs.add();
				break;
				
				
			case 3 :
				UABhs.remove();
				break;
			
				
			case 4:
				UABhs.updateDB();
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
				
			}
		}
	}


}




