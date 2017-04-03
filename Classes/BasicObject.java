
/**
 * The <code>BasicObject</code> is a template for the <code>Element</code> and <code>Molecule</code>
 * classes. It holds <code and name
 * @author Justin
 *
 */
public class BasicObject extends Databases {
	
	private String code;
	private String name;
	
	public BasicObject(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public BasicObject(String name) {
		code = "";
		this.name = name;
	}
	
	public BasicObject() {
		code = "";
		name = "";
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean isCode(String str) {
		return str.equals(code);
	}
	
}
