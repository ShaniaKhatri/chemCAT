// only necessary if we use a molecule database
import java.util.*;

/**
 * The <code>MolecList</code> class stores an <code>ArrayList</code> of <code>Molecule</code> objects.
 * The <code>get</code> method searches through the <code>ArrayList</code> to find an element given
 * the name. The method returns a null if the element is not in the list.
 * @author Justin
 *
 */
public class MolecList extends ArrayList<Molecule> {
	
	public MolecList() {
		super();
	}
	
	public Molecule get(String str) {
		for (int i = 0; i < size(); i++) {
			if (get(i).isCode(str)) {
				return get(i);
			}
		}
		return null;
	}
	
}
