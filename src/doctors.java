

public class doctors extends employee {
	private String specials;


	public doctors(String name, String type ,int blazerid, String special) {
		super(name, "Doctor", blazerid);
		this.specials = special;
	}


	public String noteString() {
		return (" Speciality = " + specials);

	}

}	

