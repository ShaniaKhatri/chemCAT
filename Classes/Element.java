
/**
 * The <code>Element</code> class stores the name, atomic number, atomic mass, protons, neutrons,
 * and electrons of an element. The atomic number, protons, and electrons are stored in a single variable
 * <code>number</code>. The constructor takes form (int number, int neutrons, double atomicMass,
 * String code, String name) or can be empty. All data can be returned as a <code>String</code>
 * with the <code>toString</code> class.
 * @author Justin
 *
 */
public class Element extends BasicObject {
	
	private int number;
	private int neutrons;
	private double atomicMass;
	private String properties;
	
	public Element(int number, int neutrons, double atomicMass, String code, String name, String properties) {
		super(code, name);
		this.number = number;
		this.neutrons = neutrons;
		this.atomicMass = atomicMass;
		this.properties = properties;
	}
	
	public Element(String name) {
		super(name);
	}
	
	public Element() {
		super();
		number = 0;
		neutrons = 0;
		atomicMass = 0;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getNeutrons() {
		return neutrons;
	}
	
	public double getAtomicMass() {
		return atomicMass;
	}
	
	public String getProperties() {
		return properties;
	}
	
	public String toString() {
		return "Element: " + super.getName() + "\nCode: " + super.getCode() + "\nAtomic Number: " + getNumber() + "\nAtomic Mass: " + getAtomicMass() + "\nProtons: " + getNumber() + "\nNeutrons: " + getNeutrons() + "\nElectrons: " + getNumber() + getProperties();
	}
}
