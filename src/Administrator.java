
public class Administrator extends employee {
	private String specials;


	public Administrator(String name, String type, int blazerid, String special) {
		super(name, "Administrator", blazerid);
		this.specials = special;

	}
	public String noteString() {
		return (" Department = " + specials);
	}
}
