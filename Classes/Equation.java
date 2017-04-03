
/**
 * The <code>Equation</code> class stores the reactants, products, equation, and reversibility of a
 * chemical equation. The constructor takes form (MolecList reactants, MolecList products, boolean
 * reversible) or can be empty. All data can be returned as a <code>String</code>
 * with the <code>toString</code> class.
 * @author Justin
 *
 */
public class Equation {
	
	private MolecList reactants = new MolecList();
	private MolecList products = new MolecList();
	private String equation = "";
	private int numReactants;
	private int numProducts;
	private int UserCoefficient = 0;
	
	public Equation(MolecList reactants, MolecList products) {
		this.reactants = reactants;
		this.products = products;
		numReactants = reactants.size();
		numProducts = products.size();
		equation = balanceEquation();
	}
	
	public Equation() {
		numReactants = 0;
		numProducts = 0;
	}
	
	public String balanceEquation() {
		String returnStr = "";
		UserCoefficient = 0;
		for (int i = 0; i < equation.length(); i++) {
	        if (equation.charAt(i) >= 48 && equation.charAt(i) < 58) {
	        	UserCoefficient = (UserCoefficient*10) + (equation.charAt(i)-48);
	        } else {
	        	i = equation.length();
	        }
		}
        String[] molNames = new String [getTotalTerms()];
        for (int i = 0; i < numReactants; i++) {
        	molNames[i] = reactants.get(i).getCode();
        }
        for (int i = 0; i < numProducts; i++) {
        	molNames[i+numReactants] = products.get(i).getCode();
        }
        int[] molNums = new int[getTotalTerms()];
        for (int i = 0; i < numReactants; i++) {
        	molNums[i] = reactants.get(i).getCoefficient();
        }
        for (int i = 0; i < numProducts; i++) {
        	molNums[i+numReactants] = products.get(i).getCoefficient();
        }
        
        int UserIndex = 0;
        for (int i = 0; i < molNames.length; i++) {
            if (equation == molNames[i]) {
                UserIndex = i;
            }     
        }
        int factor = UserCoefficient/molNums[UserIndex];
        for (int x = 0; x < molNums.length; x++) {
           molNums[x] = factor * molNums[x];
        }
        int y;
        for (y = 1; y < getTotalTerms(); y++) {
        	//
        	String cutStr= Integer.toString(molNums[y-1]) + molNames[y-1];
            returnStr += cutStr.substring(1,cutStr.length());
            if(y==numReactants){ 
                returnStr += "->";
            } else {
                returnStr += "+";
            }
        }
		String cutStr= Integer.toString(molNums[y-1]) + molNames[y-1];
		returnStr += cutStr.substring(1);
        return returnStr;
	}
	
	public int getNumReactants() {
		return numReactants;
	}
	
	public int getNumProducts() {
		return numProducts;
	}
	
	public int getTotalTerms() {
		return numReactants + numProducts;
	}
	
	public String getReactants() {
		String str = reactants.get(0).getCode();
		for (int i = 1; i < reactants.size(); i++) {
			str = str + "+" + reactants.get(i).getCode();
		}
		return str;
	}
	
	public String getProducts() {
		String str = products.get(0).getCode();
		for (int i = 1; i < products.size(); i++) {
			str = str + "+" + products.get(i).getCode();
		}
		return str;
	}
	
	public String getEquation() {
		return equation;
	}
	
	public boolean isEquation(String str) {
		return str.equals(equation);
	}
	
	public String toString() {
		return "Balanced Equation: " + equation + "\nReactants: " + getReactants() + "\nProducts: " + getProducts();
	}
	
}
