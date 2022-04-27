
public class Surgeons extends employee{
	private String specials;
	private String operations;
	public Surgeons(String name,String type, int blazerid,String special, String operation) {
		super(name, "Surgeons", blazerid);
		this.specials = special;
		this.operations = operation;

	}
	public String noteString() {
		return (" Specialty  = " + specials); 
	}

	public String note() {
		return (" operating = " + operations);
	}
}
