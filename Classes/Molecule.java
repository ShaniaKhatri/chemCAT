
/**
 * The <code>Molecule</code> class stores the code of a molecule. The atomic number, protons,
 * and electrons are stored in a single variable <code>number</code>. The constructor takes form
 * (String code) or can be empty. The molecule code and data of the molecule's individual elements
 * can be returned as a <code>String</code> with the <code>toString</code> class.
 * @author Justin
 *
 */
public class Molecule extends BasicObject {
	
	private ElemList elements = new ElemList();
	private int coefficient;

	public Molecule(String code) {
		super.setCode(code);
		coefficient = deleteCoefficient(code);
	}
	
	public Molecule() {
		super();
		coefficient = 0;
	}
	
	public int deleteCoefficient(String str) {
		int c = 0;
		while (str.charAt(0) >= 48 && str.charAt(0) < 58) {
			c = str.charAt(0) - 48;
			str = str.substring(1, str.length());
		}
		return (c == 0) ? 1 : c;
	}
	
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	public int getCoefficient() {
		return coefficient;
	}
	
	public void parseCode() {
		String str = super.getCode();
		int markerIndex = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			while (str.charAt(i) >= 48 && str.charAt(i) < 58) {
				str = str.substring(0, i) + str.substring(i+1, str.length());
			}
		}
		if (str.charAt(str.length()-1) >= 48 && str.charAt(str.length()-1) < 58) {
			str = str.substring(0, str.length()-1);
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.toUpperCase().charAt(i) == str.charAt(i)) {
				markerIndex = i;
				Element newElement = elementList.get(str.substring(markerIndex, i+1));
				elements.add(newElement);
			}
		}
	}
	
	public String getFullCode() {
		return coefficient + getCode();
	}
	
	public String toString() {
		parseCode();
		String elementInfo = "";
		for (Element e : elements) {
			if (e == null) {
				elementInfo += "Element not in database\n\n";
			} else {
				elementInfo += e.toString() + "\n\n";
			}
		}
		return "Name: " + getCode() + "\nCoefficient: " + coefficient + "\n\n" + elementInfo;
	}
	
}
