import java.io.*;
import java.util.*;

/**
 * The <code>Solver</code> class is the main runner of the "Chem Helper" program. It provides the user
 * with information on elements, molecules, molecule groups, and equations. It includes databases of
 * elements, molecules, and equations which contain characteristics of the most common inputs.
 * @author Justin
 *
 */
public class Solver extends Databases {
	
	private String expression;
	private String type;
	
	
	public Solver() {
		expression = "";
		type = "";
	}
	
	
	/**
	 * The <code>setExpression</code> method sets the <code>expression</code> string to a new value.
	 * @param <code>String</code>
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
	/**
	 * The <code> getType</code> method returns the type of the equation, which can be:<br>an element
	 * <br>a molecule<br>a molecule group<br>an equation
	 * @return <code>String</code>
	 */
	public String getType() {
		return type;
	}
	
	
	/**
	 * The <code>calculateType</code> method determines the type of the chemical expression.
	 * @param <code>String</code>
	 * @return <code>String</code>
	 */
	public String calculateType(String str) {
		// counter for number of capital letters (indicates number of elements)
		int numCapitals = 0;
		// check if the expression is an equation (if the "->" substring can be found)
		for (int i = 0; i < str.length()-1; i++) {
			if (str.substring(i, i+2).equals("->")) {
				return "equation";
			}
		}
		for (int i = 0; i < str.length(); i++) {
			// check if the expression is a molecule group (if the '+' character can be found)
			if (str.charAt(i) == '+') {
				return "molecules";
			}
			// implement the numCapitals counter
			if (str.charAt(i) == str.toUpperCase().charAt(i)) {
				numCapitals++;
			}
		}
		// check if the expression is a molecule (if there are multiple elements)
		if (numCapitals > 1) {
			return "molecule";
		}
		// check if the expression is a molecule (if there is a single element)
		if (numCapitals == 1) {
			return "element";
		}
		// return null if the expression does not fit into a type
		return "error";
	}
	
	
	/** The <code>solveEquation</code> class prints out the balanced form of a chemical equation and any
	 * relevant information.
	 */
	public void solveEquation() {
		Equation e = equationList.get(expression);
		if (e == null) {
			System.out.println(expression + " not in database.");
			return;
		}
		e.balanceEquation();
		System.out.println(e.toString());
	}
	
	
	/**
	 * The <code>solveMoleculeGroup</code> class prints out the relevant information for each individual
	 * molecule of a molecule group.
	 */
	public void solveMoleculeGroup() {
		// divide molecule group into an ArrayList of Strings
		MolecList molecules = new MolecList();
		// use the marker index to save the last place that was cut off
		int markerIndex = 0;
		for (int i = 0; i < expression.length(); i++) {
			// loop through expression until '+' is found
			if (expression.charAt(i) == '+') {
				// add molecule substring to the ArrayList
				molecules.add(new Molecule(expression.substring(markerIndex, i)));
				// move the marker
				markerIndex = i + 1;
			}
		}
		molecules.add(new Molecule(expression.substring(markerIndex, expression.length())));
		
		
		// loop through the ArrayList of molecule strings and print out their information
		for (Molecule m : molecules) {
			System.out.println(m.toString());
		}
		
		// loop through equation database to find an equation
		for (int i = 0; i < equationList.size(); i++) {
			if (expression.equals(equationList.get(i).getReactants())) {
				System.out.println(expression + " is identified as the reactant of a chemical formula.");
				System.out.println(equationList.get(i).toString() + "\n");
				return;
			}
			if (expression.equals(equationList.get(i).getProducts())) {
				System.out.println(expression + " is identified as the product of a chemical formula.");
				System.out.println(equationList.get(i).toString() + "\n");
				i = equationList.size();
				return;
			}
		}
		System.out.println("Molecule group cannot be identified as either a product or a reactant in the equation database.\n");
		
	}
	
	
	/**
	 * The <code>solveMolecule</code> class prints out the relevant information for a single molecule.
	 */
	public void solveMolecule() {
		Molecule m = new Molecule(expression);
		System.out.println(m.toString());
		// loop through equation database to find an equation
		for (int i = 0; i < equationList.size(); i++) {
			if (expression.equals(equationList.get(i).getReactants())) {
				System.out.println(expression + " is identified as the reactant of a chemical formula.");
				System.out.println(equationList.get(i).toString() + "\n");
				return;
			}
			if (expression.equals(equationList.get(i).getProducts())) {
				System.out.println(expression + " is identified as the product of a chemical formula.");
				System.out.println(equationList.get(i).toString() + "\n");
				i = equationList.size();
				return;
			}
		}
		System.out.println("Molecule cannot be identified as either a product or a reactant in the equation database.\n");
				
		
	}
	
	
	/**
	 * The <code>solveElement</code> class prints out the relevant information for a single molecule. It
	 * finds the location of the element's code in the element database.
	 */
	public void solveElement() {
		Element e = elementList.get(expression);
		if (e == null) {
			System.out.println(expression + " not in element database.\n");
			return;
		}
		System.out.println(e.toString() + "\n");
	}
	
	
	/**
	 * The <code>printError</code> method prints an error message for incorrect or improperly formatted
	 * expressions.
	 */
	public void printError() {
		System.out.println("The inputted expression was not a valid expression. Please follow the following format.");
		System.out.println("To access information on an element, enter the element's code (e.g. 'C', 'Lr')");
		System.out.println("To access information on a molecule, enter the molecule's code (e.g. 'CO2', '2NH4')");
		System.out.println("To access information on a group of molecules, enter the molecule group's code (e.g. 'N2+4H2')");
		System.out.println("To access information on an equation, enter the equation (e.g. 'N2+4H2->2NH4')\n");
		
	}
	
	
	/**
	 * The <code>solve</code> method prints out relevant information for a chemical expression.
	 */
	public void solve() {
		type = calculateType(expression);
		switch (type) {
			case "equation": solveEquation();
				break;
			case "molecules": solveMoleculeGroup();
				break;
			case "molecule": solveMolecule();
				break;
			case "element": solveElement();
				break;
			default: printError();
				break;
		}
	}
	
	
	/**
	 * The <code>getInput</code> method utilizes a <code>BufferedReader</code> to get user input for
	 * a chemical expression.
	 * @throws IOException
	 */
	public void getInput() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.println("What is the chemical expression? (Enter an element, molecule, molecule group, or chemical equation)");
		setExpression(input.readLine());
		solve();
	}
	
	
	public static void main(String[] args) throws IOException {
		readInFormulas();
		readInElements();
		Solver mySolver = new Solver();
		while (1 == 1) {
			mySolver.getInput();
		}
	}
	
}