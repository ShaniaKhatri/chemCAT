// only necessary if we use a molecule database
import java.util.*;

/**
 * The <code>EquatList</code> class stores an <code>ArrayList</code> of <code>Equation</code> objects.
 * The <code>get</code> method searches through the <code>ArrayList</code> to find an element given
 * the name. The method returns a null if the element is not in the list.
 * @author Justin
 *
 */
public class EquatList extends ArrayList<Equation> {
	
	public EquatList() {
		super();
	}
	
	public Equation get(String str) {
		for (int i = 0; i < size(); i++) {
			if (get(i).isEquation(str)) {
				return get(i);
			}
		}
		return null;
	}
	
}
