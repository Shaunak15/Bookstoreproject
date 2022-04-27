
public class Janitor extends employee{
	private String specials;
	private String operations;

	public Janitor(String name,String type, int blazerid, String special, String operation) {
		super(name, "Janitor", blazerid);
		this.specials = special;
		this.operations = operation;

	}
	public String noteString() {
		return (" Department = " + specials);

	}

	public String note() {
		return (" Sweeping =" + operations);

	}
}

