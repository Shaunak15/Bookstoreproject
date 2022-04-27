
public class Nurse extends employee{
	private int num;
	public Nurse(String name,String type, int blazerid, int num) {
		super(name, "Nurse", blazerid);
		this.num = num;
	}


	public String noteString() {

		return (" Number of Patients =" + num);
	}
}
