

public class Receptionist extends employee {

	private String specials;
	private String operations;

	public Receptionist(String name,String type, int blazerid,String special, String operation) {
		super(name, "Receptionist", blazerid);
		this.specials = special;
		this.operations =operation;

	}
	public String noteString() {
		return (" Department = " + specials ); 
	}

	public String note() {
		return (" Answering = " + operations);
	}
}
