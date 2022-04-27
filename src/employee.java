public class employee {
	private String name;
	private int blazerid;
	private String type;

	public employee (String name , String type, int blazerid) {
		this.name =name;
		this.type = type;
		this.blazerid = blazerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBlazerid() {
		return blazerid;
	}

	public void setBlazerid(int blazerid) {
		this.blazerid = blazerid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String noteString() {
		return null;
	}

	public String note() {
		return null;
	}


}
