package smali;

public class InformationField {

	private String name;
	private String access;
	private String type;
	
	public InformationField(String name, String access, String type) {
		super();
		this.name = name;
		this.access = access;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
}
