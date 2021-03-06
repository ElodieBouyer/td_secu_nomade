package smali;

import java.util.ArrayList;
import java.util.List;

public class InformationClass {

	private String name; // Nom de la classe.
	private List<InformationMethod> listMethod = new ArrayList<InformationMethod>(); // Liste des méthodes de la classe.
	private List<InformationField> listField = new ArrayList<InformationField>(); // Liste des champs de la classe.

	public void setName(String name) {
		this.name = name;
	}
	
	public void addMethod(String name, String access) {		
		listMethod.add(new InformationMethod(name, access));
	}
	
	public void addField(String name, String access, String type) {
		listField.add(new InformationField(name, access, type));
	}
	
	public String getInfo() {
		String info = "Nom de la classe = ";
		info += this.name;
		info += "\n";
		
		int nb = 1;
		for(InformationMethod m : listMethod) {
			info += "  Méthode " + nb + " : ";
			info += m.getName();
			info += "\n";
			info += "    Access : ";
			info += m.getAccess();
			nb++;
			info += "\n \n";
		}
		
		int nb2 = 1;
		for(InformationField f : listField) {
			info += "  Champs " + nb2 + " : ";
			info += f.getName();
			info += "\n";
			info += "    Access : ";
			info += f.getAccess();
			info += "\n";
			info += "    Type : ";
			info += f.getType();
			nb2++;
			info += "\n \n";
		}
		
		return info;
	}
	
	
}
