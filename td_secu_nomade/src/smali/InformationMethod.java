package smali;

public class InformationMethod {
	
	private String name;
	private String access;
	
	public InformationMethod(String name, String access) {
		this.name = name;
		this.access = access;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}
	/**
	 * @param access the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}
}
