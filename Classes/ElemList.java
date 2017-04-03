import java.util.*;

/**
 * The <code>ElemList</code> class stores an <code>ArrayList</code> of <code>Element</code> objects.
 * The <code>get</code> method searches through the <code>ArrayList</code> to find an element given
 * the name. The method returns a null if the element is not in the list.
 * @author Justin
 *
 */
public class ElemList extends ArrayList<Element> {
	
	public ElemList() {
		super();
	}
	
	public Element get(String str) {
		for (int i = 0; i < size(); i++) {
			if (get(i).isCode(str)) {
				return get(i);
			}
		}
		return null;
	}
}
